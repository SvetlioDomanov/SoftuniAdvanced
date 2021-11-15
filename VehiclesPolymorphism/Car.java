package Vehicles;

public class Car extends VehicleImpl{

    private static final double EXTRA_CONSUMPTION =0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + EXTRA_CONSUMPTION);
    }
}
