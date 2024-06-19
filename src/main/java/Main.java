import factory.ConsoleLoggerFactory;
import factory.FileLoggerFactory;
import factory.LoggerFactory;
import logger.Logger;

public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new ConsoleLoggerFactory();
        Logger log = loggerFactory.createLogger();
        log.debug("Debug log -> shouldnt be visible");
        log.info("Info level log");
        log.error("Error log");

        LoggerFactory loggerFactory1 = new FileLoggerFactory("log.txt");
        Logger log1 = loggerFactory1.createLogger();
        log1.info("Info level log");
        log1.info("Error log");
    }
}
