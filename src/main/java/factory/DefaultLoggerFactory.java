package factory;

import enums.LogLevel;
import logger.Logger;
import sink.LogSink;

public class DefaultLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger(LogLevel logLevel, LogSink logSink) {
        return Logger.getInstance(logLevel, logSink);
    }
}
