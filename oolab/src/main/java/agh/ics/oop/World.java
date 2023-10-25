package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        MoveDirection[] directions = OptionsParser.parse(args);

        System.out.println("Zwierzak idzie do przodu");

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
    }
}

