package com.yagmurerdogan.satellite.data.datasource.file

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.response.Satellite
import com.yagmurerdogan.satellite.data.model.response.SatellitePositionsList
import com.yagmurerdogan.satellite.util.Resource
import com.yagmurerdogan.satellite.util.getListFromJson
import com.yagmurerdogan.satellite.util.getObjectFromJson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FileDataSourceImpl @Inject constructor(
    private val gson: Gson,
    @ApplicationContext private val context: Context
) : FileDataSource {
    override suspend fun getSatelliteList(fileName: String): Resource<List<Satellite>?> {
        return context.getListFromJson(fileName, gson, object : TypeToken<List<Satellite>>() {}.type)
    }

    override suspend fun getSatelliteDetail(fileName: String): Resource<List<SatelliteDetail>?> {
        return context.getListFromJson(fileName, gson,object : TypeToken<List<SatelliteDetail>>() {}.type)
    }

    override suspend fun getSatellitePosition(fileName: String): Resource<SatellitePositionsList?> {
        return context.getObjectFromJson(fileName, gson)
    }
}