package com.example.bottomnavigation.LocalModel

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bottomnavigation.RemoteModel.Tolerance

@Database(entities = [Tolerance::class],version = 1)
abstract class ToleranceDataBase : RoomDatabase() {
    abstract fun toleranceDao(): ToleranceDao
}