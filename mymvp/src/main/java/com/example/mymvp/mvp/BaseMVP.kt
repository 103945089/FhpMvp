package com.example.mymvp.mvp

/**
 * Created by Never Fear   on 2018\8\10 0010.
Never More....
 */
interface BaseMVP<V: BaseView,P: Presenter<*, *>> {

    fun createPresenter():P
    fun bindView():V

}