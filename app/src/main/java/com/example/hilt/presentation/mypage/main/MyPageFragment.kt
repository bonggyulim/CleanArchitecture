package com.example.hilt.presentation.mypage.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt.databinding.FragmentMyPageBinding
import com.example.hilt.presentation.main.UiState
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyPageFragment : Fragment() {
    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var myPageAdapter: MyPageAdapter
    private val viewModel: MyPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // shared 사용하면 cllectLatest 사용
                viewModel.getLikeVideoList.collect { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {
                            Log.d("UiState", "UiState loading")
                        }
                        is UiState.Success -> {
                            myPageAdapter = MyPageAdapter(uiState.data)
                            binding.rvMypage.adapter = myPageAdapter
                            binding.rvMypage.layoutManager = LinearLayoutManager(requireContext())
                        }
                        is UiState.Error -> {
                            Log.d("UiState", uiState.message)
                        }
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}