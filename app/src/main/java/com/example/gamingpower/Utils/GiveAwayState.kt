package com.example.gamingpower.Utils


import com.example.gamingpower.Model.GiveAwayItem

sealed class GiveAwayState {
    object LOADING : GiveAwayState()
    class SUCCESS<T>(val GiveAwayItem: T, isLocalData: Boolean = false) : GiveAwayState()
    class ERROR(val   error: Throwable) : GiveAwayState()
}
