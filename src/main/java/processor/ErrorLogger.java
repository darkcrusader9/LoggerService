package processor;

import enums.LogLevel;
import sink.LogSink;

public class ErrorLogger extends LoggerProcessor{
    public ErrorLogger(LoggerProcessor nextLoggerProcessor, LogSink logSink) {
        super(nextLoggerProcessor, logSink);
    }
    @Override
    public void log(int logLevel, String message) {
        if(logLevel == LogLevel.ERROR.ordinal()){
            logSink.log("ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
