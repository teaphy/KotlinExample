package com.teaphy.kotlinexample.ui.Base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.kotlinexample.R


import kotlinx.android.synthetic.main.layout_tool_bar.*

/**
 * @desc KotlinForAndroid相关条目
 * @author Teaphy
 * @date 2017/5/22
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initData()

        initView()

        setListener()

        initToolBar()
    }


    abstract fun getLayoutId(): Int

    abstract fun initTitle(): CharSequence?

    abstract fun initData()

    abstract fun initView()

    abstract fun setListener()


    private fun initToolBar() {

        toolBar.title = initTitle()

        toolBar.navigationIcon = resources.getDrawable(R.mipmap.ic_back)

        setSupportActionBar(toolBar)

        toolBar.setNavigationOnClickListener { finish() }
    }


}
