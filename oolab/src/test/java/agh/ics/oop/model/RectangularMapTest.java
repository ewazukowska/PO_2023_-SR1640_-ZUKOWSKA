package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    RectangularMap map = new RectangularMap(5, 5);
    Animal animal = new Animal(new Vector2d(2, 2));

    @Test
    void canWePlaceAnimalOnMap() {

        boolean placed = new RectangularMap(5, 5).place(animal);


        assertTrue(placed);
    }

    @Test
    void weShouldNotPlaneAnimal() {

        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 2));
        map.place(animal1);


        boolean placed = map.place(animal2);


        assertFalse(placed);
    }

    @Test
    void positionIsOccupied() {
        map.place(animal);

        boolean occupied = map.isOccupied(new Vector2d(2, 2));

        assertTrue(occupied);
    }

    @Test
    void positionIsNotOccupied() {

        map.place(animal);


        boolean occupied = map.isOccupied(new Vector2d(3, 3));


        assertFalse(occupied);
    }

    @Test
    void animalIsAt() {

        map.place(animal);


        WorldElement foundAnimal = map.objectAt(new Vector2d(2, 2));


        assertEquals(animal, foundAnimal);
    }

    @Test
    void thereIsNoAnimalHere() {

        map.place(animal);

        WorldElement foundAnimal = map.objectAt(new Vector2d(3, 3));

        assertNull(foundAnimal);
    }
}