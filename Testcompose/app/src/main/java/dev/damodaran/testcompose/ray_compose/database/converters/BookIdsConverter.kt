package dev.damodaran.testcompose.ray_compose.database.converters

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import dev.damodaran.testcompose.ray_compose.LibrarianApp

class BookIdsConverter {
    @TypeConverter
    fun fromBookIds(list: List<String>): String? = LibrarianApp.gson.toJson(list)

    @TypeConverter
    fun toBookIds(json: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type

        return try {
            LibrarianApp.gson.fromJson(json, listType)
        } catch (error: Throwable) {
            emptyList()
        }
    }
}