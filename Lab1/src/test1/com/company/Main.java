package test1.com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int range = 9;
    private static final int rowSize = 9;
    private static final int columnSize = 9;
    public static void main(String[] args) {
        int[][] mainArray = fillArray(rowSize, columnSize);
        printArray(mainArray);
        printEvenElements(mainArray);

        System.out.println("\n" + Arrays.toString(fillArrayParametrise(0,10,2)));
    }

    private static int[][] fillArray(int rows, int columns)
    {
        int[][] arr = new int[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                arr[i][j]=random.nextInt(range);
            }
        }
        return arr;
    }
    private static int[] fillArrayParametrise(int begin, int end, int step)
    {
        int [] arr = new int[(end-begin)/step + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = begin;
            begin+=step;
        }
        return arr;
    }

    private static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void printEvenElements(int[][] arr)
    {
        System.out.println("\nEven elements of side diagonal:");
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i][arr[i].length-1-i];
            if(elem % 2 == 0 && elem != 0)
            {
                System.out.print(elem + " ");
            }
        }
    }
}
