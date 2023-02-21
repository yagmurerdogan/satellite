package com.yagmurerdogan.satellite.data.model.response

import com.google.gson.annotations.SerializedName

data class Satellite(
    @SerializedName("satelliteId")
    val satelliteId: Int,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("name")
    val name: String
)
