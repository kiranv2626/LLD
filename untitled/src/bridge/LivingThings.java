package bridge;

public abstract class LivingThings {
    BreathImplementer breathImplementer;
    LivingThings(BreathImplementer breathImplementer){
        this.breathImplementer = breathImplementer;
    }
    public abstract void breath();
}
