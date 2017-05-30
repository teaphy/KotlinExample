package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity

import kotlinx.android.synthetic.main.activity_test_b.*

class TestBActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_test_b
    }

    override fun initTitle(): CharSequence? {
        return "TestB"
    }

    override fun initData() {
    }

    override fun initView() {
        val id = intent.getIntExtra("id", -1)
        val name = intent.getStringExtra("name")

        tvB.text = "id: $id | name=$name"
    }

    override fun setListener() {
    }
}
