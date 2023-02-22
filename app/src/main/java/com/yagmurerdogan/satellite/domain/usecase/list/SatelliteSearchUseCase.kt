package com.yagmurerdogan.satellite.domain.usecase.list

import com.yagmurerdogan.satellite.domain.model.SatelliteUIModel
import com.yagmurerdogan.satellite.domain.usecase.BaseUseCase
import com.yagmurerdogan.satellite.util.Resource
import javax.inject.Inject

class SatelliteSearchUseCase @Inject constructor(
    private val satelliteListUseCase: SatelliteListUseCase
) : BaseUseCase<SatelliteSearchUseCase.Request, List<SatelliteUIModel?>?>() {

    override suspend fun execute(request: Request): Resource<List<SatelliteUIModel?>?> {
        return try {
            when (val fileList =
                satelliteListUseCase.execute(SatelliteListUseCase.Request(request.fileName))) {
                is Resource.Success -> Resource.Success(
                    fileList.data?.filter {
                        it?.name?.lowercase()?.contains(
                            request.searchKey.lowercase()
                        ) == true
                    }
                )
                is Resource.Failure -> Resource.Failure(fileList.error)
            }
        } catch (e: Exception) {
            Resource.Failure(e.toString())
        }
    }

    data class Request(val fileName: String, val searchKey: String)
}