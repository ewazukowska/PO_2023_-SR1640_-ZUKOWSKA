package agh.ics.oop.model;

public class Animal implements WorldElement{
    private MapDirection orientation= MapDirection.NORTH;
    private Vector2d position;

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
    }
    public Vector2d getPosition() {
        return position;
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

    public void move(MoveDirection direction, MoveValidator validator) {
        orientation = switch (direction) {
            case RIGHT -> orientation.next();
            case LEFT -> orientation.previous();
            case FORWARD, BACKWARD -> orientation;
        };

        Vector2d newPosition = switch (direction) {
            case FORWARD -> position.add(orientation.toUnitVector());
            case BACKWARD -> position.subtract(orientation.toUnitVector());
            case LEFT, RIGHT -> position;
        };

        if(validator.canMoveTo(newPosition)){
            this.position = newPosition;
        }
    }

}


