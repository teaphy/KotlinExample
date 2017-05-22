package com.teaphy.kotlinexample.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.adapter.TodoAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var mAdapter: TodoAdapter? = null
    var mList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initTitle(): CharSequence? {
        return "KotlinExample"
    }

    override fun initData() {
        mList.addAll(resources.getStringArray(R.array.TodoArray))
        mAdapter = TodoAdapter(mList)
    }

    override fun initView() {
        rvTodo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTodo.adapter = mAdapter
    }

    override fun setListener() {
    }


}
