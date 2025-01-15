package logger;

public abstract class LogProcessor {
    LogProcessor nextLogProcessor;
    LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(String leval, String message) {
        if(nextLogProcessor != null) {
            nextLogProcessor.log(leval, message);
        }
    }
}
