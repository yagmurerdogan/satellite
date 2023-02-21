package com.yagmurerdogan.satellite.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yagmurerdogan.satellite.data.model.response.PositionCoordinate


@Entity(tableName = "satellite_position")
data class SatellitePosition(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val positions: List<PositionCoordinate>
)
