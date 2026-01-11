package edu.school21;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk(){
        double walkTime = getAge() * 0.25;
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
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
