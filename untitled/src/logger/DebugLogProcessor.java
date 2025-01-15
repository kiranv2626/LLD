package logger;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void log(String leval, String message) {
        if(leval.equals("DEBUG")) {
            System.out.println("DEBUG: " + message);
        }
        else {
            super.log(leval, message);
        }
    }
}
