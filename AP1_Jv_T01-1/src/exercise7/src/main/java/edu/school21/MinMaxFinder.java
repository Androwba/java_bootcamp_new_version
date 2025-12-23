package edu.school21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinMaxFinder{

    public static void main(String[] args) {
        String defaultPath = "src/exercise7/src/main/resources/";
        System.out.println("Enter filename:");
        Scanner input = new Scanner(System.in);

        String fileName = input.nextLine();

        String pathToFile = defaultPath + fileName;

        System.out.println("Reading from file: " + pathToFile);

        Scanner fileScanner = openFileScanner(pathToFile);
        if (fileScanner == null) {
            return;
        }

        int count = inputArraySizeCheck(fileScanner);
        if (count <= 0) {
            return;
        }

        float[] array = new float[count];
        int read = fillArrayFromFile(array, fileScanner);

        if (read < count) {
            System.out.println("Input error. Insufficient number of items");
            return;
        }

        System.out.println(read);
        printMatched(array);

        float min = findMin(array);
        float max = findMax(array);
        System.out.println("Saving min and max values in file");
        saveMinMaxToFile(min, max);

        System.out.println(min + " " + max);
    }

    public static Scanner openFileScanner(String path) {
        try {
            return new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
            return null;
        }
    }

    private static void printMatched(float[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static int fillArrayFromFile(float[] array, Scanner fileScanner) {
        int i = 0;
        while (i < array.length && fileScanner.hasNext()) {
            if (fileScanner.hasNextFloat()) {
                array[i] = fileScanner.nextFloat();
                i++;
            } else {
                fileScanner.next();
            }
        }
        return i;
    }

    public static float findMin(float[] array) {
        float min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static float findMax(float[] array) {
        float max = array[0];
        for (float num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void saveMinMaxToFile(float min, float max) {
        String savedPath = "src/exercise7/src/main/resources/result.txt";
        try (FileWriter writer = new FileWriter(savedPath)) {
            writer.write(min + " " + max);
        } catch (IOException e) {
            System.out.println("Error saving min and max values.");
        }
    }

    public static int inputArraySizeCheck(Scanner fileScanner) {
        int number;
        try {
            number = fileScanner.nextInt();
            if (number <= 0) {
                System.out.println("Input error. Size <= 0");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Input error. Size <= 0");
            return -1;
        }
        return number;
    }
}
