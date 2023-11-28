package agh.ics.oop.model;
public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    private static final Vector2d BEGINNING = new Vector2d(0, 0);
    public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
    }
    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(BEGINNING, new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(BEGINNING) && position.precedes(new Vector2d(width, height)) && !isOccupied(position);
    }
}
