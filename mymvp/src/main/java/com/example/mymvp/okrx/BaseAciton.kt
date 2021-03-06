package com.example.mymvp.okrx

import com.example.mymvp.log
import com.google.gson.Gson
import com.lzy.okgo.model.Response
import io.reactivex.Observer

/**
 * Created by Never Fear   on 2018\9\4 0004.
Never More....
 */
interface BaseAciton<T> : Observer<T> {

    override fun onNext(t: T) {
        try {
            if (t is Response<*>){
                if (!t.isSuccessful){
                    onError(t.exception)
                    return
                }
                if (t.isFromCache){
                    acheSuccess(t)
                }else{
                    httpSuccess(t)
                }
            }
        }catch (e:Exception){
            log("okgo","处理出错${e.toString()}")
            e?.printStackTrace()
        }

    }
    fun httpSuccess(t:T)

    fun acheSuccess(t:T)

    fun httpFailed(e:Throwable?)

    override fun onError(e: Throwable) {
        e.printStackTrace()
        log("okgo","网络请求报错了 看栈${e?.toString()}")
        httpFailed(e)
    }
}