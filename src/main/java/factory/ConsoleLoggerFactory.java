//package factory;
//
//import enums.LogLevel;
//import logger.Logger;
//import sink.ConsoleSink;
//
//public class ConsoleLoggerFactory implements LoggerFactory{
//    @Override
//    public Logger createLogger(LogLevel logLevel) {
//        return Logger.getInstance(logLevel, new ConsoleSink());
//    }
//}
