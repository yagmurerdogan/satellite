package com.yagmurerdogan.satellite.domain.usecase.detail

import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.domain.repository.SatelliteRepository
import com.yagmurerdogan.satellite.domain.usecase.BaseUseCase
import com.yagmurerdogan.satellite.util.Constant.SATELLITE_DETAIL_FILE
import com.yagmurerdogan.satellite.util.Resource
import javax.inject.Inject

class GetSatelliteDetailUseCase @Inject constructor(
    private val repository: SatelliteRepository,
    private val insertSatelliteDetailUseCase: InsertSatelliteDetailUseCase
) : BaseUseCase<GetSatelliteDetailUseCase.Request, List<SatelliteDetail?>?>() {

    override suspend fun execute(request: Request): Resource<List<SatelliteDetail?>?> {
        return try {
            when (val satelliteDetailList =
                repository.getSatelliteDetail(SATELLITE_DETAIL_FILE, request.satelliteId)) {
                is Resource.Success -> {
                    insertSatelliteDetailUseCase.execute(
                        InsertSatelliteDetailUseCase.Request(
                            satelliteDetailList.data?.find { it?.id == request.satelliteId })
                    )
                    Resource.Success(satelliteDetailList.data)
                }
                is Resource.Failure -> Resource.Failure(satelliteDetailList.error)
            }
        } catch (e: Exception) {
            Resource.Failure(e.toString())
        }
    }

    data class Request(val satelliteId: Int)

}