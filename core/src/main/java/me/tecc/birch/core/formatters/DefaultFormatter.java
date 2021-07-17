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

public class DefaultFormatter extends Formatter<DefaultFormatter> {
    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss.SSS";

    @Override
    public String formatLine(String line) {
        // builder for adding the formatted log
        // finished will look like this:
        // yyyy-MM-dd HH:mm:ss.SSS [{thread name} {level}] {name}: {msg}
        StringBuilder formatted = new StringBuilder();
        // date
        formatted.append(Formatters.formatDate(date, DATE_FORMAT_STRING)).append(" ");
        // thread & level
        String levelString = Formatters.formatLevel(level, 5, false, ' ', false);
        formatted.append("[").append(thread.getName()).append(' ').append(levelString).append("] ");
        // name
        formatted.append(loggerName).append(": ");
        // message
        formatted.append(line);
        return formatted.toString();
    }
}
