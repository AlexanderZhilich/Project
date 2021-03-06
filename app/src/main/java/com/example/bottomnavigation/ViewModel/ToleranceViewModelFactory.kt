package com.example.bottomnavigation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigation.Repository.Repository
import javax.inject.Inject
@Suppress("UNCHECKED_CAST")
class ToleranceViewModelFactory@Inject constructor(val repository: Repository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToleranceViewModel(repository) as T
    }
}
