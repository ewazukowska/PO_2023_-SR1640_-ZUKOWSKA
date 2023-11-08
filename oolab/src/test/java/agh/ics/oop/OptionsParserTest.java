package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;


public class OptionsParserTest {
    @Test
    public void testParse() {
        String[] args = { "f", "b", "r", "l" };
        MoveDirection[] expectedDirections = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        };

        assertArrayEquals(expectedDirections, OptionsParser.parse(args));
    }
}