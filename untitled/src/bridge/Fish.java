package bridge;

import java.text.BreakIterator;

public class Fish extends LivingThings{
    public Fish(BreathImplementer breathImplementer) {
        super(breathImplementer);
    }

    @Override
    public void breath() {
        breathImplementer.breath();
    }
}
