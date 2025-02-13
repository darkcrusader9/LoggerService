import enums.LogLevel;
import factory.ConsoleLoggerFactory;
import factory.FileLoggerFactory;
import factory.LoggerFactory;
import logger.Logger;

public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new ConsoleLoggerFactory();
        Logger logger = loggerFactory.createLogger(LogLevel.INFO);
        logger.info("Info log should be printed");
        logger.debug("Debug log should not be printed");
        logger.error("Error log should be printed");
        logger.warn("warn log should be printed");
    }
}
