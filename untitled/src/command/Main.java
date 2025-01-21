package command;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        MyRemote myRemote = new MyRemote();
        myRemote.setCommand(new TurnOnCommand(airConditioner));
        myRemote.execute();
        myRemote.undo();
    }
}
