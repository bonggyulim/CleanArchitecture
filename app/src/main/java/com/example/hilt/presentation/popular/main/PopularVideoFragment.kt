package com.example.hilt.presentation.popular.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hilt.databinding.FragmentPopularVideoBinding
import com.example.hilt.presentation.popular.model.PopularVideo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class PopularVideoFragment : Fragment() {
    private var _binding: FragmentPopularVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var popularVideoAdapter: PopularVideoAdapter
    private val viewModel: PopularVideoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getItems()
        setupObservers()
    }

    private fun getItems() = lifecycleScope.launch {
        viewModel.getPopularList()
    }

    private fun setupObservers() {
        viewModel.getPopularList.observe(viewLifecycleOwner) {
            popularVideoAdapter = PopularVideoAdapter(it)
            binding.rvPopular.adapter = popularVideoAdapter
            binding.rvPopular.layoutManager = LinearLayoutManager(requireContext())

            popularVideoAdapter.itemClick = object : PopularVideoAdapter.ItemClick {
                override fun itemClick(video: PopularVideo) {
                    viewModel.insertVideo(video)
                }

            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}