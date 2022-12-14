package com.bam.shopproject.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.bam.shopproject.SpinRepository
import com.bam.shopproject.room.BootsData
import com.bam.shopproject.room.DbConnection
import kotlinx.coroutines.launch

class SpinViewModel(application: Application) : AndroidViewModel(application) {

    private var boots: LiveData<List<BootsData>>? = null

    var selectedBoots: MutableLiveData<BootsData> = MutableLiveData()

    private val repository: SpinRepository
    init {
        val dao = Room.databaseBuilder(application.applicationContext, DbConnection::class.java, "db")
            .build()
            .entityDao()
        repository = SpinRepository(dao)
    }


    fun getAll(): LiveData<List<BootsData>>? {
        if (boots == null){
            boots = repository.getAll()
        }
        return boots
    }

    fun insert(vararg bootsData: BootsData){
        viewModelScope.launch {
            repository.insert(*bootsData)
        }
    }

    fun getById(id: Int) {
        viewModelScope.launch {
           val boots = repository.getById(id)
            selectedBoots.value = boots
        }
    }

}