package edu.school21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NameFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size");
        int size = readPositiveInt(input);
        List<User> users = new ArrayList<>();
        while (users.size() < size) {
            System.out.println("Enter name");
            String name = input.nextLine();
            System.out.println("Enter age");
            Integer age = readAge(input);
            if (age == null) {
                continue;
            }
            users.add(new User(name, age));
        }
        List<User> legalAge = users.stream().filter(user -> user.getAge() >= 18).toList();
        String result = legalAge.stream().map(User::getName).collect(Collectors.joining(", "));
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }

    private static int readPositiveInt(Scanner input) {
        int value;
        do {
            while (!input.hasNextInt()) {
                System.out.println("Could not parse a number. Please try again");
                input.next();
            }
            value = input.nextInt();
            input.nextLine();
        } while (value <= 0);
        return value;
    }

    private static Integer readAge(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Could not parse a number. Please try again");
            input.next();
        }
        int age = input.nextInt();
        input.nextLine();
        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return null;
        }
        return age;
    }
}
