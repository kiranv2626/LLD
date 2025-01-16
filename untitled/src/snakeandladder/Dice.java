package snakeandladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int countofDice;
    int min=1;
    int max=6;
    Dice(int countofDice){
        this.countofDice=countofDice;
    }
    public int roll(){
        int total=0;
        for(int i=0;i<countofDice;i++){
            int r1= ThreadLocalRandom.current().nextInt(min,max+1);
            total+=r1;
        }
        return total;
    }

}
