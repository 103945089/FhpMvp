package com.example.mymvp.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mymvp.okrx.BaseBean
import com.example.mymvp.okrx.OkUtils
import com.lzy.okgo.model.HttpParams
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Never Fear   on 2018\8\10 0010.
Never More....
 */
abstract class BaseMvpAty<V: BaseView,P: Presenter<*, V>> : AppCompatActivity(), BaseMVP<V, P> {
    protected var presenter:P?=null
    private var  compositeDisable: CompositeDisposable?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter=createPresenter()
        presenter?.let {
            it.createModule()
            it.bindView(bindView())

        }

    }
    fun addDisable(disable: Disposable){
        if (compositeDisable==null){
            compositeDisable=CompositeDisposable()
        }
        compositeDisable?.add(disable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisable?.dispose()
        presenter?.let {
            it.destory()
        }
    }

}