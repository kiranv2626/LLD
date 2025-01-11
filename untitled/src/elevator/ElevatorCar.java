package elevator;

public class ElevatorCar {
    public int id;
    int currentFloor;
    Direction direction;
    State state;
    Display display;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public void setInternalButton(InternalButton internalButton) {
        this.internalButton = internalButton;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    InternalButton internalButton;
    public ElevatorCar()
    {
        this.currentFloor=0;
        this.direction=Direction.UP;
        this.state=State.IDLE;
        this.display=new Display();
        this.internalButton=new InternalButton();
    }
    void pressButton(int floor) {
        internalButton.pressButton(floor,this);
    }
    void setDisplay(int currentFloor, Direction direction)
    {
        display.setDisplay(currentFloor, direction);
    }
    void showDisplay() {
        display.getDisplay();
    }
    Boolean Move(int destination, Direction direction) {
        {
            int currentFloor = this.currentFloor;
            if(direction==Direction.UP)
            {
                for(int i=currentFloor;i<=destination;i++)
                {
                    this.currentFloor=i;
                    setDisplay(currentFloor, direction);
                    showDisplay();
                    if(i==destination)
                        return true;
                }
            }
            else if(direction==Direction.DOWN)
            {
                for(int i=currentFloor;i<=destination;i--)
                {
                    this.currentFloor=i;
                    setDisplay(currentFloor, direction);
                    showDisplay();
                    if(i==destination)
                        return true;
                }
            }
            return false;
        }
    }
}
