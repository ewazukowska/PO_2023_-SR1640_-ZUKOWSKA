package agh.ics.oop.model;

import java.util.Collection;
import java.util.List;

public interface WorldElement {
    Vector2d getPosition();

    String toString();

    default Collection<WorldElement> getElements() {
        return List.of(this);
    }
}


