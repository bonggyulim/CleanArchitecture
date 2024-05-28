package com.example.hilt.presentation.popular.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilt.databinding.PopularItemBinding
import com.example.hilt.presentation.mypage.main.MyPageAdapter
import com.example.hilt.presentation.popular.model.PopularVideo

class PopularVideoAdapter(private val items: List<PopularVideo>): RecyclerView.Adapter<PopularVideoAdapter.Holder>() {
    interface ItemClick {
        fun itemClick(video: PopularVideo)
    }
    var itemClick: ItemClick? = null

    class Holder(binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.itemThumbnail
        val channelId = binding.itemChannelId
        val title = binding.itemTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.itemClick(items[position])
        }

        Glide.with(holder.itemView.context)
            .load(items[position].thumbnails)
            .into(holder.image)

        holder.channelId.text = items[position].ChannelId
        holder.title.text = items[position].title
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

