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
