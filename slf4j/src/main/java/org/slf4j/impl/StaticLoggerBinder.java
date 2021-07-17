package org.slf4j.impl;

import me.tecc.birch.slf4j.SLF4JLoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {
    private SLF4JLoggerFactory loggerFactory;

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return "me.tecc.birch.slf4j.LoggerFactory";
    }
}
