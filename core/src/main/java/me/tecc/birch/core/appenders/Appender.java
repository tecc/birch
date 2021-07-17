package me.tecc.birch.core.appenders;

import me.tecc.birch.core.logger.Log;

public interface Appender {
    void open();
    void append(Log line);
    void close();
}
