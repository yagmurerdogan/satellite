package com.yagmurerdogan.satellite.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yagmurerdogan.satellite.data.model.response.PositionCoordinate
import javax.inject.Inject


@ProvidedTypeConverter
class Converters @Inject constructor(private val gson: Gson) {

    @TypeConverter
    fun fromString(value: String?): List<PositionCoordinate?> {
        val listType = object :
            TypeToken<ArrayList<PositionCoordinate?>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<PositionCoordinate?>?): String {
        return gson.toJson(list)
    }
}