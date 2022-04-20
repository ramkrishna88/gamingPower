package com.example.gamingpower.Rest
import com.example.gamingpower.Model.GiveAwayItem
import com.example.gamingpower.Rest.GiveawaysService.Companion.GIVEAWAYS_PATH
import com.google.android.material.internal.NavigationMenu
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.jar.Attributes

interface GiveawaysService {

    @GET(GIVEAWAYS_PATH)
    suspend fun getAllGiveaways(
        @Query("sort-by") orderBy: String
    ): Response<List<GiveAwayItem>>

    @GET(GIVEAWAYS_PATH)
    suspend fun getGiveawaysByPlatform(
        @Query("platform") platform: String
    ): Response<List<GiveAwayItem>>

    @GET(GIVEAWAYS_PATH)
    suspend fun getGiveawaysById(
        @Query("id") id : Attributes.Name
    ): Response<List<GiveAwayItem>>


    companion object {
        const val BASE_URL = "https://www.gamerpower.com/api/"
        private const val GIVEAWAYS_PATH = "giveaways"

        /*
        data can be sorted by : date, value, popularity
        platforms: pc, steam, epic-games-store, ubisoft, gog,
        itch, ps4, ps5, xbox-one, xbox-series-xs, switch, android,
        ios, vr, battleNet, origin, drm-free, xbox-360
        */
    }
}

