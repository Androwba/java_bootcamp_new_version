package edu.school21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        int number = readInt(input);
        for (int i = 0; i < number; i++) {
            String animalType = input.nextLine().trim();
            boolean isCat = animalType.equalsIgnoreCase("cat");
            boolean isDog = animalType.equalsIgnoreCase("dog");
            if (!isCat && !isDog) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }
            String name = input.nextLine();
            int age = readInt(input);
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }
            pets.add(isCat ? new Cat(name, age) : new Dog(name, age));
        }
        long programStart = System.nanoTime();
        List<Thread> threads = new ArrayList<>();
        for (Animal pet : pets) {
            Thread thread = new Thread(() -> {
                long walkStart = System.nanoTime();
                pet.goToWalk();
                long walkEnd = System.nanoTime();
                double startTimeSec = (walkStart - programStart) / (double) TimeUnit.SECONDS.toNanos(1);
                double endTimeSec   = (walkEnd - programStart) / (double) TimeUnit.SECONDS.toNanos(1);
                System.out.printf(
                        "%s, start time = %.2f, end time = %.2f%n",
                        pet.toString(), startTimeSec, endTimeSec
                );
            });
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Could not parse a number. Please, try again");
            input.nextLine();
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }
}
