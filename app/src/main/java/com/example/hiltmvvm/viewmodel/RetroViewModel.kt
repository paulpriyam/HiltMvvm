package com.example.hiltmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.hiltmvvm.model.RepositoryData
import com.example.hiltmvvm.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RetroViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel() {

    fun getAllRecords(): Flow<PagingData<RepositoryData>> {
        return Pager(config = PagingConfig(pageSize = 7, maxSize = 28),
            pagingSourceFactory = { repository.getAllRecords() }).flow.cachedIn(viewModelScope)
    }

    fun makeApiCall() {
        repository.makeApiCall("ny")
    }
}