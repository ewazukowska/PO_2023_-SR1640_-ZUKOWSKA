package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Animal;

import java.util.List;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);

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

        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 4));

        //System.out.println(animal1);
        //System.out.println(animal2);
        //animal2.move(MoveDirection.FORWARD);
        //System.out.println(animal2);

        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

    }
}

