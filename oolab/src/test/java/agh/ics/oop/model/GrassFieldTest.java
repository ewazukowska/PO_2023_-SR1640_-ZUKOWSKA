package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testGrassField() {

        GrassField grassField = new GrassField(10);

        // Sprawdzamy czy faktycznie mamy 10 traw
        assertEquals(10, grassField.getGrass().size());


        // Sprawdzamy metode canMoveTo
        //assertTrue(worldMap.canMoveTo(new Vector2d(2, 3)));  // Wolne miejsce
        Animal animal2 = new Animal(new Vector2d(3, 4));
        grassField.place(animal2);
        assertFalse(grassField.canMoveTo(new Vector2d(3, 4))); //Zajęte


        // Sprawdzamy, czy metoda objectAt zwraca trawę
        Vector2d grassPosition = grassField.getGrass().get(0).getPosition();
        assertEquals(grassField.getGrass().get(0), grassField.objectAt(grassPosition));

        // Sprawdzamy metodę toString
        assertNotNull(grassField.toString()); //nie chcemy pustego napisu

    }
}