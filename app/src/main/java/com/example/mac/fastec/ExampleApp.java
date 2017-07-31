package com.example.mac.fastec;

import android.app.Application;

import com.example.core.app.Latte;
import com.joanzapata.android.iconify.fonts.FontAwesomeModule;

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
                .withIcon(new FontAwesomeModule())
                .configure();
    }
}
