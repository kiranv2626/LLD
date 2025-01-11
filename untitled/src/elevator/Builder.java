package elevator;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    List<Floor> floors = new ArrayList<Floor>();
    Builder(List<Floor> floors){this.floors=floors;}
    void addFloor(Floor floor){floors.add(floor);}
    void removeFloor(Floor floor){floors.remove(floor);}
    List<Floor> getFloorsList()
    {
        return floors;
    }//List<Floor
    // >)
}
