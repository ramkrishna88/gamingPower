package com.example.gamingpower.Model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class GiveAwayItem(
        @SerializedName("description")
        @Expose
        val description: String,
        @SerializedName("end_date")
        @Expose
        val endDate: String,
        @SerializedName("gamerpower_url")
        @Expose
        val gamerpowerUrl: String,
        @SerializedName("id")
        @Expose
        val id: Int,
        @SerializedName("image")
        @Expose
        val image: String,
        @SerializedName("instructions")
        @Expose
        val instructions: String,
        @SerializedName("open_giveaway")
        @Expose
        val openGiveaway: String,
        @SerializedName("open_giveaway_url")
        @Expose
        val openGiveawayUrl: String,
        @SerializedName("platforms")
        @Expose
        val platforms: String,
        @SerializedName("published_date")
        @Expose
        val publishedDate: String,
        @SerializedName("status")
        @Expose
        val status: String,
        @Expose
        val thumbnail: String,
        @SerializedName("title")
        @Expose
        val title: String,
        @SerializedName("type")
        @Expose
        val type: String,
        @SerializedName("users")
        @Expose
        val users: Int,
        @SerializedName("worth")
        @Expose
        val worth: String
    )