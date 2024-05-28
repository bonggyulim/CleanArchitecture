package com.example.hilt.presentation.popular.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.domain.repository.CacheRepository
import com.example.hilt.presentation.popular.mapper.asLikeVideoEntity
import com.example.hilt.presentation.popular.model.PopularVideo
import com.example.hilt.domain.repository.PopularRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularVideoViewModel @Inject constructor(
    private val popularRepository: PopularRepository,
    private val cacheRepository: CacheRepository
) : ViewModel() {
    private val _getPopularList: MutableLiveData<List<PopularVideo>> = MutableLiveData()
    val getPopularList: LiveData<List<PopularVideo>> get() = _getPopularList
    fun getPopularList() = viewModelScope.launch {
        val popularData = popularRepository.getPopularVideoList(
            AUTH_KEY = "AIzaSyDn_qx3lccTkBr48NdVn7Fog1Zk7iy_C5A",
            part = "snippet",
            chart = "mostPopular",
            maxResults = 5
        )
        _getPopularList.value = popularData.items.asLikeVideoEntity()
    }

    fun insertVideo(video: PopularVideo) {
        viewModelScope.launch(Dispatchers.IO) {
            cacheRepository.insertVideo(video.asLikeVideoEntity())
        }
    }
}