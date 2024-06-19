package factory;

import enums.LogLevel;
import logger.Logger;
import sink.ConsoleSink;

public class ConsoleLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.INFO);
        logger.setLogSink(new ConsoleSink());
        return logger;
    }
}
