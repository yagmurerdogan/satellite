package com.yagmurerdogan.satellite.domain.model

import androidx.annotation.DrawableRes

data class SatelliteUIModel(
    val satelliteId: Int?,
    val name: String?,
    val activeText: String?,
    @DrawableRes val activeImg: Int?,
    val active: Boolean?
)
