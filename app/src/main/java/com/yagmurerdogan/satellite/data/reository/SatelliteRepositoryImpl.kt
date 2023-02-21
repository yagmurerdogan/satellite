package com.yagmurerdogan.satellite.data.reository

import com.yagmurerdogan.satellite.data.datasource.file.FileDataSource
import com.yagmurerdogan.satellite.data.datasource.local.RoomDataSource
import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition
import com.yagmurerdogan.satellite.data.model.response.Satellite
import com.yagmurerdogan.satellite.domain.repository.SatelliteRepository
import com.yagmurerdogan.satellite.util.Constant.SATELLITE_DETAIL_FILE
import com.yagmurerdogan.satellite.util.Resource
import javax.inject.Inject

class SatelliteRepositoryImpl @Inject constructor(
    private val fileDataSource: FileDataSource,
    private val roomDataSource: RoomDataSource
) : SatelliteRepository {

    override suspend fun getSatellites(fileName: String): Resource<List<Satellite>?> {
        return fileDataSource.getSatelliteList(fileName)
    }

    override suspend fun getSatelliteDetail(
        fileName: String,
        satelliteId: Int
    ): Resource<List<SatelliteDetail?>?> {
        return when (val satelliteDetails = roomDataSource.getSatelliteDetails()) {
            is Resource.Success -> {
                if (satelliteDetails.data?.any { it.id == satelliteId } == true) {
                    satelliteDetails
                } else {
                    fileDataSource.getSatelliteDetail(SATELLITE_DETAIL_FILE)
                }
            }
            is Resource.Failure -> fileDataSource.getSatelliteDetail(SATELLITE_DETAIL_FILE)
        }
    }

    override suspend fun getSatellitePositions(
        fileName: String,
        satelliteId: Int
    ): Resource<List<SatellitePosition?>?> {
        return when (val satellitePositions = roomDataSource.getSatellitePositions()) {
            is Resource.Success -> {
                if (satellitePositions.data?.any { it.id == satelliteId } == true) {
                    satellitePositions
                } else {
                    when (val listObject = fileDataSource.getSatellitePosition(fileName)) {
                        is Resource.Success -> Resource.Success(listObject.data?.list)
                        is Resource.Failure -> Resource.Failure(listObject.error)
                    }
                }
            }
            is Resource.Failure -> when (val listObject =
                fileDataSource.getSatellitePosition(fileName)) {
                is Resource.Success -> Resource.Success(listObject.data?.list)
                is Resource.Failure -> Resource.Failure(listObject.error)
            }
        }
    }

    override suspend fun insertSatelliteDetail(satelliteDetail: SatelliteDetail) {
        roomDataSource.deleteSatelliteDetail(satelliteDetail)
        roomDataSource.insertSatelliteDetail(satelliteDetail)
    }

    override suspend fun insertSatellitePosition(satellitePosition: SatellitePosition) {
        roomDataSource.deleteSatellitePosition(satellitePosition)
        roomDataSource.insertSatellitePosition(satellitePosition)
    }
}