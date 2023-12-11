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

         assertTrue(grassField.canMoveTo(new Vector2d(2, 3)));  // Wolne miejsce
         Animal animal = new Animal(new Vector2d(3, 4));
        try {
            grassField.place(animal);

        } catch (PositionAlreadyOccupiedException e) {
            e.printStackTrace();
        }
         assertFalse(grassField.canMoveTo(new Vector2d(3, 4))); //Zajęte


        // Sprawdzamy, czy metoda objectAt zwraca trawę
        Vector2d grassPosition = grassField.getGrass().get(0).getPosition();
        assertEquals(grassField.getGrass().get(0), grassField.objectAt(grassPosition));

        // Sprawdzamy metodę toString
        assertNotNull(grassField.toString()); //nie chcemy pustego napisu

    }
}