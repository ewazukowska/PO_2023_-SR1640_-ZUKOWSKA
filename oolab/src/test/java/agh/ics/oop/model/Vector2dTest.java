package agh.ics.oop.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Vector2dTest {

    @Test
    void testAdded() {

        //given
        Vector2d vector1 = new Vector2d(3, 5);
        Vector2d vector2 = new Vector2d(4, 1);

        //when
        Vector2d vector3 = vector1.add(vector2);

        //then
        assertEquals(7, vector3.getX());
        assertEquals(6, vector3.getY());
    }
    @Test
    public void testEquals() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(2, 3);

        assertEquals(vector1, vector2);

    }

    @Test
    public void testToString() {
        Vector2d vector = new Vector2d(2, 3);
        assertEquals(vector.toString(), "(2,3)");
    }

    @Test
    public void testPrecedes() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d vector3 = new Vector2d(1, 1);

        assertTrue(vector1.precedes(vector2));
        assertFalse(vector2.precedes(vector1));
        assertFalse(vector1.precedes(vector3));
    }

    @Test
    public void testFollows() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d vector3 = new Vector2d(1, 1);

        assertFalse(vector1.follows(vector2));
        assertTrue(vector2.follows(vector1));
        assertFalse(vector1.follows(vector3));
    }

    @Test
    public void testUpperRight() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d upperRight = vector1.upperRight(vector2);

        assertEquals(upperRight, new Vector2d(4, 4));
    }

    @Test
    public void testLowerLeft() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d lowerLeft = vector1.lowerLeft(vector2);

        assertEquals(lowerLeft, new Vector2d(2, 3));
    }

    @Test
    public void testSubtract() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(4, 4);
        Vector2d difference = vector1.subtract(vector2);

        assertEquals(difference, new Vector2d(-2, -1));
    }

    @Test
    public void testOpposite() {
        Vector2d vector = new Vector2d(2, 3);
        Vector2d opposite = vector.opposite();

        assertEquals(opposite, new Vector2d(-2, -3));
    }
}