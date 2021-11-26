package Vehicles;

import java.text.DecimalFormat;

public class VehicleImpl implements Vehicle {

    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumption;

    protected VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance){
        String vehicleName = this.getClass().getSimpleName();
        double fuelNeeded = distance*this.getFuelConsumption();
        if(fuelNeeded>this.fuelQuantity){
            return vehicleName + " needs refueling";
        }
        setFuelQuantity(this.getFuelQuantity()-fuelNeeded);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",vehicleName, decimalFormat.format(distance));
    }

    @Override
    public void refuel(double liters) {
        if(liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double newFuelQuantity = this.fuelQuantity + liters;
        if(newFuelQuantity>this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.getFuelQuantity());
    }
}
