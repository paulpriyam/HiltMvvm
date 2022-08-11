package com.example.hiltmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hiltmvvm.model.RepositoryData
import com.example.hiltmvvm.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RetroViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel() {

    fun getAllRecords(): LiveData<List<RepositoryData>> = repository.getAllRecords()

    fun makeApiCall() {
        repository.makeApiCall("ny")
    }
}