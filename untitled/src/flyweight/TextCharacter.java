package flyweight;

public class TextCharacter implements ILetter {
    private Character character;
    private String type;
    private int size;

    public TextCharacter(Character character, String type, int size) {
        this.character = character;
        this.type = type;
        this.size = size;
    }

    public Character getCharacter() {
        return character;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying " + character + " at " + x + ", " + y);
    }
}
