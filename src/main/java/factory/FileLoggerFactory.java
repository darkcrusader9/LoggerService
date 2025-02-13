//package factory;
//
//import enums.LogLevel;
//import logger.Logger;
//import sink.ConsoleSink;
//import sink.FileSink;
//
//public class FileLoggerFactory implements LoggerFactory{
//    private String filename;
//    public FileLoggerFactory(String filename) {
//        this.filename = filename;
//    }
//    @Override
//    public Logger createLogger(LogLevel logLevel) {
//        return Logger.getInstance(logLevel, new FileSink(filename));
//    }
//}
