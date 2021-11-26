package Vehicles;

public class Truck extends VehicleImpl{

    private static final double EXTRA_CONSUMPTION =1.6;
    private static final double FUEL_PERCENTAGE =0.95;

    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + EXTRA_CONSUMPTION);
    }

    @Override
    public void refuel(double liters){
        super.refuel(liters*FUEL_PERCENTAGE);
    }
}
