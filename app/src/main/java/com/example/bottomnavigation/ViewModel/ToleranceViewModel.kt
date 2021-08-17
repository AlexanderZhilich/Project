package com.example.bottomnavigation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bottomnavigation.RemoteModel.FullTolerance
import com.example.bottomnavigation.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToleranceViewModel(val repository: Repository) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)
    val tolerancesLive: MutableLiveData<MutableList<FullTolerance>> by lazy {
        MutableLiveData<MutableList<FullTolerance>>(mutableListOf())/*Обёртка не может быть пустой*/
    }

     fun addToTolerancesLive(fullTolerance: FullTolerance) {
        scope.launch {
            tolerancesLive.value?.add(fullTolerance)
        }
    }
    fun deleteToleranceFromTolerancesLive(position:Int) {
        scope.launch {
            tolerancesLive.value?.removeAt(position)
        }
    }
    fun deleteAllTolerancesFromTolerancesLive() {
        scope.launch {
            tolerancesLive.value?.clear()
        }
    }
     fun getOneTolerance(size: String): String {
        return repository.getOneTolerance(size)
    }
}