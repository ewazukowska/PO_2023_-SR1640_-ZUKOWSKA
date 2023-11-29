package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.HashMap;
import java.util.Iterator;
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
        Animal animal1 = new Animal(new Vector2d(0, 0));
        Animal animal2 = new Animal(new Vector2d(3, 4));


        WorldMap map = new RectangularMap(9, 5);
        map.place(animal1);
        map.place(animal2);
        System.out.println(map);

        Simulation simulation = new Simulation(directions, map);

       //simulation.run();


        WorldMap map2 = new GrassField(10);
        Simulation simulation2 = new Simulation(directions, map2);
        map2.place(animal1);
        map2.place(animal2);
        simulation2.run();

        System.out.println("System zakończył działanie");
    }
}

