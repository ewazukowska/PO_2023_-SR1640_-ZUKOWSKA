package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    RectangularMap map = new RectangularMap(5, 5);
    Animal animal = new Animal(new Vector2d(2, 2));

    @Test
    void canWePlaceAnimalOnMap() {

        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void weShouldNotPlaneAnimal() {

        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 2));
        try {
            map.place(animal1);
            map.place(animal2);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void positionIsOccupied() {
        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        boolean occupied = map.isOccupied(new Vector2d(2, 2));

        assertTrue(occupied);
    }

    @Test
    void positionIsNotOccupied() {

        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }


        boolean occupied = map.isOccupied(new Vector2d(3, 3));


        assertFalse(occupied);
    }

    @Test
    void animalIsAt() {

        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }


        WorldElement foundAnimal = map.objectAt(new Vector2d(2, 2));


        assertEquals(animal, foundAnimal);
    }

    @Test
    void thereIsNoAnimalHere() {

        try {
            map.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }

        WorldElement foundAnimal = map.objectAt(new Vector2d(3, 3));

        assertNull(foundAnimal);
    }

}