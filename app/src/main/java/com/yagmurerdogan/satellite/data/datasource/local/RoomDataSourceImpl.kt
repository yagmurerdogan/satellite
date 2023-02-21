package com.yagmurerdogan.satellite.data.datasource.local

import com.yagmurerdogan.satellite.data.db.SatelliteDao
import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition
import com.yagmurerdogan.satellite.util.Constant.LIST_EMPTY_ERROR
import com.yagmurerdogan.satellite.util.Resource
import javax.inject.Inject

class RoomDataSourceImpl @Inject constructor(private val dao: SatelliteDao) : RoomDataSource {
    override suspend fun getSatelliteDetails(): Resource<List<SatelliteDetail>?> {
        val satelliteDetails = dao.getSatelliteDetails()
        return if (satelliteDetails?.isNotEmpty() == true) {
            Resource.Success(satelliteDetails)
        } else Resource.Failure(LIST_EMPTY_ERROR)
    }

    override suspend fun getSatellitePositions(): Resource<List<SatellitePosition>?> {
        val satellitePositions = dao.getSatellitePositions()
        return if (satellitePositions?.isNotEmpty() == true) {
            Resource.Success(satellitePositions)
        } else Resource.Failure(LIST_EMPTY_ERROR)
    }

    override suspend fun insertSatelliteDetail(satelliteDetail: SatelliteDetail) {
        dao.insertSatelliteDetail(satelliteDetail)
    }

    override suspend fun insertSatellitePosition(satellitePosition: SatellitePosition) {
        dao.deleteSatellitePosition(satellitePosition)
        dao.insertSatellitePosition(satellitePosition)
    }

    override suspend fun deleteSatelliteDetail(satelliteDetail: SatelliteDetail) {
        dao.deleteSatelliteDetail(satelliteDetail)
    }

    override suspend fun deleteSatellitePosition(satellitePosition: SatellitePosition) {
        dao.deleteSatellitePosition(satellitePosition)
    }
}