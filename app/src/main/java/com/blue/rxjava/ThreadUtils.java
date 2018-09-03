package com.blue.rxjava;

import android.os.Looper;

public class ThreadUtils {

    public static boolean isInMainThread() {
        return  Looper.myLooper() == Looper.getMainLooper();
    }

    public static long getThreadId() {
        return Thread.currentThread().getId();
    }

}
