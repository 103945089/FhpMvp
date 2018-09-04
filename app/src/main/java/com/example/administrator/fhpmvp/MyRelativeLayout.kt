package com.example.administrator.fhpmvp

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout

/**
 * Created by Administrator on 2018/8/15/015.
 */
class MyRelativeLayout :RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("fhp","R")
        return true
//        return super.dispatchTouchEvent(ev)
    }
}