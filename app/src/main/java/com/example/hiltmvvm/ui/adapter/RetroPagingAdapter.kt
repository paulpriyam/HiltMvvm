package com.example.hiltmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hiltmvvm.R
import com.example.hiltmvvm.model.RepositoryData
import kotlinx.android.synthetic.main.item_layout.view.*

class RetroPagingAdapter() :
    PagingDataAdapter<RepositoryData, RetroPagingAdapter.MyPagingViewHolder>(DiffUtilCallback()) {

    class MyPagingViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: RepositoryData) {
            view.tvName.text = data.name
            Glide.with(view.ivAvatar).load(data.owner?.avatar_url).into(view.ivAvatar)
            view.tvDescription.text = data.description
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<RepositoryData>() {
        override fun areItemsTheSame(oldItem: RepositoryData, newItem: RepositoryData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RepositoryData, newItem: RepositoryData): Boolean {
            return oldItem.name == newItem.name && oldItem.description == newItem.description
        }

    }

    override fun onBindViewHolder(holder: MyPagingViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyPagingViewHolder(view)
    }
}