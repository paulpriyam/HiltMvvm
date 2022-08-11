package com.example.hiltmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hiltmvvm.R
import com.example.hiltmvvm.model.RepositoryData
import kotlinx.android.synthetic.main.item_layout.view.*

class RetroAdapter() : RecyclerView.Adapter<RetroAdapter.MyViewHolder>() {

    private var recordList: List<RepositoryData>? = null
    fun setData(data: List<RepositoryData>) {
        recordList = data
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: RepositoryData) {
            view.tvName.text = data.name
            Glide.with(view.ivAvatar).load(data.owner?.avatar_url).into(view.ivAvatar)
            view.tvDescription.text = data.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(recordList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (recordList.isNullOrEmpty() == true) 0 else recordList?.size!!
    }
}