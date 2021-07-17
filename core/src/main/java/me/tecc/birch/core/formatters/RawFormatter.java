package me.tecc.birch.core.formatters;

public class RawFormatter extends Formatter<RawFormatter> {
    private FormatFunction function;

    public RawFormatter setFunction(FormatFunction function) {
        this.function = function;
        return this;
    }

    @Override
    public String formatLine(String line) {
        return function.format(this, line);
    }

    public interface FormatFunction {
        String format(RawFormatter formatter, String message);
    }
}
