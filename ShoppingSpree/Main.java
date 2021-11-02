package ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Person> peopleInfo = new LinkedHashMap<>();
        Map<String, Product> productsInfo = new HashMap<>();

        String[] people = scanner.nextLine().split(";");
        for (String element : people) {
            String[] personData = element.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                peopleInfo.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = scanner.nextLine().split(";");
        for (String element : products) {
            String[] productData = element.split("=");
            String name = productData[0];
            double price = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(name, price);
                productsInfo.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] inputArray = input.split("\\s+");
            String personName = inputArray[0];
            String productName = inputArray[1];
            Person person = peopleInfo.get(personName);
            Product product = productsInfo.get(productName);
            try {
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
        for (Person person : peopleInfo.values()) {
            System.out.print(person.getName() + " - ");
            if(person.getProducts().isEmpty()){
                System.out.println("Nothing bought");
            }
            else{
                System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }

        }

    }
}
