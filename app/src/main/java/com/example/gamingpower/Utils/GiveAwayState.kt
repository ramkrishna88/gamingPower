package com.example.gamingpower.Utils


import com.example.gamingpower.Model.GiveAwayItem

sealed class GiveawayState {
    object LOADING : GiveawayState()
    class SUCCESS<T>(val giveaways: T, isLocalData: Boolean = false) : GiveawayState()
    class ERROR(val error: Throwable) : GiveawayState()
}
