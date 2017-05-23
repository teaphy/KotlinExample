package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity

import kotlinx.android.synthetic.main.activity_ano_intent.*

class AnkoIntentActivity : BaseActivity() {

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
    }

    override fun initView() {
    }

    override fun setListener() {
    }




}
