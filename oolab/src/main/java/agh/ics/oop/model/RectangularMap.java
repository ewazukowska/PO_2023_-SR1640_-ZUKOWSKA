package agh.ics.oop.model;
import java.util.HashMap;
import java.util.Map;
import static agh.ics.oop.model.Animal.BEGINNING;
public class RectangularMap implements WorldMap {
    Map<Vector2d, Animal> animals = new HashMap<>();
    private int width;
    private int height;
    Vector2d lowerLeft = BEGINNING;
    Vector2d upperRight = new Vector2d (width - 1, height -1);



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

        animal.move(direction);


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
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(lowerLeft , upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight);
    }
}
