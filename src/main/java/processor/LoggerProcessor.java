package processor;

import sink.LogSink;

public class LoggerProcessor {
    protected LoggerProcessor nextLoggerProcessor;
    protected LogSink logSink;
    public LoggerProcessor(LoggerProcessor nextLoggerProcessor, LogSink logSink){
        this.nextLoggerProcessor = nextLoggerProcessor;
        this.logSink = logSink;
    }

    public void log(int logLevel, String message) {
        if (nextLoggerProcessor != null) {
            nextLoggerProcessor.log(logLevel, message);
        }
    }
}
