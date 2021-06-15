package com.mawatani.daystill.model

import androidx.lifecycle.*
import com.mawatani.daystill.database.DaysTillRepo
import com.mawatani.daystill.database.EventItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(private val repo: DaysTillRepo) : ViewModel() {

    //Obtain live data from the repo which allows us to
    //observe the data and update ui only whe data changes
    val allEvents : LiveData<List<EventItem>> = repo.allEvents.asLiveData()

    //coroutine to insert eventItem
    fun insert(item: EventItem) = viewModelScope.launch {
        repo.insert(item)
    }

}

class MainViewModelFactory(private val repo: DaysTillRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}