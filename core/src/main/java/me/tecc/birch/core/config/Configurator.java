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
