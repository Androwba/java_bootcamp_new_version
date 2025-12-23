package edu.school21;

import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the size of array");
        int number = inputArraySizeCheck(input);
        float[] array = new float[number];
        fillArray(array, input);
        selectionSort(array);
        printMatched(array);
    }

    private static void printMatched(float[] sorted) {
        for(int i = 0; i < sorted.length; i++) {
            if(i > 0){
                System.out.print(" ");
            }
            System.out.print(sorted[i]);
        }
        System.out.println();
    }

    public static void fillArray(float[] array, Scanner input) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter number for element[" + i + "]");

            while (!input.hasNextFloat()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            array[i] = input.nextFloat();
        }
    }

    public static void selectionSort(float[] array) {
        for(int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swapValue(array, i, minIndex);
        }
    }

    public static void swapValue (float[] array, int i, int minIndex) {
        float temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
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
