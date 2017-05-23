package com.teaphy.kotlinexample.ui.activity

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.adapter.TodoAdapter
import com.teaphy.kotlinexample.ui.callback.OnItemClickCallback


import kotlinx.android.synthetic.main.activity_dialog.*
import org.jetbrains.anko.*
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/**
 * @desc  测试Kotlin-Anko中的Dialog
 * @author Teaphy
 * @date 2017/5/23
 */
class AnkoDialogActivity : BaseActivity() {

    var mAdapter: TodoAdapter? = null
    var mList: MutableList<String> = mutableListOf()

    var proCurrent: Int = 1

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
            5 -> displayCustomViewAlertDialog()
            6 -> displaySelectorsDialog()
            7 -> displayProgressDialog()
            else -> {toast(R.string.invalid_operation)}
        }

    }

    /**
     * @desc  显示一个AlertDialog
     * @author Teaphy
     * @date 2017/5/23
     */
    fun displayAlertDialog() {
        alert("这是一个Dialog", "友情提示"){
            positiveButton("确定"){toast("我知道了！")}
            negativeButton("取消"){}
        }.show()
    }

    private fun displayCustomViewAlertDialog() {
        var tv: TextView
        var edit: EditText? = null
        alert {
            customView {
                edit = editText()
                edit?.hint = "请输入账号"
            }

            yesButton { toast(edit?.text.toString()) }
            noButton { toast("取消") }

        }.show()
    }


    /**
     * @desc  显示一个选择的Dialog
     * 单击Item后选择，并关闭Dialog
     * @author todo
     * @date 2017/5/23 20:41
     */
    private fun displaySelectorsDialog() {
        val sexs = listOf("男", "女")
        selector("请选择性别", sexs) { dialogInterface: DialogInterface, pos: Int ->
            toast(sexs[pos])
        }
    }

    /**
     * @desc
     * @author todo
     * @date 2017/5/23 20:43
     */
    private fun displayProgressDialog() {
        // 默认为SeekBar
//        progressDialog("加载中，请稍后...")
        // 默认为SeekBar + 标题
//        progressDialog("加载中，请稍后...", "图片浏览")
        val pro = progressDialog("加载中，请稍后...", "图片浏览", init = {
            progress = 0
            max = 100
            // 旋转：ProgressDialog.STYLE_SPINNER
            // 进度条：ProgressDialog.STYLE_SPINNER
            setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        })

        thread {
            do {
                pro.progress = proCurrent
               sleep(500)
                proCurrent++
            }while (proCurrent <= 100)
        }
    }

}
