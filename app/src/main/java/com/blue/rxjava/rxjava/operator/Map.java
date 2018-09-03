package com.blue.rxjava.rxjava.operator;

import android.util.Log;

import com.blue.rxjava.ThreadUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

/**
 * This demo shows how to use map to convert target entity
 */
public class Map {

    public static void run(){
        Observable.just("What?")
                .map(new Function<String , Object>() {

                    @Override
                    public Object apply(String s) throws Exception {
                        Log.e(DEMO_TAG , "Map is in main thread? "+ ThreadUtils.isInMainThread());
                        return new Object();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.e(DEMO_TAG , o.toString());
                    }
                });
    }

}
