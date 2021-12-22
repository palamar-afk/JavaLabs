package test1.com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Вивести в консоль всі змінні в відсортованому вигляді
        // які починаються з «с» та трансформувати їх в верхній регістр

        List<String> results =
                Arrays.asList("a1", "a2", "b1", "c2", "c1")
                        .stream().filter(str -> (str.startsWith("c"))).map(str -> str.toUpperCase()).sorted().toList();
        System.out.println(String.join("; ", results));

        //Заповнити масив розміром n рандомними значеннями в діапазоні (від 0 до 9) та порахувати середнє арифметичне всіх парних чисел

        int[] arr = new int[10];
        Random random = new Random();
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = random.nextInt(10);
            System.out.print(arr[i]+", ");
        }

        System.out.println("\n\n"+Arrays.stream(arr).filter(x -> x%2 == 0).average().getAsDouble());

        // Данний рядок «rewuvinycgfvwhechgrhwmlsdfwacm» (Просто набір букв в нижньому регістрі),
        // потрібно підняти в верхній регістр всі букви в діапазоні від H до T по алфавіту

        List<String> resultList = Stream.of("rewuvinycgfvwhechgrhwmlsdfwacm".split(""))
                .map(str -> {
                    if(str.matches("[h-t]"))
                        str = str.toUpperCase();
                    return str;
                }).toList();
        System.out.println(String.join("", resultList));
    }
}
