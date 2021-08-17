package com.example.bottomnavigation.LocalModel

import androidx.room.Dao
import androidx.room.Query
import com.example.bottomnavigation.RemoteModel.Tolerance

@Dao
interface ToleranceDao {
   @Query("SELECT*FROM Tolerances WHERE Size == :size" )
   fun getOneTolerance(size:String):MutableList<Tolerance>
}