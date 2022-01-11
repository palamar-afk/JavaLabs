package test1.com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] {"Please","be","careful"};
        System.out.println(String.join(" ", ReverseArray(array)));

        System.out.println(Arrays.toString(MultiplyNumberXTimes(4,7)));

        System.out.println(HasNoLettersSuch("Java is very interesting programming language", new String[]{"@"}));

        System.out.println(FindTheLongestWord("The most loooooooooongest word!!!!"));
    }

    public static String[] ReverseArray(String[] separateWords)
    {
        int[] sizesOfSeparateWords = new int[separateWords.length];
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < sizesOfSeparateWords.length; i++)
        {
            sizesOfSeparateWords[i] = separateWords[i].length();
            sentence.append(separateWords[i]);
        }
        String[] resultWords = new String[separateWords.length];

        int start = 0;
        String reversedSentence = sentence.reverse().toString();
        for (int i = 0; i < separateWords.length; i++)
        {
            resultWords[i] = reversedSentence.substring(start, start + sizesOfSeparateWords[i]);
            start+=sizesOfSeparateWords[i];
        }

        return resultWords;
    }

    public static int[] MultiplyNumberXTimes(int x, int n){
        int[] multipleNumbers = new int[x];

        for (int i = 1; i < x+1; i++) {
            multipleNumbers[i-1] = n * i;
        }
        return multipleNumbers;
    }

    public static boolean HasNoLettersSuch(String phrase, String[] blackWordsList){
        for(int i=0; i<blackWordsList.length; i++)
        {
            if(phrase.contains(blackWordsList[i]))
                return false;
        }
        return true;
    }

    public static String FindTheLongestWord(String phrase){
        String[] words = phrase.split(" ");
        int indexOfTheLongestWord = 0;
        int maxLength = 0;
        for(int i=0; i<words.length; i++)
        {
            if(words[i].length() > maxLength)
            {
                maxLength = words[i].length();
                indexOfTheLongestWord = i;
            }
        }
        return words[indexOfTheLongestWord];
    }
}
