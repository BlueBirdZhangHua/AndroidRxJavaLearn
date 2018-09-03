package com.blue.rxjava.rxjava;

import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import static com.blue.rxjava.MainActivity.DEMO_TAG;

public class Consumers {

    public static void run(){

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("A");
                emitter.onNext("B");
                emitter.onNext("C");
//                emitter.onError(new Throwable("We make an Error"));
                emitter.onComplete();
            }
        });

        Consumer<String> onNextConsumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                Log.d(DEMO_TAG , "[Consumers] Consumer onNext "+s);
            }
        };

        Consumer<Throwable> onErrorConsumer = new Consumer<Throwable>() {

            @Override
            public void accept(Throwable throwable) {
                Log.d(DEMO_TAG , "[Consumers] Consumer onError "+throwable.getMessage());
            }
        };

        Action onCompletedAction = new Action() {
            @Override
            public void run() {
                Log.d(DEMO_TAG , "[Consumers] Action onComplete ");
            }

        };

        // 自动创建 Subscriber ，并使用 onNextConsumer 来定义 onNext()
//        observable.subscribe(onNextConsumer);
        // 自动创建 Subscriber ，并使用 onNextConsumer 和 onErrorConsumer 来定义 onNext() 和 onError()
//        observable.subscribe(onNextConsumer, onErrorConsumer);
        // 自动创建 Subscriber ，并使用 onNextConsumer、 onErrorConsumer 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextConsumer, onErrorConsumer, onCompletedAction);
    }
}
