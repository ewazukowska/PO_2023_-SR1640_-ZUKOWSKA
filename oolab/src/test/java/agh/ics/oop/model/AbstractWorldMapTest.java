package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractWorldMapTest {

    @Test
    public void testAbstractWorldMap() {
        AbstractWorldMap worldMap = new AbstractWorldMap();
        Vector2d beginning = new Vector2d(2, 2);
        Vector2d end = new Vector2d(5, 5);
        worldMap.beginning = beginning;
        worldMap.end = end;
        Animal animal = new Animal(new Vector2d(4, 4));

        //place - umieszczamy zwierzę na mapie
        assertTrue(worldMap.place(animal));  // Powinno się udać, bo wolne miejsce i w mapie

        // Sprawdzamy metodę canMoveTo
        assertTrue(worldMap.canMoveTo(new Vector2d(3, 3)));  // Wolne miejsce
        assertFalse(worldMap.canMoveTo(new Vector2d(6, 6)));  // Poza mapą
        assertFalse(worldMap.canMoveTo(new Vector2d(4, 4)));  // Zajęte


        // Sprawdzamy objectAt, czy zwierzę faktycznie jest na mapie?
        assertEquals(animal, worldMap.objectAt(new Vector2d(4, 4)));

        // Sprawdzamy metodę move
        worldMap.move(animal, MoveDirection.FORWARD);  //przesunęliśmy zwierze do góry
        assertEquals(new Vector2d(5, 4), animal.getPosition());


        // Sprawdzamy isOccupied
        assertTrue(worldMap.isOccupied(new Vector2d(5, 4)));  // Miejsce zajęte przez zwierzę
        assertFalse(worldMap.isOccupied(new Vector2d(3, 3)));  // Wolne miejsce

        // Sprawdzamy, czy metoda toString nie zwraca pustego napisu
        assertNotNull(worldMap.toString());

        // Sprawdzamy getAnimals
        assertEquals(1, worldMap.getAnimals().size()); //mamy na razei jedno zwierzę
        assertTrue(worldMap.getAnimals().contains(animal));

    }
}