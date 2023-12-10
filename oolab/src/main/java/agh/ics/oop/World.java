package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.List;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);
        try {


            for (MoveDirection direction : directions) {
                switch (direction) {
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                    case LEFT -> System.out.println("Zwierzak idzie w lewo");
                }
            }
            Animal animal1 = new Animal(new Vector2d(0, 0));
            Animal animal2 = new Animal(new Vector2d(3, 4));

/*

            RectangularMap map1 = new RectangularMap(9, 4);

            ConsoleMapDisplay observer = new ConsoleMapDisplay();

            map1.addObserver(observer);

            try {
                map1.place(animal1);
                map1.place(animal2);

            } catch (PositionAlreadyOccupiedException e) {
                e.printStackTrace();
            }
            Simulation simulation = new Simulation(directions, map1);

            simulation.run();

            GrassField map2 = new GrassField(10);

            ConsoleMapDisplay observer2 = new ConsoleMapDisplay();
            map2.addObserver(observer2);

            System.out.println(map2.calculateUpperRight());
            System.out.println(map2.calculateLowerLeft());
            System.out.println(map2);

            Simulation simulation2 = new Simulation(directions, map2);


            simulation2.run();
            System.out.println("System zakończył działanie");
*/

    }

        catch (IllegalArgumentException er) {
            er.printStackTrace();
        }


}
}

