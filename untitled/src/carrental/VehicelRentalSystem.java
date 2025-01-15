package carrental;

import java.util.ArrayList;
import java.util.List;

public class VehicelRentalSystem {
    List<Store> stores ;
    List<User> users ;
    VehicelRentalSystem(List<Store> stores, List<User> users)
    {
        this.stores=stores;
        this.users=users;
    }

    public List<Store> getStores() {
        return stores;
    }

    public List<User> getUsers() {
        return users;
    }

    public Store getStore(Location location) {
//        for(Store store:stores)
//        {
//            if(store.getLocation().equals(location))
//            {
//                return store;
//            }
//        }
        return stores.get(0);
    }
    void addStore(Store store)
    {
        stores.add(store);
    }
    void addUser(User user)
    {
        users.add(user);
    }
    void removeUser(User user)
    {
        users.remove(user);
    }
    void removeStore(Store store)
    {
        stores.remove(store);
    }
}
