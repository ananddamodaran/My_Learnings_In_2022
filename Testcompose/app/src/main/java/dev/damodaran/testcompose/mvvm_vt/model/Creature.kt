package dev.damodaran.testcompose.mvvm_vt.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "creature_table")
data class Creature(
    val attributes: CreatureAttributes = CreatureAttributes(),
    val hitPoints: Int = 0,
    @PrimaryKey @NonNull val name: String,
    val drawable: Int = 0
)