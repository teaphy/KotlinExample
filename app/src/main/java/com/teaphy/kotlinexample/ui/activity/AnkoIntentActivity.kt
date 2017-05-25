package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.R.id.info
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.adapter.TodoAdapter
import com.teaphy.kotlinexample.ui.callback.OnItemClickCallback

import kotlinx.android.synthetic.main.activity_ano_intent.*

import org.jetbrains.anko.*

class AnkoIntentActivity : BaseActivity() {


    var mAdapter: TodoAdapter? = null
    var mList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_ano_intent
    }

    override fun initTitle(): CharSequence? {
        return getString(R.string.title_anko_intent)
    }

    override fun initData() {
        mList.addAll(resources.getStringArray(R.array.AnkoIntentArray))
        mAdapter = TodoAdapter(mList, object : OnItemClickCallback {
            override fun onItemClickCallback(pos: Int) {
                handleJump(pos)
            }
        })
    }

    override fun initView() {
        rvIntentEntry.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvIntentEntry.adapter = mAdapter
    }

    override fun setListener() {
    }


    private fun handleJump(pos: Int) {
        /**
         * 1.如果启动Activity时，除传参外，对Intent无其他相关配置(比如启动模式)，可调用startActivity<*>()方法;
         *   若对Intent有其他配置，需使用intentFor<*>方法创建Intent，并进行相关设置，然后在调用startActivity()
         * @desc
         * @author Teaphy
         * @date 2017/5/25
         */
        when (pos) {
            0 -> startActivity<TestAActivity>("id" to 5, "name" to "A")// intent with flag
            1 -> startActivity(intentFor<TestBActivity>("id" to 5, "name" to "B").singleTop())// intent with out flag
            2 -> {
                makeCall("10086")
            } // 拨打电话
            3 -> {
                sendSMS("15275239225","这条短信不用回，测试用的！！")
            } // sendSMS
            4 -> {
                browse("https://www.baidu.com", false)
            } // browse（其中：newTask 若为true）
            5 -> {
                share("This is a share!", subject = "主题")
            } // share(subject: 默认为空，可不传)
            6 -> {
                email("334679056@qq.com", "From the app of KotlinExample", "KotlinExample")
            } // email
            else -> {
                toast(R.string.invalid_operation)
            }
        }
    }

}
