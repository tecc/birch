package me.tecc.birch.core.config.groovy

import me.tecc.birch.core.appenders.Appender
import me.tecc.birch.core.config.Configurator
import me.tecc.birch.core.logger.Logger
import org.codehaus.groovy.control.CompilerConfiguration

class GroovyConfiguratorImpl extends Configurator {
    private BirchGroovyConfig config
    public static GroovyShell shell

    static {
        def config = new CompilerConfiguration()
        config.scriptBaseClass = BirchGroovyConfig.class.name

        shell = new GroovyShell(this.class.classLoader, new Binding(), config)
    }

    @Override
    boolean available() {
        return resourceStream != null
    }

    @Override
    void configure() {
        try {
            def script = shell.parse(resourceStream.newReader())
            assert script instanceof BirchGroovyConfig
            this.config = script
            config.run()

        } catch (ignored) {
            this.config = null
        }
    }

    @Override
    boolean isConfigured() {
        return this.config != null
    }

    @Override
    List<Logger> getLoggers() {
        return null
    }

    @Override
    List<Appender> getAppenders() {
        return null
    }

    private InputStream getResourceStream() {
        return this.getClass().getClassLoader().getResourceAsStream("birch-config.groovy")
    }
}
