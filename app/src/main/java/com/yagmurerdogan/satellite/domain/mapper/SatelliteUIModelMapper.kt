package com.yagmurerdogan.satellite.domain.mapper

import com.yagmurerdogan.satellite.R
import com.yagmurerdogan.satellite.data.model.response.Satellite
import com.yagmurerdogan.satellite.domain.model.SatelliteUIModel


object SatelliteUIModelMapper {

    fun satelliteFileResponseToUIModel(list: List<Satellite?>?): List<SatelliteUIModel?>? {
        return list?.map {
            SatelliteUIModel(
                satelliteId = it?.id,
                name = it?.name,
                activeText = if (it?.active == true) "Active" else "Passive",
                activeImg = if (it?.active == true) (R.drawable.ic_green_circle) else (R.drawable.ic_red_circle)
            )
        }
    }
}