package com.example.summerpractice22.information

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpractice22.databinding.ItemFriendsBinding

class FriendsAdapter(
    private val list: List<Friend>,
    private val glide: RequestManager,
    private val onItemClick: (Friend) -> Unit,
): RecyclerView.Adapter<FriendsHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendsHolder = FriendsHolder(
        binding = ItemFriendsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick
    )


    override fun onBindViewHolder(
        holder: FriendsHolder,
        position: Int,

    )
    {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}