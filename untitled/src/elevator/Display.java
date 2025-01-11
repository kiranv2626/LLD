package elevator;

public class Display {
    int currentFloor;
    Direction Direction;
    public void setDisplay(int currentFloor, Direction Direction) {
        this.currentFloor = currentFloor;
        this.Direction = Direction;
    }
    public void getDisplay() {
        System.out.println("Current Floor: " + currentFloor);
        System.out.println("Direction: " + Direction);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public elevator.Direction getDirection() {
        return Direction;
    }

    public void setDirection(elevator.Direction direction) {
        Direction = direction;
    }
}
