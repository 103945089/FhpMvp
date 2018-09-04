package com.example.mymvp.mvp

/**
 * Created by Never Fear   on 2018\8\10 0010.
Never More....
 */
interface Presenter<M: BaseModule,V: BaseView> {


    fun createModule()

    fun bindView(view:V):V


    fun destory()
}