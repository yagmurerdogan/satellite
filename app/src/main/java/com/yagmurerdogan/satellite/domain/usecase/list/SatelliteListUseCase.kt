package com.yagmurerdogan.satellite.domain.usecase.list

import com.yagmurerdogan.satellite.domain.mapper.SatelliteUIModelMapper
import com.yagmurerdogan.satellite.domain.model.SatelliteUIModel
import com.yagmurerdogan.satellite.domain.repository.SatelliteRepository
import com.yagmurerdogan.satellite.domain.usecase.BaseUseCase
import com.yagmurerdogan.satellite.util.Resource
import kotlinx.coroutines.delay
import javax.inject.Inject

class SatelliteListUseCase @Inject constructor(
    private val repository: SatelliteRepository
) : BaseUseCase<SatelliteListUseCase.Request, List<SatelliteUIModel?>?>() {

    override suspend fun execute(request: Request): Resource<List<SatelliteUIModel?>?> {
        return try {
            delay(2000)
            when (val satellites = repository.getSatellites(request.fileName)) {
                is Resource.Success -> Resource.Success(
                    SatelliteUIModelMapper.satelliteFileResponseToUIModel(
                        satellites.data
                    )
                )
                is Resource.Failure -> Resource.Failure(satellites.error)
            }
        } catch (e: Exception) {
            Resource.Failure(e.toString())
        }
    }

    data class Request(val fileName: String)
}
