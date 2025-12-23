package edu.school21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringFilter{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of strings");
        int size = readPositiveInt(input);

        List<String> lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lines.add(input.nextLine());
        }

        System.out.println("Enter matching substring");
        String sub = input.nextLine();

        List<String> filtered = filterString(lines, sub);
        printOutput(filtered);
    }

    private static int readPositiveInt(Scanner input) {
        int size;
        do {
            while (!input.hasNextInt()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            size = input.nextInt();
            input.nextLine();
            if (size <= 0) {
                System.out.println("Input error. Size <= 0");
            }
        } while (size <= 0);
        return size;
    }

    private static List<String> filterString(List<String> lines, String sub) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(sub)) {
                result.add(lines.get(i));
            }
        }
        return result;
    }

    private static void printOutput(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(lines.get(i));
        }
    }
}
