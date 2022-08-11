package com.example.hiltmvvm.data.remote

import com.example.hiltmvvm.model.RepositoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryApi {

    @GET("repositories")
    fun getDataFromApi(@Query("q") query: String): Call<RepositoryList>

}