package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    private final Vector2d beginning = new Vector2d(0, 0);
    private final Vector2d end = new Vector2d(4, 4);

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
    }
    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    @Override
    public String toString() {
        return String.format("Animal at %s is facing %s", position, orientation);
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
        }
        if (position.precedes(end) && position.precedes(beginning) && direction == MoveDirection.FORWARD) {
            if (direction == MoveDirection.FORWARD) {
                position = position.add(orientation.toUnitVector());
            }
            if (direction == MoveDirection.BACKWARD) {
                position = position.subtract(orientation.toUnitVector());
            }

        }
    }

    }


