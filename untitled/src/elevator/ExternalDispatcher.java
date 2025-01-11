package elevator;

import java.util.List;

public class ExternalDispatcher {
    List<ElevatorController> elevatorControllers = ElevatorCreator.elevatorControllers;

    public void dispatchRequest(int floor, Direction direction) {
        for (ElevatorController elevatorController : elevatorControllers) {
            if(elevatorController.elevatorCar.getId()%2==1 && floor%2==1)
            {
                elevatorController.acceptExternalRequest(floor, direction);
            }
            else
            {
                if(elevatorController.elevatorCar.getId()%2==0 && floor%2==0)
                {
                    elevatorController.acceptExternalRequest(floor, direction);
                }
            }
        }
    }
}
