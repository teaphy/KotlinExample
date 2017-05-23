package com.teaphy.kotlinexample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.callback.OnItemClickCallback

import kotlinx.android.synthetic.main.item_single_text.view.*

/**
 * @desc KotlinForAndroid相关条目
 * @author Teaphy
 * @date 2017/5/22
 */
class TodoAdapter(val list: MutableList<String>, val itemCallback: OnItemClickCallback) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_single_text, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(list[position])
        holder.itemView.setOnClickListener { itemCallback.onItemClickCallback(position) }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(content: String) {
            with(content) {
                // itemView为RecyclerView.ViewHolder的属性值
                itemView.tvSingleText.text = content
            }
        }
    }
}