package factory;

import enums.LogLevel;
import logger.Logger;

public interface LoggerFactory {
    Logger createLogger(LogLevel logLevel);
}
