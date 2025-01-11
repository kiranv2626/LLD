package elevator;

import java.util.ArrayList;
import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllers = ElevatorCreator.elevatorControllers;

    public void dispatchRequest(int floor, ElevatorCar elevatorCar) {
        for (ElevatorController elevatorController : elevatorControllers) {
            if (elevatorController.elevatorCar == elevatorCar) {
                elevatorController.acceptInternalRequest(floor);
            }
        }
    }

}
