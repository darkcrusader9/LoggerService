package factory;

import enums.LogLevel;
import logger.Logger;
import sink.ConsoleSink;
import sink.FileSink;

public class FileLoggerFactory implements LoggerFactory{
    private String filename;
    public FileLoggerFactory(String filename) {
        this.filename = filename;
    }
    @Override
    public Logger createLogger() {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.INFO);
        logger.setLogSink(new FileSink(filename));
        return logger;
    }
}
