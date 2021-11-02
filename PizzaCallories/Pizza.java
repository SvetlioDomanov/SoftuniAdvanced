package PizzaCallories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
       this.setToppings(numberOfToppings);
       this.setName(name);
       this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty() || name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if(numberOfToppings<0 || numberOfToppings >10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }
    public void addTopping (Topping topping){
        if(this.toppings.size()<numberOfToppings){
            this.toppings.add(topping);
        }


    }
    public double getOverallCalories(){
        double overallCalories =0;
        overallCalories += this.dough.calculateCalories();
        for (Topping topping: this.toppings) {
            overallCalories +=topping.calculateCalories();
        }
        return overallCalories;
    }

}
