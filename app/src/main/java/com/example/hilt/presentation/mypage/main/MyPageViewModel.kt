package com.example.hilt.presentation.mypage.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.usecase.GetAllVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getAllVideoUseCase: GetAllVideoUseCase
) : ViewModel() {
    private val _getLikeVideoList = MutableSharedFlow<List<LikeVideoEntity>>(replay = 1)
    val getLikeVideoList: SharedFlow<List<LikeVideoEntity>> get() = _getLikeVideoList.asSharedFlow()

    //shared는 데이터가 몇 개 까지 값을 캐싱하고 있을지에 대해 인자로 정의 가능
    //state는 livedata랑 비슷 shared가 1일때랑 비슷

    init {
        fetchLikeVideoList()
    }

    // Flow 받아올때 collect사용, shared 사용하므로 emit으로 받아옴
    private fun fetchLikeVideoList() {
        viewModelScope.launch {
            getAllVideoUseCase.invoke().collect { videoList ->
                _getLikeVideoList.emit(videoList)
            }
        }
    }
}