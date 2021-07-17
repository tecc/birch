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

import me.tecc.birch.core.formatters.Formatter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Log {
    private String level;
    private Date timestamp;
    private String message;

    public List<String> format(Formatter formatter) {
        List<String> lines = new ArrayList<>();
        StringBuilder cl = new StringBuilder();
        // loop through each char
        for (int i = 0; i < message.length(); i++) {
            // get character at i
            char c = message.charAt(i);
            if (
                    c == '\n' // unix newlines, e.g. LF
                    || c == '\r' && message.charAt(i + 1) == '\n' // windows newlines, CRLF
            ) {
                // newline means new formatted line
                lines.add(formatter.formatLine(cl.toString()));
                cl = new StringBuilder();
                if (c == '\r') i++;
            }
            // add char
            cl.append(c);
        }
        // return formatted lines
        return lines;
    }

    public static class Level implements Comparable<Level> {
        public static final Level DEBUG = new Level(-1, "DEBUG");
        public static final Level INFO = new Level(0, "INFO");
        public static final Level WARN = new Level(1, "WARN");
        public static final Level ERROR = new Level(2, "ERROR");

        public final int value;
        public final String display;

        public Level(int value, String display) {
            this.value = value;
            this.display = display;
        }

        @Override
        public int compareTo(@NotNull Log.Level o) {
            return compare(this, o);
        }

        public static int compare(Level a, Level b) {
            if (a == null && b == null) return 0;
            if (a == null) return -1;
            if (b == null) return 1;
            return Integer.compare(a.value, b.value);
        }
    }
}
