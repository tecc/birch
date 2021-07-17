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

package me.tecc.birch.core.logger;

import java.util.HashMap;
import java.util.Map;

public class Loggers {
    private static Map<String, Logger> loggers = new HashMap<>();
    private static Logger rootLogger;
    /**
     * Logger that doesn't do anything. Effectively NO-OP.
     */
    private static final Logger voidLogger = new VoidLogger();

    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new Logger());
        }
        return loggers.get(name);
    }

    public static Logger getLogger(Class<?> clz) {
        return getLogger(clz.getName());
    }

    public static Logger getRootLogger() {
        if (rootLogger == null) {

        }
        return rootLogger;
    }
}
