package Vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split("\\s+");
        double carFuelAmount = Double.parseDouble(inputArray[1]);
        double carFuelConsumption = Double.parseDouble(inputArray[2]);
        Vehicle car = new Car(carFuelAmount,carFuelConsumption);

        inputArray = scanner.nextLine().split("\\s+");
        double truckFuelAmount = Double.parseDouble(inputArray[1]);
        double truckFuelConsumption = Double.parseDouble(inputArray[2]);
        Vehicle truck = new Truck(truckFuelAmount,truckFuelConsumption);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck",truck);

        int n = Integer.parseInt(scanner.nextLine());
        for(int i =0;i<n;i++) {
            inputArray = scanner.nextLine().split("\\s+");
            String commandName = inputArray[0];
            String vehicleType = inputArray[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(inputArray[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(inputArray[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);

    }

}
