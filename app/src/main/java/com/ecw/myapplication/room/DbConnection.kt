package com.bam.shopproject.room


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BootsData::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun entityDao(): BootsDataDao
}