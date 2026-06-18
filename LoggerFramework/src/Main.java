import adapter.ConsoleAppender;
import core.LogLevel;
import core.Logger;
import core.LoggerImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Logger logger = new LoggerImpl("MyApp");

        logger.debug("starting Application");
        logger.info("Server listening on port 8080");
        logger.warning("Disk usage above 80%");
        logger.error("Failed to connect to database");
        logger.fatal("System out of memory");


        LoggerImpl filtered = new LoggerImpl("FilteredLogger", false);
        ConsoleAppender appender = new ConsoleAppender(LogLevel.WARNING);
        filtered.addAppender(appender);

        filtered.debug("This should NOT print");
        filtered.info("This should NOT print");
        filtered.warning("This SHOULD print");
        filtered.error("This SHOULD print");
    }
}