package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;


public class Simulation {
    private List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap map;

    public Simulation(List<MoveDirection> moves, WorldMap map) {
        this.moves = moves;
        this.map = map;
    }
    public void run() {
        animals = map.getAnimals();
        int nrOfAnimals = animals.size();
        int nrOfMoves = moves.size();
        System.out.println(animals);

        for (int i = 0; i < nrOfMoves; i++) {
            Animal currentAnimal = animals.get(i % nrOfAnimals);
            MoveDirection currentMove = moves.get(i);

            map.move(currentAnimal, currentMove);
            System.out.println(map);
        }
    }

}

