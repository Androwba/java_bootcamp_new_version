package edu.school21;

import java.util.Scanner;

public class FibonacciCalculator {

    private static long[] fibonacciCache;
    private static final int MAX_LONG_INDEX = 92;

    public static void main(String[] args) {
        System.out.println("Enter a non-negative number:");
        Scanner input = new Scanner(System.in);
        int number = inputCheck(input);

        if (number > MAX_LONG_INDEX) {
            System.out.println("Too large n, maximum allowed is " + MAX_LONG_INDEX);
            return;
        }

        fibonacciCache = new long[number + 1];
        displayFibonacci(number);
    }

    public static long fibonacciNumber(int number) {
        if (number <= 1) {
            return number;
        }
        if (fibonacciCache[number] != 0) {
            return fibonacciCache[number];
        }

        long value = fibonacciNumber(number - 1) + fibonacciNumber(number - 2);
        fibonacciCache[number] = value;
        System.out.println("New cache created of size " + (number + 1));

        return value;
    }

    public static int inputCheck(Scanner input) {
        int number;
        do {
            while (!input.hasNextInt()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            number = input.nextInt();
            if (number < 0) {
                System.out.println("Please enter a non-negative number:");
            }
        } while (number < 0);
        return number;
    }

    public static void displayFibonacci(int number) {
        long result = fibonacciNumber(number);
        System.out.println("F(" + number + ") = " + result);
    }
}
