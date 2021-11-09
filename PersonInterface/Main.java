package PersonInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
       for(int i =0; i<n;i++){
           String[] input = scanner.nextLine().split("\\s+");
           String name = input[0];
           int age = Integer.parseInt(input[1]);
            if(input.length==4){
                String id = input[2];
                String birthDate = input[3];
                Person citizen = new Citizen(name, age, id, birthDate);
                people.add(citizen);
            }
            else{
                String group = input[2];
                Person rebel = new Rebel(name, age ,group);
                people.add(rebel);
            }
       }
       int foodBought =0;
        String buyFood = scanner.nextLine();
       while(!buyFood.equals("End")){
           for (Person person: people) {
               if(person.getName().equals(buyFood)){
                   person.buyFood();
               }
           }
           buyFood = scanner.nextLine();
       }
        for (Person person:people) {
            foodBought += person.getFood();
        }
        System.out.println(foodBought);

    }
}
