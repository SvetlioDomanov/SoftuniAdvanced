package PizzaCallories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaString = scanner.nextLine().split(" ");
        String pizzaName = pizzaString[1];
        int numberOfToppings = Integer.parseInt(pizzaString[2]);
        try{
            Pizza pizza = new Pizza(pizzaName,numberOfToppings);
            String[] doughString = scanner.nextLine().split(" ");
            String flourType = doughString[1];
            String bakingTechnique = doughString[2];
            double weight = Double.parseDouble(doughString[3]);

                Dough dough = new Dough(flourType,bakingTechnique,weight);

            String input = scanner.nextLine();
            while(!input.equals("END")){
                String[] toppingString = input.split(" ");
                String toppingName = toppingString[1];
                double toppingWeight = Double.parseDouble(toppingString[2]);

                    Topping topping = new Topping(toppingName,toppingWeight);
                    pizza.addTopping(topping);

                input = scanner.nextLine();
            }
        pizza.setDough(dough);
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
