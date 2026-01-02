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
            String animalType = input.nextLine().trim().toLowerCase();
            switch (animalType) {
                case "cat":
                case "dog":
                case "hamster":
                case "guinea":
                    String name = input.nextLine();
                    int age = readInt(input);
                    if (age <= 0) {
                        System.out.println("Incorrect input. Age <= 0");
                        break;
                    }
                    Animal pet = createPet(animalType, name, age);
                    if (pet != null) pets.add(pet);
                    break;
                default:
                    System.out.println("Incorrect input. Unsupported pet type");
            }
        }
        printByType(pets, Herbivore.class);
        printByType(pets, Omnivore.class);
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

    private static void printByType(List<Animal> pets, Class<?> type) {
        for (Animal pet : pets) {
            if (type.isInstance(pet)) {
                System.out.println(pet);
            }
        }
    }

    private static Animal createPet(String type, String name, int age) {
        switch (type) {
            case "cat":
                return new Cat(name, age);
            case "dog":
                return new Dog(name, age);
            case "hamster":
                return new Hamster(name, age);
            case "guinea":
                return new GuineaPig(name, age);
            default:
                return null;
        }
    }
}
