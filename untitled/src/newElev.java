package thread;


import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        ElevatorSelectionStrategy strategy=new MinSeekElevatorSelectionStrategy();
        Building b1=new Building(10,5,3,strategy);
        ElevatorManager em=b1.getEm();
        em.processRequest(1,10);
        em.processRequest(2,5);
        em.processRequest(3,9);
        em.processRequest(4,4);
        b1.getFloor(2).getExternalButton().PressButton(2,3);

    }
}

enum Direction
{
    UP,
    DOWN
}


class Display
{
    Direction dir;
    int curFloor;
    Display(Direction dir,int curFloor)
    {
        this.dir=dir;
        this.curFloor=curFloor;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public int getCurFloor() {
        return curFloor;
    }

    public void setCurFloor(int curFloor) {
        this.curFloor = curFloor;
    }

    public void setDisplay(Direction dir,int curFloor)
    {
       System.out.println("Direction is "+dir);
       System.out.println("Current Floor is "+curFloor);
    }

}
class Request
{
    int fromFloor;
    int toFloor;
    Request(int fromFloor,int toFloor)
    {
        this.fromFloor=fromFloor;
        this.toFloor=toFloor;
    }
}
class InternalButton
{

        void PressButton(ElevatorCar ec,Request request) {
            ec.addRequest(request);
        }
}
class ExternalButton{
    ElevatorManager em;
    ExternalButton(ElevatorManager em) {
        this.em = em;
    }
    void PressButton(int fromFloor,int toFloor)
    {
     em.processRequest(fromFloor,toFloor);
    }
}
class Building
{
    int noOfFloors;
    List<Floor> floors;
    ElevatorManager em;
    Building(int noOfFloors,int capacity,int noOfElevators,ElevatorSelectionStrategy strategy)
    {
        this.noOfFloors=noOfFloors;
        floors=new ArrayList<Floor>();
        em=new ElevatorManager(noOfElevators,capacity,strategy);
        for(int i=1;i<=noOfFloors;i++)
        {
            floors.add(new Floor(i,em));
        }
    }
    void addFloor(Floor floor)
    {
        floors.add(floor);
    }

    Floor getFloor(int id)
    {
        for(Floor f:floors)
        {
            if(f.getId()==id)
            {
                return f;
            }
        }
        return null;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public List<Floor> getFloors(int i) {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public ElevatorManager getEm() {
        return em;
    }

    public void setEm(ElevatorManager em) {
        this.em = em;
    }
}
class Floor
{
    int id;
    ExternalButton externalButton;
    Floor(int id,ElevatorManager em)
    {
        this.id=id;
        externalButton=new ExternalButton(em);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExternalButton getExternalButton() {
        return externalButton;
    }

    public void setExternalButton(ExternalButton externalButton) {
        this.externalButton = externalButton;
    }
}
class ElevatorManager
{

    List<ElevatorCar> elevatorCars;
    ElevatorSelectionStrategy strategy;
    ElevatorManager(int numOfElevators,int capacity,ElevatorSelectionStrategy strategy)
    { elevatorCars=new ArrayList<ElevatorCar>();
        for(int i=0;i<numOfElevators;i++)
        {
            this.strategy=strategy;
            ElevatorCar ec=new ElevatorCar(i+1,capacity);
            elevatorCars.add(ec);
            new Thread(ec::run).start();
        }
    }


    public void addElevator(int id,int capacity)
    {
        elevatorCars.add(new ElevatorCar(id,capacity));
    }

    public void removeElevator(int id)
    {
        elevatorCars.remove(id);
    }

    public void processRequest(int fromFloor,int toFloor) {
        ElevatorCar ec1=strategy.selectElevator(elevatorCars,fromFloor,toFloor);
        //In External Button PressButton is called we must stop at that floor
        Request request=new Request(fromFloor,toFloor);
        ec1.addRequest(request);

    }
}


class ElevatorCar
{
    int id;
    int capacity;
    Direction direction;
    Display display;
    InternalButton internalButton;
    List<Request> Requests;
    int curFloor;

    public ElevatorCar(int id,int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.direction = Direction.UP;
        this.display = new Display(Direction.UP, 0);
        this.internalButton = new InternalButton();
        this.Requests = new ArrayList<Request>();
        this.curFloor = 1;
    }

    public synchronized void   addRequest(Request request) {
        System.out.println("Request "+request.fromFloor+" "+request.toFloor);
        while (Requests.size() == capacity) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Requests.add(request);
        notifyAll();
    }

    public synchronized Request getNextRequest() {
        while (Requests.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return Requests.remove(0);
    }

    public synchronized void processRequest() {
        while (true)
        {
            while(Requests.size()!=0)
            {
                Request request=getNextRequest();
                processRequests(request);

            }
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     public void processRequests(Request request) {
         System.out.println("Processing request from "+request.fromFloor+" to "+request.toFloor+"Elevator "+id);
        int fromFloor=curFloor;
        int toFloor=request.toFloor;

        if(fromFloor<toFloor)
        {
            direction=Direction.UP;
            for(int i=fromFloor;i<=toFloor;i++)
            {
                curFloor=i;
                display.setDisplay(direction,curFloor);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            direction=Direction.DOWN;
            for(int i=fromFloor;i>=toFloor;i--)
            {
                curFloor=i;
                display.setDisplay(direction,curFloor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void run()
    {
        processRequest();
    }

}

interface ElevatorSelectionStrategy {
    ElevatorCar selectElevator(List<ElevatorCar> elevators, int fromFloor, int toFloor);
}

class nearestElevator implements ElevatorSelectionStrategy {
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int fromFloor, int toFloor) {
        ElevatorCar ec1=null;

        int minDistance=Integer.MAX_VALUE;
        for(ElevatorCar ec: elevators)
        {
            int distance=Math.abs(ec.curFloor-fromFloor);
            if(distance<minDistance)
            {
                minDistance=distance;
                ec1=ec;
            }
        }
        //In External Button PressButton is called we must stop at that floor
       return  ec1;

    }
}

class OddElevatorSelectionStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int fromFloor, int toFloor) {
        ElevatorCar ec1=null;
        for(ElevatorCar ec: elevators)
        {
            if((ec.id%2==1 && fromFloor%2==1) || (ec.id%2==0 && fromFloor%2==0))
            {
                ec1=ec;
                break;
            }
        }
        if(ec1==null)
        {
            ec1=elevators.get(0);
        }
        return ec1;
    }
}

class MinSeekElevatorSelectionStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int fromFloor, int toFloor) {
        ElevatorCar ec1 = null;
        int miRequest = Integer.MAX_VALUE;

        for (ElevatorCar ec : elevators) {
            int cuRequest = ec.Requests.size();
            if (cuRequest < miRequest) {
                miRequest = cuRequest;
                ec1 = ec;
            }
        }
        if (ec1 == null) {
            ec1 = elevators.get(0);
        }
        return ec1;
    }
}
        //In External Button PressButton is called we must stop at that floor
