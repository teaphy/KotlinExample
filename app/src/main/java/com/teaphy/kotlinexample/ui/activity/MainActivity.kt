package com.teaphy.kotlinexample.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.adapter.TodoAdapter
import com.teaphy.kotlinexample.ui.callback.OnItemClickCallback

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

/**
 * @desc KotlinForAndroid相关条目
 * @author Teaphy
 * @date 2017/5/22
 */
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
        mAdapter = TodoAdapter(mList, object: OnItemClickCallback{
            override fun onItemClickCallback(pos: Int) {
                handleJump(pos)
            }
        })
    }


    override fun initView() {
        rvTodo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTodo.adapter = mAdapter
    }

    override fun setListener() {
    }

    private fun handleJump(pos: Int) {
        when (pos) {
            0 -> jumpDialogActivity() // Dialog
            1 -> {} // Intent
            2 -> {} // Logger
            3 -> {} // Misc
            else -> {toast(R.string.invalid_operation)}
        }
    }

    private fun jumpDialogActivity() {
        val intent = Intent(this, DialogActivity::class.java)
        startActivity(intent)
    }
}
