package com.teaphy.kotlinexample.ui.callback

/**
 * @desc 单击事件回调
 * @author Teaphy
 * @date 2017/5/23
 */
@FunctionalInterface
interface OnItemClickCallback {
    fun onItemClickCallback(pos: Int)
}