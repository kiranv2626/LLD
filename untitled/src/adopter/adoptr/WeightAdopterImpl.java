package adopter.adoptr;

import adopter.adoptee.WeightMachine;

public class WeightAdopterImpl implements WeightAdopter {
    WeightMachine weightMachine;

    public WeightAdopterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg(){
        double pounds = weightMachine.getWeightInPounds();
        double kg = pounds * 0.45359237;
        System.out.println("Weight in kg: " + kg);
        return kg;
    }
}
