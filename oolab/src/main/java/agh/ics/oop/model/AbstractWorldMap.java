package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractWorldMap implements WorldMap {

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, Grass> grass = new HashMap<>();
    protected Vector2d BEGINNING;
    protected Vector2d END;

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(BEGINNING) && position.precedes(END) && !isOccupied(position);
    }


    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (canMoveTo(animalPosition) && !isOccupied(animalPosition)) {
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
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grass.containsKey(position) ;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(BEGINNING, END);
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }
    public List<Grass> getGrass() {
        return new ArrayList<>(grass.values());
    }
}
