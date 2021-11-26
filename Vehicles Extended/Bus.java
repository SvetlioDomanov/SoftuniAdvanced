package Vehicles;

public class Bus extends VehicleImpl{

    private static final double EXTRA_CONSUMPTION = 1.4;
    private boolean isEmpty;


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = false;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if(!this.isEmpty){
            super.setFuelConsumption(fuelConsumption + EXTRA_CONSUMPTION);
        }
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
