package com.example.gamingpower.ViewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamingpower.DataBase.DatabaseRepository
import com.example.gamingpower.Rest.GiveawaysRepository
import com.example.gamingpower.Utils.PlatformType
import com.example.gamingpower.Utils.SortType
import com.example.gamingpower.Utils.GiveAwayState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class GiveawaysViewModel @Inject constructor(
    private val Rest: GiveawaysRepository,
    private val databaseRepo: DatabaseRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    var platform: PlatformType = PlatformType.ANDROID

    private val _sortedGiveaways: MutableLiveData<GiveAwayState> =
        MutableLiveData(GiveAwayState.LOADING)
    val giveAway: LiveData<GiveAwayState> get() = _sortedGiveaways

    fun getSortedGiveaways(sortBy: SortType = SortType.DATE) {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = Rest.getAllGiveaways(sortBy)
                if (response.isSuccessful) {
                    response.body()?.let {
                        databaseRepo.insertGiveaways(it)
                        val localData = databaseRepo.getAllGiveaways()
                        _sortedGiveaways.postValue(GiveAwayState.SUCCESS(localData))
                    } ?: throw Exception("Response in null")
                } else {
                    throw Exception("No successful response")
                }
            } catch (e: Exception) {
                // we catch all errors
                _sortedGiveaways.postValue(GiveAwayState.ERROR(e))
                loadFromDB()
            }
        }
    }

    private suspend fun loadFromDB() {
        try {
            val localData = databaseRepo.getAllGiveaways()
            _sortedGiveaways.postValue(GiveAwayState.SUCCESS(localData, isLocalData = true))
        } catch (e: Exception) {
            _sortedGiveaways.postValue(GiveAwayState.ERROR(e))
        }
    }

    fun getGiveawaysByPlatform() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = Rest.getGiveawaysByPlatform(platform)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _sortedGiveaways.postValue(GiveAwayState.SUCCESS(it))
                    } ?: throw Exception("Response in null")
                } else {
                    throw Exception("No successful response")
                }
            } catch (e: Exception) {
                _sortedGiveaways.postValue(GiveAwayState.ERROR(e))
            }
        }

        viewModelScope.async {

        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GiveawaysViewModel", "REMODEL destroyed")
    }
}
