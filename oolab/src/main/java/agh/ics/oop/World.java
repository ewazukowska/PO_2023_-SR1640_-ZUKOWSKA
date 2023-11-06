package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        MoveDirection[] directions = OptionsParser.parse(args);

        for (MoveDirection direction : directions) {
            if (direction != null) {
                switch (direction) {
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                    case LEFT -> System.out.println("Zwierzak idzie w lewo");
                }
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
        System.out.println("Wektor jednostkowy " + MapDirection.NORTH.toUnitVector());

    }
}

