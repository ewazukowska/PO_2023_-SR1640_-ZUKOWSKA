package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation= MapDirection.NORTH;
    private Vector2d position;
    private MoveValidator moveValidator;
    public static final Vector2d BEGINNING = new Vector2d(0, 0);

    public Animal(Vector2d initialPosition) {
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
        return switch (orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = null;
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> newPosition = position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition = position.subtract(orientation.toUnitVector());
            default -> {
            }
        }
        if (moveValidator.canMoveTo(newPosition)) {
            position = newPosition;
        }
    }

}


