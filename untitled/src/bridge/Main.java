package bridge;

public class Main {
    public static void main(String[] args) {
        LivingThings livingThings = new Dog(new LandBreath());
        livingThings.breath();
        LivingThings livingThings1 = new Fish(new WaterBreath());
        livingThings1.breath();
    }
}
