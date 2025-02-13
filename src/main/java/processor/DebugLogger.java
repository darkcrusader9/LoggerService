package processor;

import enums.LogLevel;
import sink.LogSink;

public class DebugLogger extends LoggerProcessor{
    public DebugLogger(LoggerProcessor nextLoggerProcessor, LogSink logSink) {
        super(nextLoggerProcessor, logSink);
    }
    @Override
    public void log(int logLevel, String message) {
        if(logLevel == LogLevel.DEBUG.ordinal()){
            logSink.log("DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
