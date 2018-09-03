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
            public void subscribe(ObservableEmitter<String> emitter) {
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
                Log.d(DEMO_TAG ,"[Basic] Fully subscribe  "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(DEMO_TAG ,"[Basic] Fully subscribe onComplete");
            }
        });


        Observable observable1 = Observable.just("a" , "b" , "c");
        observable1.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(DEMO_TAG ,"[Basic] Just   "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(DEMO_TAG ,"[Basic] Just onComplete");
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
                Log.d(DEMO_TAG ,"[Basic] fromArray "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(DEMO_TAG ,"[Basic] fromArray onComplete");
            }
        });

    }
}
