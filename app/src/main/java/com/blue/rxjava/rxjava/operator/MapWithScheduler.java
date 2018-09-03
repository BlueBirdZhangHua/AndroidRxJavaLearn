package com.blue.rxjava.rxjava.operator;


import android.util.Log;

import com.blue.rxjava.ThreadUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

/**
 * All Map or FlapMap operation is base on  lift function below.
 * We can se that evey operation is  create new Observable and Subscriber.
 * So before map we can use oberveOn to change map's working thread
    public <R> Observable<R> lift(Operator<? extends R, ? super T> operator) {
        return Observable.create(new OnSubscribe<R>() {
            @Override
            public void call(Subscriber subscriber) {
                Subscriber newSubscriber = operator.call(subscriber);
                newSubscriber.onStart();
                onSubscribe.call(newSubscriber);
            }
        });
    }
*/
public class MapWithScheduler {

    public static void run(){
        Observable.fromArray("1" , "2" , "3")
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        Log.d(DEMO_TAG , "[MapWithScheduler] Current thread id is:"+ThreadUtils.getThreadId() + " content is "+s);
                        return s;
                    }
                })
                .observeOn(Schedulers.computation())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        Log.d(DEMO_TAG , "[MapWithScheduler] Current thread id is:"+ThreadUtils.getThreadId() + " content is "+s);
                        return s;
                    }
                })
                .observeOn(Schedulers.newThread())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        Log.d(DEMO_TAG , "[MapWithScheduler] Current thread id is:"+ThreadUtils.getThreadId() + " content is "+s);
                        return s;
                    }
                })
                .subscribe();
    }

}
