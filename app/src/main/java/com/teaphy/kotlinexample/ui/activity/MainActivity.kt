package com.teaphy.kotlinexample.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.teaphy.kotlinexample.R
import com.teaphy.kotlinexample.ui.Base.BaseActivity
import com.teaphy.kotlinexample.ui.adapter.TodoAdapter
import com.teaphy.kotlinexample.ui.callback.OnItemClickCallback

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

/**
 * @desc KotlinForAndroid相关条目
 * @author Teaphy
 * @date 2017/5/22
 */
class MainActivity : BaseActivity() {
	
	private val log = AnkoLogger(MainActivity::class.java)
	
	var mAdapter: TodoAdapter? = null
	var mList: MutableList<String> = mutableListOf()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		
		log.verbose { "问心无愧" }
		log.debug { "问心无愧" }
		log.info { "问心无愧" }
		log.warn { "问心无愧" }
		log.error { "问心无愧" }
		log.wtf("问心无愧")
		
		val tea = mapOf(1 to "A", 2 to "B")
		tea.mapValues { (key,value) -> log.verbose("key: $key | value: $value")}

	}
	
	override fun getLayoutId(): Int {
		return R.layout.activity_main
	}
	
	override fun initTitle(): CharSequence? {
		return "KotlinExample"
	}
	
	override fun initData() {
		mList.addAll(resources.getStringArray(R.array.TodoArray))
		mAdapter = TodoAdapter(mList, object : OnItemClickCallback {
			override fun onItemClickCallback(pos: Int) {
				handleJump(pos)
			}
		})
		sp(2)
	}
	
	
	override fun initView() {
		rvTodo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
		rvTodo.adapter = mAdapter
	}
	
	override fun setListener() {
	
	}
	
	private fun handleJump(pos: Int) {
		when (pos) {
			0 -> startActivity(intentFor<AnkoDialogActivity>()) // Dialog
			1 -> startActivity<AnkoIntentActivity>()// Intent
			2 -> startActivity<AnkoCoroutinesActivity>()
			3 -> {
			} // Misc
			else -> {
				toast(R.string.invalid_operation)
			}
		}
	}
}
