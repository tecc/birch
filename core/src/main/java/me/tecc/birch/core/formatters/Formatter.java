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

package me.tecc.birch.core.formatters;

import me.tecc.birch.core.logger.Log;

import java.util.Date;

public abstract class Formatter<This extends Formatter<This>> {
    protected Date date;
    protected String loggerName;
    protected Thread thread;
    protected Log.Level level;

    public This setLoggerName(String name) {
        this.loggerName = name;
        return (This) this;
    }
    public This setDate(Date date) {
        this.date = date;
        return (This) this;
    }
    public This setThread(Thread thread) {
        this.thread = thread;
        return (This) this;
    }

    public abstract String formatLine(String line);
}
