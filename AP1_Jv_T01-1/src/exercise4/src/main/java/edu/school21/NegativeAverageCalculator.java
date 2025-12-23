package edu.school21;

import java.util.Scanner;

public class NegativeAverageCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the size of array");
        int number = inputArraySizeCheck(input);
        int[] array = new int[number];
        fillArray(array, input);
        int mean = arithmeticMeanOfNegatives(array);
        if(mean != 0) {
            System.out.println("The Arithmetic Mean is " + mean);
        }
    }

    public static void fillArray(int[] array, Scanner input) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number for array[" + i + "]");

            while (!input.hasNextInt()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            array[i] = input.nextInt();
        }
    }

    public static int arithmeticMeanOfNegatives(int[] array) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
                sum = sum + array[i];
            }
        }
        if (count < 1){
            System.out.println("There are no negative elements");
            return 0;
        }
        return sum / count;
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
