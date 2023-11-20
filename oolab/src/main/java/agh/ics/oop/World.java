package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);
/*
        for (MoveDirection direction : directions) {
                switch (direction) {
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                    case LEFT -> System.out.println("Zwierzak idzie w lewo");
                }
        }

        System.out.println("System zakończył działanie");

         Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("Początkowy kierunek: " + MapDirection.NORTH);
        System.out.println("Następny kierunek: " + MapDirection.NORTH.next());
        System.out.println("Poprzedni kierunek: " + MapDirection.NORTH.previous());
        */
        WorldMap map = new RectangularMap(9, 5);

        Animal animal1 = new Animal(new Vector2d(0, 0));
        Animal animal2 = new Animal(new Vector2d(3, 4));
        map.place(animal1);
        map.place(animal2);
        String mapRepresentation = map.toString();
        System.out.println(mapRepresentation);
/*
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
*/
    }
}

