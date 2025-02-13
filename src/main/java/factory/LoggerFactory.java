package factory;

import enums.LogLevel;
import logger.Logger;
import sink.LogSink;

public interface LoggerFactory {
    Logger createLogger(LogLevel logLevel, LogSink logSink);
}
