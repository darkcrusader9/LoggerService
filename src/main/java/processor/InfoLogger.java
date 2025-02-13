package processor;

import enums.LogLevel;
import sink.LogSink;

public class InfoLogger extends LoggerProcessor{
    public InfoLogger(LoggerProcessor nextLoggerProcessor, LogSink logSink) {
        super(nextLoggerProcessor, logSink);
    }
    @Override
    public void log(int logLevel, String message) {
        if(logLevel == LogLevel.INFO.ordinal()){
            logSink.log("INFO: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
