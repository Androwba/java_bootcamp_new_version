package edu.school21;

import java.util.Scanner;

public class MatchingDigits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the size of array");
        int number = inputArraySizeCheck(input);
        int[] array = new int[number];
        fillArray(array, input);
        int[] match = findMatchDigits(array);
        if (match.length != 0){
            printMatched(match);
        }
    }

    public static void printMatched(int[] match) {
        int i = 0;
        while(i < match.length) {
            if(i > 0){
                System.out.print(" ");
            }
            System.out.print(match[i]);
            i++;
        }
    }

    public static void fillArray(int[] array, Scanner input) {
        int i = 0;
        while(i < array.length) {
            System.out.println("Enter number for array[" + i + "]");

            while (!input.hasNextInt()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            array[i] = input.nextInt();
            i++;
        }
    }

    public static int[] findMatchDigits(int[] array) {
        int countNewSize = 0;
        int i = 0;
        while (i < array.length) {
            if (hasSameFirstAndLastDigit(array[i])) {
                countNewSize++;
            }
            i++;
        }
        if (countNewSize == 0) {
            System.out.println("There are no such elements");
            return new int[0];
        }
        int[] newSizeOfArray = new int[countNewSize];
        int arrayPosition = 0;
        i = 0;
        while (i < array.length) {
            if (hasSameFirstAndLastDigit(array[i])) {
                newSizeOfArray[arrayPosition] = array[i];
                arrayPosition++;
            }
            i++;
        }
        return newSizeOfArray;
    }

    public static boolean hasSameFirstAndLastDigit(int n) {
        n = Math.abs(n);
        int lastDigit = n % 10;
        while (n >= 10) {
            n /= 10;
        }
        int firstDigit = n;
        return firstDigit == lastDigit;
    }

    public static int inputArraySizeCheck(Scanner input) {
        int number;
        do {
            while (!input.hasNextInt()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            number = input.nextInt();
            if (number <= 0) {
                System.out.println("Input error. Size <= 0");
            }
        } while (number <= 0);
        return number;
    }
}
