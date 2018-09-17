package com.example.mymvp.okrx

import android.content.Context
import com.example.mymvp.mvp.BaseMvpAty
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

/**
 * Created by Never Fear   on 2018\9\17 0017.
Never More....
 */
abstract  class LoadingConsum(private val c:Context) :Consumer<Disposable> {
    override fun accept(t: Disposable) {
        if (c is BaseMvpAty<*,*>){
            c.addDisable(t)
            doBeforeHttp(c)
        }
    }
    abstract fun doBeforeHttp(c: Context)
}