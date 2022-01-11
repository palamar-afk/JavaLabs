package test1.com.company;

import java.util.*;
import java.util.function.IntPredicate;

public class Main {

    private static final int spamNumber = 9;
    private int a = 5;
    public static void main(String[] args)
    {
        int[] arr = new int[]{5,3,2,0,1,4,4,7,12,3};
        FindUniqueNumber(BuildBigArray());
        System.out.println(Arrays.toString(mySort(arr, x -> x % 2 != 0 || x == 0)));
    }

    private static int[] BuildBigArray() {
        Random random = new Random();
        int sizeOfArray = random.nextInt(10, 10000);
        int uniqueNumber =  random.nextInt(0, sizeOfArray);

        int[] arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++)
        {
            if(i == uniqueNumber)
                arr[i] = random.nextInt(0, sizeOfArray);
            else
                arr[i] = spamNumber;
        }

        return arr;
    }

    private static void FindUniqueNumber(int[] arr)
    {
        Integer[] newArray = new Integer[arr.length];
        int i = 0;
        for (int value : arr) {
            newArray[i++] = Integer.valueOf(value);
        }
        Set<Integer> uniqKeys = new TreeSet<>();
        uniqKeys.addAll(Arrays.asList(newArray));
        for (Integer x: uniqKeys)
        {
            if(x.intValue() != spamNumber)
                ShowUniqueNumber(x.intValue());
        }
    }

    private static void ShowUniqueNumber(int number){
        System.out.println("The unique number is " + number);
    }

    private static int[] mySort(int[] arr, IntPredicate filterRule){
        int[] tempArray =
                Arrays.stream(arr)
                        .filter(filterRule)
                        .toArray();
        Arrays.sort(tempArray);

        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 != 0 || arr[i] == 0)
            {
                arr[i] = tempArray[j++];
            }
        }

        return arr;
    }
}