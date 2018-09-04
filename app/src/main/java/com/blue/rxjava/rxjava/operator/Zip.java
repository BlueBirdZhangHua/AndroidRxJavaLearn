package com.blue.rxjava.rxjava.operator;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

/**
 * Zip is opposite of FlapMap
 * It can combine serial Observables into one
 * Zip support up to nine Observables
 */
public class Zip {

    public static void run() {
        Observable<String> stepOne = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(DEMO_TAG, "[Zip] stepOne called");
                emitter.onNext("From step one");
            }
        })
                .subscribeOn(Schedulers.io());

        Observable<String> stepTwo = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(DEMO_TAG, "[Zip] stepTwo called");
                emitter.onNext("From step two");
            }
        })
                .subscribeOn(Schedulers.io());

        Observable.zip(stepOne, stepTwo, new BiFunction<String, String, String>() {
            @Override
            public String apply(String o, String o2) throws Exception {
                return o + "   " + o2;
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        Log.d(DEMO_TAG, "[Zip] zip result is " + o);
                    }
                });

    }

}
