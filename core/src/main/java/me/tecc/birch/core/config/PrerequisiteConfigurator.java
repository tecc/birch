package me.tecc.birch.core.config;

import me.tecc.birch.core.appenders.Appender;
import me.tecc.birch.core.logger.Logger;
import me.tecc.birch.core.logger.Loggers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

public abstract class PrerequisiteConfigurator extends Configurator {
    private Configurator underlying;
    private boolean configured;

    public abstract String getUnderlyingClassName();
    public String[] getRequiredClasses() {
        return new String[]{};
    }

    @Override
    public void configure() {
        if (!resolveUnderlying()) {
            throw new InvalidConfiguratorException(getUnderlyingClassName(), "Couldn't be resolved in configure call");
        }
        this.underlying.configure();
        this.configured = this.underlying.isConfigured();
    }

    @Override
    public boolean isConfigured() {
        if (this.underlying == null) return false;
        return this.configured;
    }

    @Override
    public List<Logger> getLoggers() {
        if (underlying == null) return null;
        return underlying.getLoggers();
    }

    @Override
    public List<Appender> getAppenders() {
        if (underlying == null) return null;
        return underlying.getAppenders();
    }

    @Override
    public boolean available() {
        if (this.underlying != null) return this.underlying.available();
        try {
            for (String name : getRequiredClasses()) {
                classForName(name, false);
            }
        } catch (Exception ignored) {
            return false;
        }
        return resolveUnderlying();
    }
    private boolean resolveUnderlying() {
        if (this.underlying != null) return true;
        Class<? extends Configurator> configuratorClass;
        try {
            Class<?> basicClass = classForName(getUnderlyingClassName(), true);
            if (!Configurator.class.isAssignableFrom(basicClass))
                // throw new InvalidConfiguratorException(getUnderlyingClassName(), "Supposed configurator class does not extend Configurator");
                return false;
            configuratorClass = (Class<? extends Configurator>) basicClass;
        } catch (ClassNotFoundException e) {
            // throw new InvalidConfiguratorException(getUnderlyingClassName(), "Class does not exist", e);
            return false;
        }
        try {
            Constructor<? extends Configurator> constructor = configuratorClass.getDeclaredConstructor();
            this.underlying = constructor.newInstance();
            return true;
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            return false;
        }
    }

    private Class<?> classForName(String name, boolean initialise) throws ClassNotFoundException {
        return Class.forName(name, initialise, this.getClass().getClassLoader());
    }
}
