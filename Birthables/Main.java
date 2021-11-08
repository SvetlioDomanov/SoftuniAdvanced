package PersonInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();
        while(!input.equals("End")){
        String[] inputArray = input.split("\\s+");
        String type = inputArray[0];
        switch (type){
            case "Citizen":
                String citizenName = inputArray[1];
                int age = Integer.parseInt(inputArray[2]);
                String id = inputArray[3];
                String citizenBirthDate = inputArray[4];
                Citizen citizen = new Citizen(citizenName,age,id,citizenBirthDate);
                birthables.add(citizen);
                break;
            case "Pet":
                String petName = inputArray[1];
                String petBirthDate = inputArray[2];
                Pet pet = new Pet(petName,petBirthDate);
                birthables.add(pet);
                break;
        }
            input = scanner.nextLine();
        }
        String birthDay = scanner.nextLine();
        for (Birthable birthable: birthables) {
            if(birthable.getBirthDate().contains(birthDay)){
                System.out.println(birthable.getBirthDate());
            }
        }

    }
}
