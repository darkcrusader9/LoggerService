package logger;

import enums.LogLevel;
import processor.*;
import sink.ConsoleSink;
import sink.LogSink;

public class Logger {
    private static volatile Logger INSTANCE;
    private LoggerProcessor logProcessorChain;
    LogLevel logLevel;
    LogSink logSink;

    private Logger(LogLevel defaultLogLevel, LogSink logSink) {
        this.logLevel = defaultLogLevel;
        this.logSink = logSink;
        this.logProcessorChain = createProcessorChain(logSink);
    }

    private LoggerProcessor createProcessorChain(LogSink logSink) {
        LoggerProcessor processor = null;

        if (logLevel.ordinal() <= LogLevel.ERROR.ordinal()) {
            processor = new ErrorLogger(processor, logSink);
        }
        if (logLevel.ordinal() <= LogLevel.WARN.ordinal()) {
            processor = new WarnLogger(processor, logSink);
        }
        if (logLevel.ordinal() <= LogLevel.INFO.ordinal()) {
            processor = new InfoLogger(processor, logSink);
        }
        if (logLevel.ordinal() <= LogLevel.DEBUG.ordinal()) {
            processor = new DebugLogger(processor, logSink);
        }

        return processor;
    }

    public static Logger getInstance(LogLevel defaultLogLevel, LogSink logSink) {
        Logger result = INSTANCE;
        if (result == null) {
            synchronized (Logger.class) {
                result = INSTANCE;
                if (result == null) {
                    INSTANCE = result = new Logger(defaultLogLevel, logSink);
                }
            }
        }
        return result;
    }

    public void setLogLevel(LogLevel newLogLevel) {
        this.logLevel = newLogLevel;
        this.logProcessorChain = createProcessorChain(logSink); // Recreate chain with new log level
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    // General logging method that checks the log level before processing the log
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            logProcessorChain.log(level.ordinal(), message);
        }
    }

}
