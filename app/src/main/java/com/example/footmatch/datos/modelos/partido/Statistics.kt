package com.example.footmatch.datos.modelos.partido


import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("ball_possession")
    val ballPossession: Int,
    @SerializedName("corner_kicks")
    val cornerKicks: Int,
    @SerializedName("fouls")
    val fouls: Int,
    @SerializedName("free_kicks")
    val freeKicks: Int,
    @SerializedName("goal_kicks")
    val goalKicks: Int,
    @SerializedName("offsides")
    val offsides: Int,
    @SerializedName("red_cards")
    val redCards: Int,
    @SerializedName("saves")
    val saves: Int,
    @SerializedName("shots")
    val shots: Int,
    @SerializedName("shots_off_goal")
    val shotsOffGoal: Int,
    @SerializedName("shots_on_goal")
    val shotsOnGoal: Int,
    @SerializedName("throw_ins")
    val throwIns: Int,
    @SerializedName("yellow_cards")
    val yellowCards: Int,
    @SerializedName("yellow_red_cards")
    val yellowRedCards: Int
)