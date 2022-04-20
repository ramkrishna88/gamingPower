package com.example.gamingpower.DataBase


import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.gamingpower.Model.GiveAwayItem

@Database(
    entities = [GiveAwayItem::class],
    version = 1
)
abstract class GiveawaysDatabase : RoomDatabase() {
    abstract fun getGiveawaysDao(): GiveawaysDAO
}

@Dao
interface GiveawaysDAO {

    @PrimaryKey
    @Insert(onConflict = REPLACE)
    suspend fun insertGiveaways(newGiveaways: List<GiveAwayItem>)

    @Query("SELECT * FROM giveawayItem")
    suspend fun getAllGiveaways(): List<GiveAwayItem>

    @Query("SELECT * FROM giveawayItem WHERE id = :searchId LIMIT 1")
    suspend fun getGiveawaysById(searchId: Int): GiveAwayItem

    @PrimaryKey
    @Query("SELECT * FROM giveawayItem WHERE platforms = :platform")
    suspend fun getGiveawaysByPlatform(platform: String): List<GiveAwayItem>

    @Delete
    suspend fun deleteGiveaways(giveaways: List<GiveAwayItem>)
}