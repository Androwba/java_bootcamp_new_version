package edu.school21;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {
    private final List<Animal> animals;
    private int index;

    public AnimalIterator(List<Animal> animals) {
        this.animals = animals;
        this.index = 0;
    }

    @Override
    public Animal next() {
        Animal current = animals.get(index);
        index++;
        return current;
    }

    @Override
    public boolean hasNext() {
        return index < animals.size();
    }

    @Override
    public void reset() {
        index = 0;
    }
}
