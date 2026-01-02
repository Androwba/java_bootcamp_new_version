package edu.school21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        System.out.println("Enter number of pets");
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
            double weight = readDouble(input);
            if (weight <= 0) {
                System.out.println("Incorrect input. Mass <= 0");
                continue;
            }
            pets.add(isCat ? new Cat(name, age, weight) : new Dog(name, age, weight));
        }
        for(Animal output: pets){
            System.out.println(output);
        }
    }

    private static int readInt(Scanner input){
        while(!input.hasNextInt()){
            System.out.println("Could not parse a number. Please, try again");
            input.nextLine();
        }
        int count = input.nextInt();
        input.nextLine();
        return count;
    }

    private static double readDouble(Scanner input){
        while(!input.hasNextDouble()){
            System.out.println("Could not parse a number. Please, try again");
            input.nextLine();
        }
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }
}
