package BlackBoxIntegers;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();

        while(!input.equals("END")){
            String[] commandParts = input.split("_");
            String methodName = commandParts[0];
            int value = Integer.parseInt(commandParts[1]);

            Method method = clazz.getDeclaredMethod(methodName,int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt,value);
            System.out.println(innerValue.get(blackBoxInt));

            input=scanner.nextLine();
        }



    }
}
