/*
 * Copyright (c) 2021 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 * 
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dev.damodaran.testnavigation.jetnotes.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import dev.damodaran.testnavigation.jetnotes.data.database.dao.ColorDao
import dev.damodaran.testnavigation.jetnotes.data.database.dao.NoteDao
import dev.damodaran.testnavigation.jetnotes.data.database.dbmapper.DbMapper
import dev.damodaran.testnavigation.jetnotes.data.database.model.ColorDbModel
import dev.damodaran.testnavigation.jetnotes.data.database.model.NoteDbModel
import dev.damodaran.testnavigation.jetnotes.domain.model.ColorModel
import dev.damodaran.testnavigation.jetnotes.domain.model.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * {@inheritDoc}
 */
class RepositoryImpl(
  private val noteDao: NoteDao,
  private val colorDao: ColorDao,
  private val dbMapper: DbMapper
) : Repository {

  private val notesNotInTrashLiveData: MutableLiveData<List<NoteModel>> by lazy {
    MutableLiveData<List<NoteModel>>()
  }

  private val notesInTrashLiveData: MutableLiveData<List<NoteModel>> by lazy {
    MutableLiveData<List<NoteModel>>()
  }

  init {
    initDatabase(this::updateNotesLiveData)
  }

  /**
   * Populates database with colors if it is empty.
   */
  private fun initDatabase(postInitAction: () -> Unit) {
    GlobalScope.launch {
      // Prepopulate colors
      val colors = ColorDbModel.DEFAULT_COLORS.toTypedArray()
      val dbColors = colorDao.getAllSync()
      if (dbColors.isNullOrEmpty()) {
        colorDao.insertAll(*colors)
      }

      // Prepopulate notes
      val notes = NoteDbModel.DEFAULT_NOTES.toTypedArray()
      val dbNotes = noteDao.getAllSync()
      if (dbNotes.isNullOrEmpty()) {
        noteDao.insertAll(*notes)
      }

      postInitAction.invoke()
    }
  }

  override fun getAllNotesNotInTrash(): LiveData<List<NoteModel>> = notesNotInTrashLiveData

  override fun getAllNotesInTrash(): LiveData<List<NoteModel>> = notesInTrashLiveData

  private fun getAllNotesDependingOnTrashStateSync(inTrash: Boolean): List<NoteModel> {
    val colorDbModels: Map<Long, ColorDbModel> = colorDao.getAllSync().map { it.id to it }.toMap()
    val dbNotesNotInTrash: List<NoteDbModel> =
      noteDao.getAllSync().filter { it.isInTrash == inTrash }
    return dbMapper.mapNotes(dbNotesNotInTrash, colorDbModels)
  }

  override fun getNote(id: Long): LiveData<NoteModel> =
    Transformations.map(noteDao.findById(id)) {
      val colorDbModel = colorDao.findByIdSync(it.colorId)
      dbMapper.mapNote(it, colorDbModel)
    }

  override fun insertNote(note: NoteModel) {
    noteDao.insert(dbMapper.mapDbNote(note))
    updateNotesLiveData()
  }

  override fun deleteNote(id: Long) {
    noteDao.delete(id)
    updateNotesLiveData()
  }

  override fun deleteNotes(noteIds: List<Long>) {
    noteDao.delete(noteIds)
    updateNotesLiveData()
  }

  override fun moveNoteToTrash(noteId: Long) {
    val dbNote = noteDao.findByIdSync(noteId)
    val newDbNote = dbNote.copy(isInTrash = true)
    noteDao.insert(newDbNote)
    updateNotesLiveData()
  }

  override fun restoreNotesFromTrash(noteIds: List<Long>) {
    val dbNotesInTrash = noteDao.getNotesByIdsSync(noteIds)
    dbNotesInTrash.forEach {
      val newDbNote = it.copy(isInTrash = false)
      noteDao.insert(newDbNote)
    }
    updateNotesLiveData()
  }

  override fun getAllColors(): LiveData<List<ColorModel>> =
    Transformations.map(colorDao.getAll()) { dbMapper.mapColors(it) }

  override fun getAllColorsSync(): List<ColorModel> = dbMapper.mapColors(colorDao.getAllSync())

  override fun getColor(id: Long): LiveData<ColorModel> =
    Transformations.map(colorDao.findById(id)) { dbMapper.mapColor(it) }

  override fun getColorSync(id: Long): ColorModel = dbMapper.mapColor(colorDao.findByIdSync(id))

  private fun updateNotesLiveData() {
    notesNotInTrashLiveData.postValue(getAllNotesDependingOnTrashStateSync(false))
    val newNotesInTrashLiveData = getAllNotesDependingOnTrashStateSync(true)
    notesInTrashLiveData.postValue(newNotesInTrashLiveData)
  }
}