package com.example.mymvp.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Never Fear   on 2018\9\17 0017.
Never More....
 */
abstract class BaseFgm<V:BaseView,P:BasePresenter<*,V>> :Fragment(),BaseMVP<V,P> {
    lateinit var rootView:View
    protected var presenter:P?=null
    private var  compositeDisable: CompositeDisposable?=null
    fun addDisable(disable: Disposable){
        if (compositeDisable==null){
            compositeDisable=CompositeDisposable()
        }
        compositeDisable?.add(disable)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView=inflater?.inflate(getContentId(),null)!!
        doBeforInit()
        presenter=createPresenter()
        presenter.let{
            it?.createModule()
            it?.bindView(bindView())

            it?.initView()
            it?.setListener()
            it?.logicStart()
        }

        return rootView
    }

    abstract fun doBeforInit()

    override fun onDestroy() {
        compositeDisable?.dispose()
        presenter?.let {
            it.destory()
        }
        super.onDestroy()

    }
    abstract fun getContentId():Int
}