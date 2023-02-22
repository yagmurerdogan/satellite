package com.yagmurerdogan.satellite.domain.usecase

import com.yagmurerdogan.satellite.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in Request, Type> {

    abstract suspend fun execute(request: Request): Resource<Type>

    suspend operator fun invoke(request: Request): Resource<Type> {
        return withContext(Dispatchers.IO) {
            execute(request)
        }
    }
}