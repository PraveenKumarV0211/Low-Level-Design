package adapter;

import core.LogAppender;
import core.LogFormatter;
import core.LogLevel;
import core.LogMessage;
import formatters.SimpleFormatters;

public class ConsoleAppender implements LogAppender {

    LogLevel logLevel;
    LogFormatter logFormatter;

    public ConsoleAppender() {
        this(LogLevel.DEBUG);
    }

    public ConsoleAppender(LogLevel logLevel){
        this.logLevel = logLevel;
        this.logFormatter = new SimpleFormatters();
    }

    @Override
    public void append(LogMessage logMessage) {
        if(!isEnabled(logMessage.getLevel())){
            return;
        }
        String message = logFormatter.format(logMessage);
        System.out.println(message);
    }

    @Override
    public void setLevel(LogLevel logLevel) {

    }

    @Override
    public LogLevel getLevel() {
        return null;
    }

    @Override
    public boolean isEnabled(LogLevel level) {
        return level.isGreaterOrEqual(this.logLevel);
    }
}
