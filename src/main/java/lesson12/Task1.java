package lesson12;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result=reverseWord(scanner.next());
        System.out.print(result);
    }

    public static String reverseWord(String word) {
        StringBuilder reversedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }return reversedWord.toString();
    }
}


