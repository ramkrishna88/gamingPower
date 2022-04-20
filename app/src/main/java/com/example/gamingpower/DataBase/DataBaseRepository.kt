package com.example.gamingpower.DataBase


import com.example.gamingpower.Model.GiveAwayItem
import com.example.gamingpower.Rest.GiveawaysService

interface DatabaseRepository {
    suspend fun insertGiveaways(newGiveaways: List<GiveAwayItem>)
    suspend fun getAllGiveaways(): List<GiveAwayItem>
    suspend fun getGiveawaysById(searchId: Int): GiveAwayItem
    suspend fun getGiveawaysByPlatform(platform: String): List<GiveAwayItem>
    suspend fun deleteGiveaways(giveaways: List<GiveAwayItem>)
}

class DatabaseRepositoryImpl(
    private val giveawaysDatabase: GiveawaysService
) : DatabaseRepository {

    override suspend fun insertGiveaways(newGiveaways: List<GiveAwayItem>) =
        giveawaysDatabase.insertGiveaways(newGiveaways)

    override suspend fun getAllGiveaways(): List<GiveAwayItem> {
        return giveawaysDatabase.getAllGiveaways()
    }

    override suspend fun getGiveawaysById(searchId: Int): GiveAwayItem {
        return giveawaysDatabase.getGiveawaysById(searchId)
    }

    override suspend fun getGiveawaysByPlatform(platform: String): List<GiveAwayItem> {
        return giveawaysDatabase.getGiveawaysByPlatform(platform)
    }

    override suspend fun deleteGiveaways(giveaways: List<GiveAwayItem>) {
        return giveawaysDatabase.deleteGiveaways(giveaways)
    }

}