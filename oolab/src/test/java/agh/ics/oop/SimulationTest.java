package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.model.Animal;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;



import java.util.List;

public class SimulationTest {

    String[] args = { "f", "b", "r", "l" };
    List<MoveDirection> directions = OptionsParser.parse(args);
    List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

    Simulation simulation = new Simulation(positions, directions);
    List<Animal> animals = simulation.createAnimals(positions);
    //orientacja
    @Test
    public void testOrientation() {
        assertEquals("Animal at (2,2) is facing Północ", animals.get(0).toString());
        assertEquals("Animal at (3,4) is facing Wschód", animals.get(1).toString());
    }
    @Test
    public void testMove() {
        Animal animal = new Animal(new Vector2d(2, 2));
        // Wykonaj ruch do przodu
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());

        // Wykonaj ruch do tyłu
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 2), animal.getPosition());
    }

}

