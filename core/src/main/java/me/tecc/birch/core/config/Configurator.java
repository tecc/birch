package me.tecc.birch.core.config;

import me.tecc.birch.core.appenders.Appender;
import me.tecc.birch.core.logger.Logger;

import java.util.List;

public abstract class Configurator {
    public abstract boolean available();
    public abstract void configure();
    public abstract boolean isConfigured();

    public abstract List<Logger> getLoggers();
    public abstract List<Appender> getAppenders();
}
