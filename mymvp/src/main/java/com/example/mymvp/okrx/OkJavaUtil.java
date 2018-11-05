package com.example.mymvp.okrx;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Never Fear   on 2018\11\5 0005.
 * Never More....
 */

public class OkJavaUtil {
    public final static int POST=1;
    public final static int GET=2;


    public static <T> Observable<Response<T>> createRequest(HttpParams params, String url , int httpType){
        switch (httpType){
            case POST:
              return  OkGo.<T>post(url)
                        .params(params)
                        .converter(new JsonConvert<T>(){})
                        .adapt(new ObservableResponse<T>())
                        .subscribeOn(Schedulers.io());
            case GET:
               return  OkGo.<T>get(url)
                        .params(params)
                        .converter(new JsonConvert<T>(){})
                        .adapt(new ObservableResponse<T>())
                        .subscribeOn(Schedulers.io());

            default:
                return null;
        }
    }
}
