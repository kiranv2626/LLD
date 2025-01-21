package command;

import java.util.Stack;

public class TurnOnCommand implements ICommand {

    AirConditioner airConditioner;
    TurnOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {

        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        airConditioner.turnOff();
    }
}
