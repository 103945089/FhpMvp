package com.example.administrator.fhpmvp

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.widget.LinearLayout

/**
 * Created by Administrator on 2018/8/15/015.
 */
class MyLinealayout :LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        Log.e("fhp","L")
        return super.dispatchKeyEvent(event)
    }
}