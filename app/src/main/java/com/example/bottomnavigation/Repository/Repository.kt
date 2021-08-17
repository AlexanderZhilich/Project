package com.example.bottomnavigation.Repository

import com.example.bottomnavigation.LocalModel.LocalModel
import com.example.bottomnavigation.RemoteModel.Tolerance

class Repository (
    private val localModel: LocalModel
) {
     fun getOneTolerance(size: String): String {
        return localModel.getOneTolerance(size)
    }
}