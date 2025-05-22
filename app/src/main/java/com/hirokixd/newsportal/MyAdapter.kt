package com.hirokixd.newsportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val listNews : ArrayList<NewsPortal>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = listNews[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
            val heading : TextView = itemView.findViewById(R.id.heading)
    }
}