package com.blue.rxjava.rxjava.operator;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

public class Debounce {

    public static void run() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(DEMO_TAG, "[Debounce] start");
                Log.d(DEMO_TAG, "[Debounce] onNext 1");
                emitter.onNext("1");
                Thread.sleep(1000);
                Log.d(DEMO_TAG, "[Debounce] onNext 2");
                emitter.onNext("2");
                Log.d(DEMO_TAG, "[Debounce] onNext 3");
                emitter.onNext("3");
                Log.d(DEMO_TAG, "[Debounce] onNext 4");
                emitter.onNext("4");
                Log.d(DEMO_TAG, "[Debounce] onNext 5");
                emitter.onNext("5");
                Thread.sleep(1000);
                Log.d(DEMO_TAG, "[Debounce] onNext 6");
                emitter.onNext("6");
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(800, TimeUnit.MICROSECONDS)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(DEMO_TAG, "[Debounce] result " + s);
                    }
                });
    }

}
