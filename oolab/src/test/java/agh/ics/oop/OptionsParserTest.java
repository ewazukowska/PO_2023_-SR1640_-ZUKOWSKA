package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OptionsParserTest {

    @Test
    public void testParse() {
        String[] args = { "f", "b", "r", "l" };
        List<MoveDirection> expectedDirections = Arrays.asList(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        );

        assertEquals(expectedDirections, OptionsParser.parse(args));
    }
}