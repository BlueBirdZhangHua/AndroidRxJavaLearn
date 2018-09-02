package com.blue.rxjava.rxjava.operator;

import android.graphics.Bitmap;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Map {

    public static void run(){
        Observable.just("What?")
                .map(new Function<String , Object>() {

                    @Override
                    public Object apply(String s) throws Exception {
                        return new Object();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.e("Demo" , o.toString());
                    }
                });
    }

}
