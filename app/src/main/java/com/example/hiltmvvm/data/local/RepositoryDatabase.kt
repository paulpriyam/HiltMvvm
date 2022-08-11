package com.example.hiltmvvm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.hiltmvvm.data.local.dao.RepositoryDao
import com.example.hiltmvvm.model.RepositoryData
import com.example.hiltmvvm.model.TypeConverterOwner

@Database(entities = [RepositoryData::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterOwner::class)
abstract class RepositoryDatabase : RoomDatabase() {

    abstract fun RepositoryDao(): RepositoryDao

//    companion object {
//        private var DB_INSTANCE: RepositoryDatabase? = null
//
//        fun getAppDBInstance(context: Context): RepositoryDatabase {
//            if(DB_INSTANCE == null) {
//                DB_INSTANCE =  Room.databaseBuilder(context.applicationContext, RepositoryDatabase::class.java, "APP_DB")
//                    .allowMainThreadQueries()
//                    .build()
//            }
//            return DB_INSTANCE!!
//        }
//    }
}