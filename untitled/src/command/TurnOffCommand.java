package command;

public class TurnOffCommand implements ICommand {
    AirConditioner airConditioner;
    public TurnOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.turnOff();
    }
    @Override
    public void undo() {
        airConditioner.turnOn();
    }
}
