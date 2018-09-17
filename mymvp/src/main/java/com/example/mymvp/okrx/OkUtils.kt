package com.example.mymvp.okrx

import com.lzy.okgo.OkGo
import com.lzy.okgo.model.HttpParams
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Never Fear   on 2018\9\4 0004.
Never More....
 */
object OkUtils {
    var POST=2
    var GET=1
    /**
     * httpType-1-get 2-post
     */
    fun <T>createObservable(httpParams: HttpParams,url:String,httpType:Int): Observable<Response<T>>? {
        if (httpType==1){
            return  OkGo.get<T>(url)
                    .params(httpParams)
                    .converter(object :JsonConvert<T>(){})
                    .adapt(ObservableResponse<T>())
                    .subscribeOn(Schedulers.io())
        }else {
            return  OkGo.post<T>(url)
                    .params(httpParams)
                    .converter(object :JsonConvert<T>(){})
                    .adapt(ObservableResponse<T>())
                    .subscribeOn(Schedulers.io())
        }
    }
}