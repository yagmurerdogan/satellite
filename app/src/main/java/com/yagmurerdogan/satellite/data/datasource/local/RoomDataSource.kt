package com.yagmurerdogan.satellite.data.datasource.local

import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition
import com.yagmurerdogan.satellite.util.Resource


interface RoomDataSource {
    suspend fun getSatelliteDetails(): Resource<List<SatelliteDetail>?>
    suspend fun getSatellitePositions(): Resource<List<SatellitePosition>?>
    suspend fun insertSatelliteDetail(satelliteDetail: SatelliteDetail)
    suspend fun insertSatellitePosition(satellitePosition: SatellitePosition)
    suspend fun deleteSatelliteDetail(satelliteDetail: SatelliteDetail)
    suspend fun deleteSatellitePosition(satellitePosition: SatellitePosition)
}