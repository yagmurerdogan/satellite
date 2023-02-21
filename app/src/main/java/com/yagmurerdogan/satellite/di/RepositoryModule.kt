package com.yagmurerdogan.satellite.di

import com.yagmurerdogan.satellite.data.reository.SatelliteRepositoryImpl
import com.yagmurerdogan.satellite.domain.repository.SatelliteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSatelliteRepository(repository: SatelliteRepositoryImpl): SatelliteRepository
}