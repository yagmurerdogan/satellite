package com.yagmurerdogan.satellite.data.model.response

import com.google.gson.annotations.SerializedName

data class Satellite(
    @SerializedName("id")
    val id: Int,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("name")
    val name: String
)
