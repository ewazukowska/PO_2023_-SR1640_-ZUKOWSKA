package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.model.*;

import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationTest {

    String[] args = { "f", "b", "r", "l" };
    List<MoveDirection> directions = OptionsParser.parse(args);
    List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
    RectangularMap worldMap = new RectangularMap(9, 4);
    Animal animal1 = new Animal(new Vector2d(0, 0));
    Animal animal2 = new Animal(new Vector2d(3, 4));

    Simulation simulation = new Simulation(directions, List.of(animal1.getPosition(), animal2.getPosition()), worldMap);
    private final List animals = List.of(animal1.getPosition(), animal2.getPosition());
    //orientacja
    @Test
    public void testOrientation() {
        assertEquals(new Vector2d(0,0), animals.get(0));
        assertEquals(new Vector2d(3,4), animals.get(1));
    }
    /* @Test
    public void testMove() {
        Animal animal = new Animal(new Vector2d(2, 2));

        animal.move(MoveDirection.FORWARD, );
        assertEquals(new Vector2d(2, 3), animal.getPosition());

        // Wykonaj ruch do tyłu
        animal.move(MoveDirection.BACKWARD, ;
        assertEquals(new Vector2d(2, 2), animal.getPosition());
    }

     */

}

