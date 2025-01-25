package inventory;

import java.util.List;

public class WarehouseController {
    List<WareHouse> warehouses ;
    WareHouseSelectionStartergy wareHouseSelectionStartergy;

    public WarehouseController(List<WareHouse> warehouses, WareHouseSelectionStartergy wareHouseSelectionStartergy) {
        this.warehouses = warehouses;
        this.wareHouseSelectionStartergy = wareHouseSelectionStartergy;
    }

    public WarehouseController() {}

    public void addWareHouse(WareHouse wareHouse) {
        warehouses.add(wareHouse);
    }

    public void removeWareHouse(WareHouse wareHouse) {
        warehouses.remove(wareHouse);
    }

    public List<WareHouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WareHouse> warehouses) {
        this.warehouses = warehouses;
    }

    public WareHouseSelectionStartergy getWareHouseSelectionStartergy() {
        return wareHouseSelectionStartergy;
    }

    public void setWareHouseSelectionStartergy(WareHouseSelectionStartergy wareHouseSelectionStartergy) {
        this.wareHouseSelectionStartergy = wareHouseSelectionStartergy;
    }

    public WareHouse selectWareHouse( WareHouseSelectionStartergy wareHouseSelectionStartergy) {
        this.wareHouseSelectionStartergy=wareHouseSelectionStartergy;
        return wareHouseSelectionStartergy.selectWareHouse(warehouses);
    }

}
