package logger;

import enums.LogLevel;
import sink.ConsoleSink;
import sink.LogSink;

public class Logger {
    private static Logger INSTANCE;

    //Global log level set from log config
    private LogLevel logLevel;
    private LogSink logSink;

    private Logger() {
        this.logLevel = LogLevel.INFO;
        this.logSink = new ConsoleSink();
    }
    public static Logger getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Logger();
        return INSTANCE;
    }

    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public void setLogSink(LogSink sink) {
        logSink = sink;
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void warn(String message){
        log(LogLevel.WARNING, message);
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }

    public void log(LogLevel level, String message){
        if(logLevel.ordinal() <= level.ordinal()){
            String logMessage = "[" + level + "] " + message;
            logSink.log(logMessage);
        }
    }

}
