package com.yagmurerdogan.satellite.domain.model

data class SatelliteUIModelItem(
    val data: SatelliteUIModel?,
    val clickAction: ((SatelliteListArgumentModel?) -> Unit)?
)