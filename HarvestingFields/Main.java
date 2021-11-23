package HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {

            if (input.equals("all")) {
				for (Field field : fields){
					System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()),
							field.getType().getSimpleName(),
							field.getName());
				}
            }
            else{
                for (Field field : fields) {
                    String modifierName = Modifier.toString(field.getModifiers());
                    if (modifierName.equals(input)) {
                        System.out.printf("%s %s %s\n", modifierName,
                                field.getType().getSimpleName(),
                                field.getName());
                    }
                }
            }


            input = scanner.nextLine();

        }
    }
}
