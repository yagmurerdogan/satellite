package com.yagmurerdogan.satellite.data.model.response

import com.google.gson.annotations.SerializedName
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition

data class SatellitePositionsList(
    @SerializedName("list")
    val list: List<SatellitePosition>
)