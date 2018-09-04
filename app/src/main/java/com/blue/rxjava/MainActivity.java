package com.blue.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blue.rxjava.rxjava.Basic;
import com.blue.rxjava.rxjava.Consumers;
import com.blue.rxjava.rxjava.operator.Concat;
import com.blue.rxjava.rxjava.operator.FlapMap;
import com.blue.rxjava.rxjava.operator.Map;
import com.blue.rxjava.rxjava.Scheduler;
import com.blue.rxjava.rxjava.operator.MapWithScheduler;


public class MainActivity extends AppCompatActivity {
    public static String DEMO_TAG = "Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Basic.run();
        Consumers.run();
        Scheduler.run();
        Map.run();
        FlapMap.run();
        MapWithScheduler.run();
        Concat.run();
    }

}
