package agh.ics.oop.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextMap implements WorldMap<String, Integer> {
    private final List<String> texts;
    private final int size;

    public TextMap() {
        this.texts = new ArrayList<>();
        this.size = 0;
    }

    public boolean place(String text) {
        return texts.add(text);
    }

    @Override
    public void move(String text, MoveDirection direction) {
        int index = texts.indexOf(text);

        if (index == -1) {
            return;
        }

        if (direction == MoveDirection.FORWARD && index < texts.size() - 1) {
            Collections.swap(texts, index, index + 1);
        } else if (direction == MoveDirection.BACKWARD && index > 0) {
            Collections.swap(texts, index, index - 1);
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position >= 0 && position < texts.size();
    }

    @Override
    public String objectAt(Integer position) {
        if (isOccupied(position)) {
            return texts.get(position);
        }
        return null;
    }

    @Override
    public String toString() {
        return texts.toString();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
    }
}
