package command;

public class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOn() {
        System.out.println("Air conditioner turned on");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("Air conditioner turned off");
        isOn = false;
    }

    public void setTemperature(int temperature) {
        System.out.println("Temperature set to " + temperature);
        this.temperature = temperature;
    }
}
