package me.tecc.birch.core.logger;

import java.util.List;

public class Logger {
    private String name;
    private Log.Level level;
    private List<String> appenders;

    public String getName() {
        return name;
    }

    public void log(Log log) {

    }

    public boolean canTrace() {
        return false;
    }
}
