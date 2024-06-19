package sink;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSink implements LogSink{
    private String filename;
    public FileSink(String filename) {
        this.filename = filename;
    }
    @Override
    public void log(String message) {
        try{
            PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true));
            printWriter.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
