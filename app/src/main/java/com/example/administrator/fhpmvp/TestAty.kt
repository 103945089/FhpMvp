package com.example.administrator.fhpmvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mymvp.log

import com.example.mymvp.okrx.BaseAciton
import com.example.mymvp.okrx.JsonConvert
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Never Fear   on 2018\11\1 0001.
 * Never More....
 */

class TestAty : AppCompatActivity() {
    private val url = "http://tianma.wufenhuyu.com/HLHJ_news/api/category_list?id=2&page=1&number=0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OkGo.get<TestBean>(url)
                .converter(JsonConvert<TestBean>())
                .adapt(ObservableResponse<TestBean>())
                .subscribe(object :TestKtAction<Response<TestBean>>(){
                    override fun httpSuccess(t: Response<TestBean>) {

                    }
                    override fun httpFailed(e: Throwable?) {
                        log("okgo","错误的编号为${e}")
                    }

                    override fun onSubscribe(d: Disposable) {
                    }
                })


    }
}
