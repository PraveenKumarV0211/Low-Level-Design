package core;

import adapter.ConsoleAppender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoggerImpl implements Logger{
    private final String name;
    private LogLevel level;
    private final List<LogAppender> appenders;

    public LoggerImpl(){
        this("DefaultLogger");
    }
    public LoggerImpl(String name){
        this(name,true);
    }

    public LoggerImpl(String name, boolean addDefaultAppender){
        this.name = name;
        this.level = LogLevel.DEBUG;
        this.appenders = Collections.synchronizedList(new ArrayList<>());
        if(addDefaultAppender){
            addAppender(new ConsoleAppender());
        }
    }


    @Override
    public void debug(String message) {
        log(LogLevel.DEBUG,message);
    }

    @Override
    public void info(String message) {
        log(LogLevel.INFO,message);
    }

    @Override
    public void warning(String message) {
        log(LogLevel.WARNING,message);
    }

    @Override
    public void error(String message) {
        log(LogLevel.ERROR,message);
    }

    @Override
    public void fatal(String message) {
        log(LogLevel.FATAL,message);
    }

    @Override
    public void log(LogLevel level, String message) {
        LogMessage logMessage = new LogMessage.Builder().level(level).message(message).build();

        for (LogAppender appender : appenders){
            if(appender.isEnabled(level)){
                appender.append(logMessage);
            }
        }
    }

    @Override
    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    @Override
    public List<LogAppender> getAppenders() {
        return appenders;
    }

}
