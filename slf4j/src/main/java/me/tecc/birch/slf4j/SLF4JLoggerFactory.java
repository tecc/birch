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
