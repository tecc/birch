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
