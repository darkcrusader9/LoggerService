package sink;

public class ConsoleSink implements LogSink{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
