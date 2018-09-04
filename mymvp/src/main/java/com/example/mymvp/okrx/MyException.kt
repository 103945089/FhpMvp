package com.example.mymvp.okrx

import java.lang.Exception

/**
 * Created by Never Fear   on 2018\9\4 0004.
Never More....
 */
class MyException( val code:Int?,private val str:String?) : Exception() {
    override val message: String?
        get() = str
}