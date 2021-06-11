package com.mawatani.daystill.Database

import androidx.room.*
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM days_till_table")
    fun getAllEventItems(): Flow<List<EventItem>>

    //Query an individual item using its id
    @Query("SELECT * FROM days_till_table WHERE id = :iD")
    fun selectEventItemById(iD: Int):EventItem

    /**
     * Insert individual item
     * Need to add more than 1 for debugging
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(eventItem: EventItem)

    //delete individual event item
    @Delete
    suspend fun deleteItem(eventItem: EventItem)

    @Query("DELETE FROM days_till_table")
    suspend fun deleteAll()
}