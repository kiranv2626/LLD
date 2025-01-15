package logger;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void log(String leval, String message) {
        if(leval.equals("ERROR")) {
            System.out.println("ERROR: " + message);
        }
        else {
            super.log(leval, message);
        }
    }
}
