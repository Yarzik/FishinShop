package com.bam.shopproject

import com.bam.shopproject.room.BootsData
import com.bam.shopproject.room.BootsDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpinRepository(private val dao: BootsDataDao) {


    private val list = dao.getAll()

    fun getAll() = list

    suspend fun insert(vararg boots: BootsData){
        withContext(Dispatchers.IO){
            boots.forEach {
                dao.insert(it)
            }
        }
    }

    suspend fun getById(id: Int): BootsData {
        return withContext(Dispatchers.IO) {
            return@withContext dao.getById(id)
        }
    }

}