package com.yagmurerdogan.satellite.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "satellite_detail")
data class SatelliteDetail(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val satelliteId: Int,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Long,
    @SerializedName("first_flight")
    val firstFlight: String,
    val height: Int,
    val mass: Long
)
