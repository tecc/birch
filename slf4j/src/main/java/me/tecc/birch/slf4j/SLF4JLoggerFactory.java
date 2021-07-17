package me.tecc.birch.slf4j;

import me.tecc.birch.core.logger.Loggers;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.spi.LoggerFactoryBinder;

import java.util.Map;

public class SLF4JLoggerFactory implements ILoggerFactory {
    private Map<String, SLF4JLogger> loggers;

    @Override
    public Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new SLF4JLogger(Loggers.getLogger(name)));
        }
        return loggers.get(name);
    }
}
