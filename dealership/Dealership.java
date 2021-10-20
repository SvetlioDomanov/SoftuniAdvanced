package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add (Car car){
        if(this.data.size()<capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        for (Car car:this.data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar(){
        if(!data.isEmpty()){
            Car latestCar = data.get(0);
            for (Car car:this.data) {
                if(car.getYear()> latestCar.getYear()){
                    latestCar=car;
                }
            }
            return latestCar;
        }
        else{
            return null;
        }
    }
    public Car getCar(String manufacturer, String model){
        for (Car car:this.data){
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(" The cars are in a car dealership ").append(this.name).append(":\n");
        for (Car car: this.data) {
            sb.append(car).append("\n");
        }
    return sb.toString().trim();
    }

}
