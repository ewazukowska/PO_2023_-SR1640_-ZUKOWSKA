package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWorldMapTest {

    @Test
    void testObjectAt() {
        AbstractWorldMap map = new AbstractWorldMap();
        Animal animal = new Animal(new Vector2d(4, 4));
        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        assertEquals(animal, map.objectAt(new Vector2d(4, 4)));  // Sprawdzamy, czy zwierzę jest na mapie
        assertNull(map.objectAt(new Vector2d(3, 3)));  // Sprawdzamy, czy zwracane jest null dla pustego miejsca
    }

    @Test
    void testMove() {
        AbstractWorldMap map = new AbstractWorldMap();
        Animal animal = new Animal(new Vector2d(4, 4));
        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(5, 4), animal.getPosition());  // Sprawdzamy, czy zwierzę zostało przesunięte
    }

    @Test
    void testIsOccupied() {
        AbstractWorldMap map = new AbstractWorldMap();
        Animal animal = new Animal(new Vector2d(4, 4));
        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        assertTrue(map.isOccupied(new Vector2d(4, 4)));  // Miejsce zajęte przez zwierzę
        assertFalse(map.isOccupied(new Vector2d(3, 3)));  // Wolne miejsce
    }

    @Test
    void testGetAnimals() {
        AbstractWorldMap map = new AbstractWorldMap();
        Animal animal = new Animal(new Vector2d(4, 4));
        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        assertEquals(1, map.getAnimals().size());  // Sprawdzamy, czy mamy jedno zwierzę na mapie
        assertTrue(map.getAnimals().contains(animal));
    }
}
