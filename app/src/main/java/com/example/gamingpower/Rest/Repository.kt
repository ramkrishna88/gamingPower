package com.example.gamingpower.Rest

import androidx.appcompat.resources.Compatibility
import com.example.gamingpower.Model.GiveAwayItem
import com.example.gamingpower.Utils.PlatformType
import com.example.gamingpower.Utils.SortType
import retrofit2.Response
import java.util.concurrent.Flow

interface GiveawaysRepository {
    suspend fun getAllGiveaways(sortedBy: SortType): Response<List<GiveAwayItem>>
    suspend fun getGiveawaysByPlatform(platform: PlatformType): Response<List<GiveAwayItem>>
}

class GiveawaysRepositoryImpl(
    private val giveawaysService: GiveawaysService
) : GiveawaysRepository {

    override suspend fun getAllGiveaways(sortedBy: SortType): Response<List<GiveAwayItem>> =
        giveawaysService.getAllGiveaways(sortedBy.realValue)

    override suspend fun getGiveawaysByPlatform(platform: PlatformType): Response<List<GiveAwayItem>> =
        giveawaysService.getGiveawaysByPlatform(platform.realValue)

}