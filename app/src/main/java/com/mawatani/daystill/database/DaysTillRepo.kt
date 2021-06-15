package com.mawatani.daystill.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class DaysTillRepo(private val eventDao: EventDao) {

    val allEvents: Flow<List<EventItem>> = eventDao.getAllEventItems()

    //Room automatically runs queries off the main thread
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(item: EventItem){
        eventDao.insertItem(item)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(item: EventItem){
        eventDao.deleteItem(item)
    }
}