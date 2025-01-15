package logger;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log("INFO", "This is an info message");
        logProcessor.log("DEBUG", "This is a debug message");
        logProcessor.log("ERROR", "This is an error message");
    }
}
