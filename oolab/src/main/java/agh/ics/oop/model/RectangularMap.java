package agh.ics.oop.model;
import java.util.HashMap;
import java.util.Map;
import static agh.ics.oop.model.Animal.BEGINNING;
public class RectangularMap<T, P> implements WorldMap<T, P> {
    private final Map<T, P> objects = new HashMap<>();
    private int width;
    private int height;
    Vector2d lowerLeft = BEGINNING;
    Vector2d upperRight = new Vector2d (width - 1, height -1);



    public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
    }
    public Vector2d getObjectPosition(T object) {
        for (Map.Entry<T, P> entry : objects.entrySet()) {
            if (entry.getValue().equals(object)) {
                return (Vector2d) entry.getKey();
            }
    }
        return null;
    }
    @Override
    public boolean place(T object) {
        Vector2d objectPosition = (Vector2d) getObjectPosition(object);

        if (!canMoveTo((Vector2d) objectPosition) || isOccupied((P) objectPosition)) {
            return false;
        }
        objects.put(object, (P) objectPosition);
        return true;

    }

    @Override
    public void move(T object, MoveDirection direction) {
        if (object instanceof Animal) {
            Animal animal = (Animal) object;
            animal.move(direction);
            }
        }
    @Override
    public boolean isOccupied(P position) {
        return objects.containsKey(position);
    }
    @Override
    public Object objectAt(P position) {
        return objects.get(position);
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
