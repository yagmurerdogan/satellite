package com.yagmurerdogan.satellite.domain.usecase.detail

import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition
import com.yagmurerdogan.satellite.domain.repository.SatelliteRepository
import com.yagmurerdogan.satellite.domain.usecase.BaseUseCase
import com.yagmurerdogan.satellite.util.Resource
import javax.inject.Inject

class InsertSatellitePositionUseCase @Inject constructor(
    private val repository: SatelliteRepository
) : BaseUseCase<InsertSatellitePositionUseCase.Request, Unit>() {
    override suspend fun execute(request: Request): Resource<Unit> {
        return try {
            request.satellitePosition?.let { repository.insertSatellitePosition(it) }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Failure(e.toString())
        }
    }

    data class Request(val satellitePosition: SatellitePosition?)
}