package com.blue.rxjava.rxjava;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Consumers {

    public static void run(){

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("A");
                emitter.onNext("B");
                emitter.onNext("C");
//                emitter.onError(new Throwable("We make an Error"));
                emitter.onComplete();
            }
        });

        Consumer<String> onNextConsumer = new Consumer<String>() {

            @Override
            public void accept(String s) throws Exception {
                Log.e("Demo" , "Consumer onNext "+s);
            }
        };

        Consumer<Throwable> onErrorConsumer = new Consumer<Throwable>() {

            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("Demo" , "Consumer onError "+throwable.getMessage());
            }
        };

        Action onCompletedAction = new Action() {
            @Override
            public void run() throws Exception {
                Log.e("Demo" , "Action onComplete ");
            }

        };

        // 自动创建 Subscriber ，并使用 onNextConsumer 来定义 onNext()
        observable.subscribe(onNextConsumer);
        // 自动创建 Subscriber ，并使用 onNextConsumer 和 onErrorConsumer 来定义 onNext() 和 onError()
        observable.subscribe(onNextConsumer, onErrorConsumer);
        // 自动创建 Subscriber ，并使用 onNextConsumer、 onErrorConsumer 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextConsumer, onErrorConsumer, onCompletedAction);
    }
}
