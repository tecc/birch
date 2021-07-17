package me.tecc.birch.core.formatters;

import me.tecc.birch.core.logger.Log;

import java.util.Date;

public abstract class Formatter<This extends Formatter<This>> {
    protected Date date;
    protected String loggerName;
    protected Thread thread;
    protected Log.Level level;

    public This setLoggerName(String name) {
        this.loggerName = name;
        return (This) this;
    }
    public This setDate(Date date) {
        this.date = date;
        return (This) this;
    }
    public This setThread(Thread thread) {
        this.thread = thread;
        return (This) this;
    }

    public abstract String formatLine(String line);
}
