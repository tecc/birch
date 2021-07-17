package me.tecc.birch.core.appenders;

import java.util.HashMap;
import java.util.Map;

public class Appenders {
    private Map<String, Appender> appenders = new HashMap<>();

    public void set(String name, Appender appender) {
        appenders.put(name, appender);
    }

    public Appender get(String key) {
        return appenders.get(key);
    }
}
