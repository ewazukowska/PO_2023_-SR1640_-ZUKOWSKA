package agh.ics.oop.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TextMapTest {
    @Test
    void testPlace() {
        TextMap textMap = new TextMap();
        assertTrue(textMap.place("Ala"));
    }

    @Test
    void testChangePlace() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("niedźwiedź");
        textMap.place("kapibara");

        assertEquals("[Ala, niedźwiedź, kapibara]", textMap.toString());

        textMap.move("niedźwiedź", MoveDirection.FORWARD);
        assertEquals("[Ala, kapibara, niedźwiedź]", textMap.toString());

        textMap.move("kapibara", MoveDirection.BACKWARD);
        assertEquals("[kapibara, Ala, niedźwiedź]", textMap.toString());

        textMap.move("niedźwiedź", MoveDirection.LEFT);
        assertEquals("[kapibara, Ala, niedźwiedź]", textMap.toString());

        textMap.move("niedźwiedź", MoveDirection.RIGHT);
        assertEquals("[kapibara, Ala, niedźwiedź]", textMap.toString());

    }

    @Test
    void testIsOccupied() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");

        assertTrue(textMap.isOccupied(0));
        assertFalse(textMap.isOccupied(1));
        assertFalse(textMap.isOccupied(-1));
    }

    @Test
    void testObjectAt() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");

        assertEquals("Ala", textMap.objectAt(0));
        assertNull(textMap.objectAt(1));
    }
}
