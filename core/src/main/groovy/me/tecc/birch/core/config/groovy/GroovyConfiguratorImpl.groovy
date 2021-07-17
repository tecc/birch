/*
 * Copyright 2021 tecc.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
