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
