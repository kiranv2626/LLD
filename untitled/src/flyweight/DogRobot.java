package flyweight;

public class DogRobot implements IRobot {
    private String type;
    private Sprites sprites;

    public DogRobot(String type, Sprites sprites) {
        this.type = type;
        this.sprites = sprites;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public String getType() {
        return type;
    }
    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + type + " at " + x + ", " + y);
    }


}
