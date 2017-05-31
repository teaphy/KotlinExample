package com.teaphy.kotlinexample.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import org.jetbrains.anko.textView

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * @desc  测试 启动新的Activity 调用
 * @author Teaphy
 * @date 2017/5/25
 */
class TestAActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       verticalLayout{
           val name = textView("王者荣耀")
           button("sumbit"){
               onClick { toast(name.text) }
           }
       }
    }
}


