package com.blue.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blue.rxjava.rxjava.Basic;
import com.blue.rxjava.rxjava.Consumers;
import com.blue.rxjava.rxjava.operator.FlapMap;
import com.blue.rxjava.rxjava.operator.Map;
import com.blue.rxjava.rxjava.Scheduler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Basic.run();
        Consumers.run();
        Scheduler.run();
        Map.run();
        FlapMap.run();
    }

}
