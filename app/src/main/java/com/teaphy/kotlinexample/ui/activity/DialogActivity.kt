package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.adapter.TodoAdapter
import com.teaphy.kotlinexample.ui.callback.OnItemClickCallback


import kotlinx.android.synthetic.main.activity_dialog.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

/**
 * @desc  测试Kotlin-Anko中的Dialog
 * @author Teaphy
 * @date 2017/5/23
 */
class DialogActivity : BaseActivity() {

    var mAdapter: TodoAdapter? = null
    var mList: MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_dialog
    }

    override fun initTitle(): CharSequence? {
        return resources.getString(R.string.title_anko_dialog)
    }

    override fun initData() {
        mList.addAll(resources.getStringArray(R.array.AnkoDialogArray))
        mAdapter = TodoAdapter(mList, object: OnItemClickCallback {
            override fun onItemClickCallback(pos: Int) {
                handleClick(pos)
            }
        })
    }


    override fun initView() {
        rvDialogEntry.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvDialogEntry.adapter = mAdapter
    }

    override fun setListener() {
    }

    private fun handleClick(pos: Int) {

        when (pos) {
            0 -> toast("Hi there!")
            1 -> toast(R.string.mesage)
            2 -> longToast("This is a long toast")
            3 -> toast(R.string.mesage_long)
            4 -> displayAlertDialog()
            else -> {toast(R.string.invalid_operation)}
        }

    }

    /**
     * @desc  显示一个AlertDialog
     * @author Teaphy
     * @date 2017/5/23
     */
    fun displayAlertDialog() {
        alert {  }
    }
}
