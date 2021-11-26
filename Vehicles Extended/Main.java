package Vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split("\\s+");
        Vehicle car = getVehicle(inputArray);

        inputArray = scanner.nextLine().split("\\s+");
        Vehicle truck = getVehicle(inputArray);

        inputArray = scanner.nextLine().split("\\s+");
        Vehicle bus = getVehicle(inputArray);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck",truck);
        vehicles.put("Bus",bus);

        int n = Integer.parseInt(scanner.nextLine());
        for(int i =0;i<n;i++) {
            inputArray = scanner.nextLine().split("\\s+");
            String commandName = inputArray[0];
            String vehicleType = inputArray[1];
            Vehicle vehicle = vehicles.get(vehicleType);
            try{
                switch (commandName) {
                    case "Drive":
                        double distance = Double.parseDouble(inputArray[2]);
                        if(vehicle instanceof Bus){
                            ((Bus) vehicle).setEmpty(false);
                        }
                        System.out.println(vehicle.drive(distance));
                        break;
                    case "Refuel":
                        double fuelAmount = Double.parseDouble(inputArray[2]);
                        vehicles.get(vehicleType).refuel(fuelAmount);
                        break;
                    case "DriveEmpty":
                        double driveEmptyBusDistance = Double.parseDouble(inputArray[2]);
                        if(vehicle instanceof Bus){
                            ((Bus) vehicle).setEmpty(true);
                        }
                        System.out.println(vehicle.drive(driveEmptyBusDistance));
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
        vehicles.values().forEach(System.out::println);

    }

    private static Vehicle getVehicle(String[] inputArray) {
        String vehicleType = inputArray[0];
        double fuelAmount = Double.parseDouble(inputArray[1]);
        double consumption = Double.parseDouble(inputArray[2]);
        double tankCapacity = Double.parseDouble(inputArray[3]);
        Vehicle vehicle = null;
        switch (vehicleType){
            case "Car":
                vehicle = new Car(fuelAmount,consumption,tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelAmount,consumption,tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelAmount,consumption,tankCapacity);
                break;

        }
        return vehicle;
    }

}
