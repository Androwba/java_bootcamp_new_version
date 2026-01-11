package edu.school21;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk(){
        double walkTime = getAge() * 0.5;
        long milliseconds = (long) (walkTime * 1000);
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return walkTime;
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
