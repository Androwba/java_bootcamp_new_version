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
            pets.add(isCat ? new Cat(name, age) : new Dog(name, age));
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
}
