package com.company;

public class Engine {
    private String model;
    private int power;
    //optional
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency ="n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacementPrint;
        if(displacement==0){
            displacementPrint = "n/a";
        }else{
            displacementPrint = displacement + "";
        }
        String stringBuilder = model + ":" + "\n" +
                "Power: " + power + "\n" +
                "Displacement: " + displacementPrint + "\n" +
                "Efficiency: " + efficiency;
        return stringBuilder;
    }
}
