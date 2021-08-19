package com.example.bottomnavigation.LocalModel

import android.content.Context
import androidx.room.Room
import com.example.bottomnavigation.RemoteModel.Tolerance
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalModel @Inject constructor(@ApplicationContext context: Context) {
        private val db= Room.databaseBuilder(context, ToleranceDataBase::class.java, "Tolerances.db")
    .createFromAsset("Tolerances.db")
    .allowMainThreadQueries()/*Открытие не в основном потоке*/
    .build()
    fun getOneTolerance(size: String): String {
        return db.toleranceDao().getOneTolerance(size).toString()
    }
}
