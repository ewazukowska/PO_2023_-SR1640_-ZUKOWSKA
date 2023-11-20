package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;


public class Simulation {
    private final List<MoveDirection> moves;
    private WorldMap worldMap;
    private final List<Animal> animals;



    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap worldMap) {
        this.moves = moves;
        this.worldMap = worldMap;
        this.animals = createAnimals(initialPositions);
    }

    public List<Animal> createAnimals(List<Vector2d> initialPositions) {
        List<Animal> animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            worldMap.place(new Animal(position));
            animals.add(new Animal(position));
        }
        return animals;
    }

    public void run() {
        int nrOfAnimals = animals.size();
        int nrOfMoves = moves.size();
        System.out.println(animals);

        for (int i = 0; i < nrOfMoves; i++) {
            Animal currentAnimal = animals.get(i % nrOfAnimals);
            MoveDirection currentMove = moves.get(i);

            worldMap.move(currentAnimal, currentMove);
            System.out.println("Aktualny stan mapy:\n" + worldMap);
        }

    }

}



