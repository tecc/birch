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
import org.intellij.lang.annotations.Language;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Formatters {
    private Properties props;

    public static String formatDate(Date date, String formatString) {
        DateFormat format = new SimpleDateFormat(formatString);
        return format.format(date);
    }

    /**
     * Formats a log level.
     *
     * @param level The level to format.
     * @param charCount The number of characters to use
     * @param padDirection The direction to pad the string in if it's too short.
     *                     False is backwards ({@code ##LVL}), true is forwards ({@code LVL##}).
     * @param padChar The character to pad the string with if it's too short.
     * @param truncDirection The direction to truncate the string in if it's too long.
     *                       False is backwards ({@code LEV__}), true is forwards ({@code __VEL}).
     * @return The formatted level string.
     */
    public static String formatLevel(Log.Level level, int charCount, boolean padDirection, char padChar, boolean truncDirection) {
        String display = level.display;
        // the desired length is already there, return
        if (display.length() == charCount) return display;
        if (display.length() > charCount) {
            /* the string is too long, truncate */
            if (truncDirection) {
                // truncate forwards
                return display.substring(0, charCount);
            } else {
                // truncate backwards
                return display.substring(display.length() - charCount);
            }
        } else {
            /* the string is too short, pad */
            // get padding string
            int remaining = charCount - display.length();
            StringBuilder padding = new StringBuilder();
            for (int i = 0; i < remaining; i++) {
                padding.append(padChar);
            }
            // return padded
            if (padDirection) {
                // pad forwards
                return display + padding;
            } else {
                return padding + display;
            }
        }
    }
}
