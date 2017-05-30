package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity

import kotlinx.android.synthetic.main.activity_test_a.*
import org.jetbrains.anko.dip

/**
 * @desc  测试 启动新的Activity 调用
 * @author Teaphy
 * @date 2017/5/25
 */
class TestAActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_test_a
    }

    override fun initTitle(): CharSequence? {
        return "TestA"
    }

    override fun initData() {

    }

    override fun initView() {
        val id = intent.getIntExtra("id", -1)
        val name = intent.getStringExtra("name")

        tvA.text = "id: $id | name=$name"
    }

    override fun setListener() {
    }


}
