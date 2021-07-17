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
