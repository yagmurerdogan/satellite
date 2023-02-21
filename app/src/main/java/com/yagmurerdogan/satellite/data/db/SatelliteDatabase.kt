package com.yagmurerdogan.satellite.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yagmurerdogan.satellite.data.model.entity.SatelliteDetail
import com.yagmurerdogan.satellite.data.model.entity.SatellitePosition

@Database(
    entities = [SatelliteDetail::class, SatellitePosition::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SatelliteDatabase : RoomDatabase() {
    abstract fun getSatelliteDao(): SatelliteDao
}