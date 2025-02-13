import enums.LogLevel;
import factory.DefaultLoggerFactory;
import factory.LoggerFactory;
import logger.Logger;
import sink.ConsoleSink;
import sink.FileSink;

public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new DefaultLoggerFactory();
        Logger logger = loggerFactory.createLogger(LogLevel.INFO, new FileSink("test.txt"));
        logger.info("Info log should be printed");
        logger.debug("Debug log should not be printed");
        logger.error("Error log should be printed");
        logger.warn("warn log should be printed");
    }
}
