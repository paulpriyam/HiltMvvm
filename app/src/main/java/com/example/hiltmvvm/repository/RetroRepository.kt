package com.example.hiltmvvm.repository

import androidx.lifecycle.LiveData
import com.example.hiltmvvm.data.local.dao.RepositoryDao
import com.example.hiltmvvm.data.remote.RepositoryApi
import com.example.hiltmvvm.model.RepositoryData
import com.example.hiltmvvm.model.RepositoryList
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetroRepository @Inject constructor(val api: RepositoryApi, val dao: RepositoryDao) {

    fun getAllRecords(): LiveData<List<RepositoryData>> {
      return  dao.getAllRecord()
    }

    fun deleteAllRecords(){
        dao.deleteAllRecord()
    }

    fun makeApiCall(query:String?){
        val call:Call<RepositoryList> = api.getDataFromApi(query.orEmpty())
        call.enqueue(object:Callback<RepositoryList>{
            override fun onResponse(
                call: Call<RepositoryList>,
                response: Response<RepositoryList>
            ) {
                if(response.isSuccessful){
                    deleteAllRecords()
                    response.body()?.items?.forEach{
                        dao.addRecord(it)
                    }
                }
            }

            override fun onFailure(call: Call<RepositoryList>, t: Throwable) {
               //no implementation required
            }

        })
    }
}