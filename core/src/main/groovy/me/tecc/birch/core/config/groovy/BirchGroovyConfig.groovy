package me.tecc.birch.core.config.groovy

import groovy.util.GroovyScriptEngine
import me.tecc.birch.core.logger.Log
import org.jetbrains.annotations.NotNull

abstract class BirchGroovyConfig extends Script {
    public static final Log.Level DEBUG = Log.Level.DEBUG
    public static final Log.Level INFO = Log.Level.INFO
    public static final Log.Level WARN = Log.Level.WARN
    public static final Log.Level ERROR = Log.Level.ERROR

    Map<String, LoggerConfig> loggerConfigs

    def logger(@NotNull String name, @NotNull Closure closure) {
        def config = new LoggerConfig()
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = config
        closure.run()
        loggerConfigs.put(name, config)
    }
}
