package com.mawatani.daystill.Database

import androidx.room.*
import java.util.*

@Entity(tableName = "days_till_table")
data class EventItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val timeCount: Int,
    val dateCreated: Date,
    val repetitionCat: Int,
    val colour: Int
) {
    // TODO: 10/6/21 Add date conversion class for database
}