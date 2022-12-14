package com.bam.shopproject.room


import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Dao

@Dao
interface BootsDataDao {

    @Query("select * from BootsData")
    fun getAll(): LiveData<List<BootsData>>

    @Query("select * from BootsData where  id = :bootsId")
    suspend fun getById(bootsId: Int): BootsData

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: BootsData)


}