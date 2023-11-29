package agh.ics.oop.model;

import java.util.*;

public class AbstractWorldMap implements WorldMap {

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Vector2d beginning;
    protected Vector2d end;

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (canMoveTo(animalPosition)) {
            animals.put(animalPosition, animal);
            return true;
        }
        return false;
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            Vector2d oldPosition = animal.getPosition();
            MoveValidator validator = this;
            animal.move(direction, validator);
            Vector2d newPosition = animal.getPosition();
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }


    @Override
    public Collection<WorldElement> getElements() {
        List<WorldElement> elements = new ArrayList<>(animals.values());
        return elements;
    }


}
