package me.tecc.birch.core.config;

public class InvalidConfiguratorException extends RuntimeException {
    public InvalidConfiguratorException(Class<? extends Configurator> clz) {
        super(clz.getName() + " is invalid");
    }

    public InvalidConfiguratorException(Class<? extends Configurator> clz, String message) {
        this(clz.getName(), message);
    }
    public InvalidConfiguratorException(String className, String message) {
        super(className + " is invalid: " + message);
    }

    public InvalidConfiguratorException(Class<? extends Configurator> clz, Throwable cause) {
        this(clz.getName(), cause);
    }

    public InvalidConfiguratorException(String className, Throwable cause) {
        super(className + " is invalid", cause);
    }

    public InvalidConfiguratorException(Class<? extends Configurator> clz, String message, Throwable cause) {
        this(clz.getName(), message, cause);
    }
    public InvalidConfiguratorException(String className, String message, Throwable cause) {
        super(className + " is invalid: " + message, cause);
    }
}
