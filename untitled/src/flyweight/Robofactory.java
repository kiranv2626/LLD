package flyweight;

import java.util.HashMap;

public class Robofactory {
    HashMap<String, IRobot> roboMap = new HashMap<String, IRobot>();
    public IRobot createRobot(String type) {
        if(roboMap.containsKey(type)) {
            System.out.println("Fetching " + type + " from cache");
            return roboMap.get(type);
        } else {
            System.out.println("Creating " + type);
            HumanRobot humanRobot = new HumanRobot(type,new Sprites());
            roboMap.put(type, humanRobot);
            return humanRobot;

        }
    }
}
