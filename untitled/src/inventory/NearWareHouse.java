package inventory;

import java.util.List;

public class NearWareHouse implements WareHouseSelectionStartergy {
    @Override
    public WareHouse selectWareHouse(List<WareHouse> warehouses) {
        return warehouses.get(0);
    }
}
