package com.example.mymvp

import java.lang.ref.WeakReference

/**
 * Created by Never Fear   on 2018\8\10 0010.
Never More....
 */
abstract class BasePresenter<M: BaseModule,V: BaseView> : Presenter<M, V> {
    private var wkf:WeakReference<V>?=null
    lateinit var module: M
     var view: V? = null
         get() = if (wkf==null) null else wkf?.get()

    abstract override fun createModule()

    override fun bindView(view:V): V {
        wkf= WeakReference(view)

        return view
    }

    override fun destory() {
        if (null!=wkf){
            wkf?.clear()
            wkf=null
        }
    }
    fun initView(){
        view?.initView()
    }

    fun setListener(){
        view?.setListener()
    }
    fun logicStart(){
        view?.logicStart()
    }
}