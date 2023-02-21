package com.yagmurerdogan.satellite.data.datasource.file

import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.response.Satellite
import com.yagmurerdogan.satellite.data.model.response.SatellitePositionsList
import com.yagmurerdogan.satellite.util.Resource


interface FileDataSource {
    suspend fun getSatelliteList(fileName: String): Resource<List<Satellite>?>
    suspend fun getSatelliteDetail(fileName: String): Resource<List<SatelliteDetail>?>
    suspend fun getSatellitePosition(fileName: String): Resource<SatellitePositionsList?>
}