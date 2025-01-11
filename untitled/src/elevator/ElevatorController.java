package elevator;

import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {
    ElevatorCar elevatorCar;
    PriorityQueue<Integer> upMin;
    PriorityQueue<Integer> downMax;
    Queue<Integer> queue;

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMin = new PriorityQueue<>();
        downMax = new PriorityQueue<>((a, b) -> b - a); // Max heap for down requests
        queue = new PriorityQueue<>();

    }

    void acceptInternalRequest(int floor) {
        // Accept internal request based on the current floor
        if (floor > this.elevatorCar.getCurrentFloor()) {
            upMin.add(floor);
        } else if (floor < this.elevatorCar.getCurrentFloor()) {
            downMax.add(floor);
        }
        startElevator();
    }

    void acceptExternalRequest(int floor, Direction direction) {
        // Accept external request based on the current direction
        if (elevatorCar.getDirection() == Direction.UP) {
            if (direction == Direction.UP && floor > this.elevatorCar.getCurrentFloor()) {
                upMin.add(floor);
            } else if (direction == Direction.DOWN && floor < this.elevatorCar.getCurrentFloor()) {
                downMax.add(floor);
            }
        } else {
            if (direction == Direction.DOWN && floor < this.elevatorCar.getCurrentFloor()) {
                downMax.add(floor);
            } else if (direction == Direction.UP && floor > this.elevatorCar.getCurrentFloor()) {
                upMin.add(floor);
            }
        }
        startElevator();
    }

    public void startElevator() {
        do{
            System.out.println("Elevator is at floor " + elevatorCar.getCurrentFloor());
            ProcessRequestsUp();
            ProcessRequestsDown();
        }while(!upMin.isEmpty() || !downMax.isEmpty());
    }

    void ProcessRequestsUp() {
        // Process up requests while there are requests in the upMin queue
        while (!upMin.isEmpty()) {
            int destination = upMin.poll();
            System.out.println("Stopping at floor " + destination);
            elevatorCar.Move(destination, Direction.UP);  // Assuming a move method in ElevatorCar
        }
        // If no up requests, switch direction to down
        if (upMin.isEmpty()) {
            elevatorCar.setDirection(Direction.DOWN);
            // Move downMax requests to upMin for further processing
            while (!queue.isEmpty()) {
                upMin.add(queue.poll());
            }
        }
    }

    void ProcessRequestsDown() {
        // Process down requests while there are requests in the downMax queue
        while (!downMax.isEmpty()) {
            int destination = downMax.poll();
            System.out.println("Stopping at floor " + destination);
            elevatorCar.Move(destination, Direction.DOWN);  // Assuming a move method in ElevatorCar
        }
        // If no down requests are left, continue with up requests if necessary
        if (downMax.isEmpty()) {
            elevatorCar.setDirection(Direction.UP);
            while (!queue.isEmpty()) {
                downMax.add(queue.poll());
            }
        }
    }
}
