package com.example.hiltmvvm.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.hiltmvvm.data.local.RepositoryDatabase
import com.example.hiltmvvm.data.local.dao.RepositoryDao
import com.example.hiltmvvm.data.remote.RepositoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val BASE_URL = "https://api.github.com/search/"

    @Provides
    @Singleton
    fun providesDatabase(context: Application): RepositoryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            RepositoryDatabase::class.java,
            "RepoDb"
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun providesDao(db: RepositoryDatabase): RepositoryDao {
        return db.RepositoryDao()
    }

    @Provides
    @Singleton
    fun providesRepositoryApi(retrofit: Retrofit): RepositoryApi {
        return retrofit.create(RepositoryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}