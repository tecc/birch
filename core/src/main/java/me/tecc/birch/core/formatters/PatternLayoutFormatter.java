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

import java.util.Date;

public class PatternLayoutFormatter extends Formatter<PatternLayoutFormatter> {
    private String pattern;
    public PatternLayoutFormatter setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public String formatLine(String line) {
        throw new UnsupportedOperationException("PatternLayoutFormatter does not work yet"); // TODO:
    }
}
