package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.bean.Person

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.Ref
import org.jetbrains.anko.coroutines.experimental.asReference

import kotlinx.android.synthetic.main.activity_anko_coroutines.*
import kotlinx.coroutines.experimental.Deferred
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * @desc  Kotlin异步处理(协同操作)
 * @author Teaphy
 * @date 2017/5/26
 */
class AnkoCoroutinesActivity : BaseActivity() {

    var mPerson: Person? = null

    val ref: Ref<AnkoCoroutinesActivity> = this@AnkoCoroutinesActivity.asReference()

    override fun getLayoutId(): Int {
        return R.layout.activity_anko_coroutines
    }

    override fun initTitle(): CharSequence? {
        return "AnkoCoroutines"
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun setListener() {
        btnAsReference.setOnClickListener {

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}

