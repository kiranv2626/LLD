package bridge;

import java.text.BreakIterator;

public class Dog extends LivingThings{
    public Dog(BreathImplementer breathImplementer) {
        super(breathImplementer);
    }

    @Override
    public void breath() {
        breathImplementer.breath();
    }
}
