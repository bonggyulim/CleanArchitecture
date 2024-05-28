package com.example.hilt.presentation.mypage.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import com.example.hilt.domain.usecase.GetAllVideoUseCase
import com.example.hilt.presentation.popular.mapper.asLikeVideoEntity
import com.example.hilt.presentation.popular.model.PopularVideo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getAllVideoUseCase: GetAllVideoUseCase,
) : ViewModel() {
    private val _getLikeVideoList: MutableLiveData<List<LikeVideoEntity>> = MutableLiveData()
    val getLikeVideoList: LiveData<List<LikeVideoEntity>> get() = _getLikeVideoList

    fun fetchLikeVideoList() {
        getAllVideoUseCase.invoke("user", viewModelScope) { videoList ->
            _getLikeVideoList.value = videoList
        }
    }
}