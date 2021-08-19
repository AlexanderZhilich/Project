package com.example.bottomnavigation.Repository

import android.content.Context
import com.example.bottomnavigation.LocalModel.LocalModel
import com.example.bottomnavigation.RemoteModel.Tolerance
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Repository@Inject constructor(val localModel: LocalModel)  {
     fun getOneTolerance(size: String): String {
        return localModel.getOneTolerance(size)
    }
}