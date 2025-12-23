package edu.school21;

import java.util.Scanner;

public class SequenceOrderChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean hasAnyNumber = false;
        int prev = 0;

        while (input.hasNext()) {
            if (!input.hasNextInt()) {
                break;
            }

            int current = input.nextInt();

            if (!hasAnyNumber) {
                prev = current;
                hasAnyNumber = true;
            } else {
                if (current < prev) {
                    System.out.println(
                            "The sequence is not ordered from the ordinal number of the number " + current
                    );
                    return;
                }
                prev = current;
            }
        }

        if (!hasAnyNumber) {
            System.out.println("Input error");
        } else {
            System.out.println("The sequence is ordered in ascending order");
        }
    }
}
