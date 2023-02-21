package com.yagmurerdogan.satellite.domain.model

import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition

data class SatelliteDetailUIModel(
    val satelliteId: Int?,
    val heightMassText: String?,
    val costText: String?,
    val dateText: String?,
    val lastPosition: List<SatellitePosition?>?
)
