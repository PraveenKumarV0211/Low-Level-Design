package core;

public interface LogAppender {
    void append(LogMessage logMessage);
    void setLevel(LogLevel logLevel);
    LogLevel getLevel();
    boolean isEnabled(LogLevel level);
}
