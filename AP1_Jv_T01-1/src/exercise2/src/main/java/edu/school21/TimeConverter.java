package edu.school21;

import java.util.Scanner;

public class TimeConverter {
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int HOURS_IN_DAY = 24;
    private static final int SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {
        System.out.println("Enter the number of seconds");
        Scanner input = new Scanner(System.in);

        int seconds = inputValidator(input);
        if (seconds < 0) {
            System.out.println("Incorrect time.");
            return;
        }

        int[] result = calculator(seconds);
        output(result[0], result[1], result[2]);
    }

    public static int inputValidator(Scanner input){
        while (!input.hasNextInt()) {
            System.out.println("Could not parse a number. Please try again");
            input.next();
        }
        return input.nextInt();
    }

    public static void output(int hours, int minutes, int seconds){
        System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static int[] calculator(int seconds){
        int[] values = new int[3];
        values[0] = seconds / SECONDS_IN_HOUR % HOURS_IN_DAY;
        values[1] = (seconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        values[2] = seconds % SECONDS_IN_MINUTE;
        return values;
    }
}
