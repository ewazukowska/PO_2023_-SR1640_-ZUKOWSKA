package agh.ics.oop.model;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected List<MapChangeListener> observers = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException{
        Vector2d animalPosition = animal.getPosition();
        if (!canMoveTo(animalPosition)) {
            throw new PositionAlreadyOccupiedException(animalPosition);
        }
        animals.put(animalPosition, animal);
        notifyObserver("New animal has been placed at " + animalPosition);
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

            notifyObserver("Animal has moved from " + oldPosition + " to " +newPosition);
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
@Override
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }


    @Override
    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Boundary bounds = getCurrentBounds();
        return visualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }
    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    public void notifyObserver(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }

}
