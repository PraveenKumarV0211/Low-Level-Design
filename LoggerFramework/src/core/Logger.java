package core;

import java.util.List;

public interface Logger {
    //logging methods
    void debug(String message);
    void info(String message);
    void warning(String message);
    void error(String message);
    void fatal(String message);

    // Generic logging
    void log(LogLevel level, String message);
    void addAppender(LogAppender appender);
    List<LogAppender> getAppenders();
}
