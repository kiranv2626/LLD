package flyweight;

public class Main {
    public static void main(String[] args) {
        Robofactory robofactory = new Robofactory();
        IRobot robot = robofactory.createRobot("Human");
        robot.display(1,2);
        IRobot robot1 = robofactory.createRobot("Human");
        robot1.display(4,5);
        IRobot robot2 = robofactory.createRobot("Dog");
        robot2.display(6,7);
        IRobot robot3 = robofactory.createRobot("Dog");
        robot3.display(8,9);

    }
}
