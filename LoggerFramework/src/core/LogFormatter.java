package core;

public interface LogFormatter {
    void setPattern(String pattern);
    String getPattern();
    String format(LogMessage logMessage);
}
