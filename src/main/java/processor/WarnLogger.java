package processor;

import enums.LogLevel;
import sink.LogSink;

public class WarnLogger extends LoggerProcessor{
    public WarnLogger(LoggerProcessor nextLoggerProcessor, LogSink logSink) {
        super(nextLoggerProcessor, logSink);
    }
    @Override
    public void log(int logLevel, String message) {
        if(logLevel == LogLevel.WARN.ordinal()){
            logSink.log("WARN: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
