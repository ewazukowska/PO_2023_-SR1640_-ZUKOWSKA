package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;


public class Simulation<T extends Animal> {
    private final List<MoveDirection> moves;
    final WorldMap<T, Vector2d> map;
    private final List<T> animals;



    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap map) {
        this.moves = moves;
        this.map = map;
        this.animals = createAnimals(initialPositions);
    }

    public List<T> createAnimals(List<Vector2d> initialPositions) {
        List<T> animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            map.place((T) new Animal(position));
            animals.add((T) new Animal(position));
        }
        return animals;
    }

    public void run() {
        int nrOfAnimals = animals.size();
        int nrOfMoves = moves.size();
        System.out.println(animals);

        for (int i = 0; i < nrOfMoves; i++) {
            T currentAnimal = animals.get(i % nrOfAnimals);
            MoveDirection currentMove = moves.get(i);

            map.move(currentAnimal, currentMove);
            System.out.println("Aktualny stan mapy:\n" + map);
        }

    }

}



