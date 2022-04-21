package com.example.gamingpower.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.example.gamingpower.DataBase.DatabaseRepository
import com.example.gamingpower.Rest.GiveawaysRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: GiveawaysRepository,
   private val  databaseRepository: DatabaseRepository,
   private val coroutineDispatcher: CoroutineDispatcher
): ViewModelProvider.Factory{

    fun<T : GiveawaysViewModel?> create (modelClass: Class<T>) : GiveawaysViewModel {
        return GiveawaysViewModel(
            repository,
            databaseRepository,
            coroutineDispatcher,)
    }}
