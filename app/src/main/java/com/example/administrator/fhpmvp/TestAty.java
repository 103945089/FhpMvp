package com.example.administrator.fhpmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mymvp.okrx.JsonConvert;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Never Fear   on 2018\11\1 0001.
 * Never More....
 */

public class TestAty extends AppCompatActivity {
    private String url="http://tianma.wufenhuyu.com/HLHJ_news/api/category_list?id=2&page=1&number=0";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkGo.<TestBean>get(url)
                .converter(new JsonConvert<TestBean>())
                .adapt(new ObservableResponse<TestBean>())
                .subscribe(new Observer<Response<TestBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<TestBean> stringResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
