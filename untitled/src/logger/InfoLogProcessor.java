package logger;

public class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void log(String leval, String message) {
        if(leval.equals("INFO")) {
            System.out.println("INFO: " + message);
        }
        else {
            super.log(leval, message);
        }
    }
}
