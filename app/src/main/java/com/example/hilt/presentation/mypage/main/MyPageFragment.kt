package com.example.hilt.presentation.mypage.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilt.databinding.FragmentMyPageBinding
import com.example.hilt.presentation.popular.main.PopularVideoViewModel
import dagger.hilt.android.AndroidEntryPoint
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
        getItems()
        setupObservers()
    }

    private fun getItems() {
        viewModel.fetchLikeVideoList()
    }




    private fun setupObservers() {
        viewModel.getLikeVideoList.observe(viewLifecycleOwner) {
            myPageAdapter = MyPageAdapter(it)
            binding.rvMypage.adapter = myPageAdapter
            binding.rvMypage.layoutManager = LinearLayoutManager(requireContext())
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}