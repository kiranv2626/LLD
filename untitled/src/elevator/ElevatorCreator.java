package elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    static List<ElevatorController> elevatorControllers = new ArrayList<ElevatorController>();
    static{
        ElevatorCar elevatorCar=new ElevatorCar();
        elevatorCar.setId(1);
        ElevatorCar elevatorCar2=new ElevatorCar();
        elevatorCar2.setId(2);
        elevatorControllers.add(new ElevatorController(elevatorCar2));
        elevatorControllers.add(new ElevatorController(elevatorCar));
    }

}
