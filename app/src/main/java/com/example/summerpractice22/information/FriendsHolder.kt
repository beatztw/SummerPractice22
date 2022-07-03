package com.example.summerpractice22.information

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpractice22.databinding.ItemFriendsBinding

class FriendsHolder(
    private val binding: ItemFriendsBinding,
    private val glide: RequestManager,
    private val onItemClick: (Friend) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(friends: Friend){
            with(binding){
                tvName.text = friends.name
                tvNickname.text = friends.nickname
                root.setOnClickListener{
                    onItemClick(friends)
                }

                glide
                    .load(friends.url)
                    .into(ivCover)
            }
        }
}