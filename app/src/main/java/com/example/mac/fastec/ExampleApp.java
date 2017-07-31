package com.example.mac.fastec;

import android.app.Application;

import com.example.latte_core.app.Latte;

/**
 *
 * Created by mac on 2017/7/31.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://localhost:8080")
                .configure();
    }
}
