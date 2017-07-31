package com.example.latte_core.app;

import java.util.WeakHashMap;

/**
 *
 * Created by mac on 2017/7/31.
 */

public class Configurator {

    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);

    }

    public WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }



    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    @SuppressWarnings("unchecked")
    public <T> T getConfiguration(ConfigType type) {
        checkConfigReady();
        return (T) LATTE_CONFIGS.get(type.name());
    }

    private static void checkConfigReady() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,please call configure");
        }
    }
}
