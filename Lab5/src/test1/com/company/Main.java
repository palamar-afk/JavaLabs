package test1.com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String mainString = "";

    public static void main(String[] args) {

        Calculate();
        FillArrayFromMiddle(15);
        Run();
    }

    private static void Calculate()
    {
        System.out.println("Enter an expression: ");
        String expression = new Scanner(System.in).nextLine();

        String[] nums = expression.split("[+\\-*/]");
        String[] operations = expression.split("\\d");
        operations = Arrays.copyOfRange(operations, 1, operations.length);

        double res = Double.parseDouble(nums[0]);
        for (int i = 0; i < operations.length; i++) {
            res = Operate(operations[i], res, Double.parseDouble(nums[i+1]));
        }
        System.out.println("Result is " + res);
    }

    private static void FillArrayFromMiddle(int size)
    {
        if(size <= 0 )
            return;
        int[] arr = new int[size];

        int middle= size/2;
        for (int i=middle; i>=0; i--)
        {
            arr[i] = middle-i;
        }
        for(int i=middle+1; i<arr.length; i++)
        {
            arr[i] = i-middle;
        }

        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+", ");
        }
    }

    private static double Operate(String symbol, double firstNum, double secondNum){
        switch (symbol) {
            case "+":
            {
                return firstNum + secondNum;
            }
            case "-":
            {
                return firstNum - secondNum;
            }
            case "*":
            {
                return firstNum * secondNum;
            }
            case "/":
            {
                return firstNum / secondNum;
            }
            default: return 0;
        }
    }

    public static void Run() {
        while (true) {
            System.out.println("1. Create new value");
            System.out.println("2. Display database");
            System.out.println("3. End program");
            System.out.println("Enter the code of operation: ");
            switch (new Scanner(System.in).next()) {
                case "1": {
                    System.out.println("+Name for adding, -Name for removing: ");
                    String inputString = new Scanner(System.in).nextLine();
                    char operation = inputString.charAt(0);
                    switch (operation) {
                        case '+': {
                            inputString = inputString.substring(inputString.lastIndexOf("+") + 1);
                            mainString += inputString + ", "; break;
                        }
                        case '-': {
                            inputString = inputString.substring(inputString.lastIndexOf("-") + 1);
                            if (!mainString.contains(inputString)) {
                                System.out.println("Name is not found.");
                                break;
                            }

                            mainString = mainString.replace(inputString + ",", "");
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println(mainString);
                }
                ;
                case "3":
                    return;
                default:
                    System.out.println("Command is not found.");
            }
        }
    }
}
