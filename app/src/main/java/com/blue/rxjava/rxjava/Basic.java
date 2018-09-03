package com.blue.rxjava.rxjava;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

public class Basic {

    public static void run(){
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("a");
                emitter.onNext("b");
                emitter.onNext("c");
                emitter.onComplete();
            }
        });

        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(DEMO_TAG ,"Fully subscribe  "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(DEMO_TAG ,"Fully subscribe onComplete");
            }
        });


        Observable observable1 = Observable.just("a" , "b" , "c");
        observable1.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(DEMO_TAG ,"Just   "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(DEMO_TAG ,"Just onComplete");
            }
        });

        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable2 = Observable.fromArray(words);
        observable2.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(DEMO_TAG ,"fromArray "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(DEMO_TAG ,"fromArray onComplete");
            }
        });

    }
}
