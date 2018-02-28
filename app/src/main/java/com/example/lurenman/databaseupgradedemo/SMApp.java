package com.example.lurenman.databaseupgradedemo;

import android.app.Application;
import android.content.Context;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 */

public class SMApp extends Application {
    public static Context mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
