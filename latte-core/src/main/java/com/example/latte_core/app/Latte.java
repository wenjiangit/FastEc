package com.example.latte_core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 *
 * Created by mac on 2017/7/31.
 */

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }



}
