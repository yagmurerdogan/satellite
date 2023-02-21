package com.yagmurerdogan.satellite.domain.repository

import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition
import com.yagmurerdogan.satellite.data.model.response.Satellite
import com.yagmurerdogan.satellite.util.Resource


interface SatelliteRepository {
    suspend fun getSatellites(fileName: String): Resource<List<Satellite>?>

    suspend fun getSatelliteDetail(
        fileName: String,
        satelliteId: Int
    ): Resource<List<SatelliteDetail?>?>

    suspend fun getSatellitePositions(
        fileName: String,
        satelliteId: Int
    ): Resource<List<SatellitePosition?>?>

    suspend fun insertSatelliteDetail(satelliteDetail: SatelliteDetail)

    suspend fun insertSatellitePosition(satellitePosition: SatellitePosition)
}