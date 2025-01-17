package adopter.client;

import adopter.adoptee.WeightMachine;
import adopter.adoptee.WeightMachineBabies;
import adopter.adoptr.WeightAdopter;
import adopter.adoptr.WeightAdopterImpl;

public class Main {

    public static void main(String[] args) {
        WeightAdopter weightAdopter = new WeightAdopterImpl(new WeightMachineBabies());
        System.out.println("Weight of Babies: " + weightAdopter.getWeightInKg());
    }
}
