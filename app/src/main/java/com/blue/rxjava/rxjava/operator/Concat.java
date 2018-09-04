package com.blue.rxjava.rxjava.operator;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

/**
 * Using concat to link other Observable,Only call onComplete will continue with next Observable.
 * Call onNext will skip next Observable
 * concat support up to four Observable.If you have more than four pls use concatArray
 * By the way : Observable.concat(a,b)==a.concatWith(b)
 */
public class Concat {

    public static void run() {

        Observable<String> stepOne = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(DEMO_TAG, "[Concat] stepOne call onComplete");
                emitter.onComplete();
            }
        });

        Observable stepTwo = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(DEMO_TAG, "[Concat] stepTwo call onNext");
                emitter.onNext("[Concat] stepTwo bean called");
            }
        });

        Observable stepThree = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(DEMO_TAG, "[Concat] stepThree bean called");
                emitter.onComplete();
            }
        });

        Observable.concat(stepOne, stepTwo, stepThree)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.d(DEMO_TAG, "[Concat] concat step bean called");
                    }
                });

    }

}
