package com.yagmurerdogan.satellite.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "satellite_detail")
data class SatelliteDetail(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val satelliteId: Int,
    val costPerLaunch: Long,
    val firstFlight: String,
    val height: Int,
    val mass: Long
)
