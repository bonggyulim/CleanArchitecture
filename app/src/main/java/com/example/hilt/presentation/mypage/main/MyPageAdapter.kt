package com.example.hilt.presentation.mypage.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.databinding.PopularItemBinding

class MyPageAdapter(var items: List<LikeVideoEntity>): RecyclerView.Adapter<MyPageAdapter.Holder>() {
    class Holder(binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.itemThumbnail
        val channelId = binding.itemChannelId
        val title = binding.itemTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(items[position].thumbnails)
            .into(holder.image)

        holder.channelId.text = items[position].ChannelId
        holder.title.text = items[position].title
    }
}