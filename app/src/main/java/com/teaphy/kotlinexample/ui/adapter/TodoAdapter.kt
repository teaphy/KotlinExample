package com.teaphy.kotlinexample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teaphy.kotlinexample.R

import kotlinx.android.synthetic.main.item_single_text.view.*

/**
 * @desc KotlinForAndroid相关条目
 * @author Teaphy
 * @date 2017/5/22
 */
class TodoAdapter(val list: MutableList<String>) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_single_text, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(list[position])
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(content: String) {
            itemView.tvSingleText.text = content
        }
    }

}