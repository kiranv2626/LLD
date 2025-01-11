package elevator;

import java.util.Arrays;

public class InternalButton {
    InternalDispatcher internalDispatcher;
    int [] avilableFloors={1,2,3,4,5,6,7,8,9,10};
    public InternalButton() {
        this.internalDispatcher=new InternalDispatcher();
    }
    public void pressButton(int floor,ElevatorCar elevatorCar) {
        if(Arrays.stream(avilableFloors).anyMatch(f -> f == floor))
        {
            internalDispatcher.dispatchRequest(floor, elevatorCar);
        }
    }

}
