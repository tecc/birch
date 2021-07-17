package me.tecc.birch.core.logger;

import java.util.HashMap;
import java.util.Map;

public class Loggers {
    private static Map<String, Logger> loggers = new HashMap<>();
    private static Logger rootLogger;
    /**
     * Logger that doesn't do anything. Effectively NO-OP.
     */
    private static final Logger voidLogger = new VoidLogger();

    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new Logger());
        }
        return loggers.get(name);
    }

    public static Logger getLogger(Class<?> clz) {
        return getLogger(clz.getName());
    }

    public static Logger getRootLogger() {
        if (rootLogger == null) {

        }
        return rootLogger;
    }
}
