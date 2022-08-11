package com.example.hiltmvvm.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltmvvm.model.RepositoryData

@Dao
interface RepositoryDao {

    @Query("SELECT * From repositories")
    fun getAllRecord(): LiveData<List<RepositoryData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRecord(data: RepositoryData)

    @Query("Delete From repositories")
    fun deleteAllRecord()
}