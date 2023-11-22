package agh.ics.oop.model;
import java.util.HashMap;
import java.util.Map;
import static agh.ics.oop.model.Animal.BEGINNING;
public class RectangularMap implements WorldMap {
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();

        if (!canMoveTo(animalPosition) || isOccupied(animalPosition)) {
            return false;
        }
        animals.put(animalPosition, animal);
        return true;

    }
    @Override
    public void move(Animal animal, MoveDirection direction) {

        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);

    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }
    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw( BEGINNING , new Vector2d (width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(BEGINNING) && position.precedes(new Vector2d (width, height)) && !isOccupied(position);
    }
}
