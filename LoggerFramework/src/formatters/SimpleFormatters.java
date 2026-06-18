package formatters;

import core.LogFormatter;
import core.LogMessage;

import java.time.format.DateTimeFormatter;

public class SimpleFormatters implements LogFormatter {
    private String pattern;
    private String dateFormat;
    private DateTimeFormatter dateTimeFormatter;

    public SimpleFormatters(){
        this("[%LEVEL] %TIMESTAMP - %MESSAGE");
    }
    public SimpleFormatters(String pattern){
        this.pattern = pattern;
        this.dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }
    @Override
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public String format(LogMessage message) {
        if (pattern == null || pattern.isEmpty()) {
            return String.format("[%s] %s - %s",
                    message.getLevel(),
                    message.getTimeStamp().toString(),
                    message.getMessage());
        }

        String formatted = pattern
                .replace("%LEVEL", message.getLevel().toString())
                .replace("%TIMESTAMP", message.getTimeStamp().toString())
                .replace("%MESSAGE", message.getMessage())
                .replace("%SOURCE", message.getSource() != null ? message.getSource() : "");

        return formatted;
    }
}
