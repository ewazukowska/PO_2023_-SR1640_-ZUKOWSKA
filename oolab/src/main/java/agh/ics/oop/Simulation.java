package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;
import java.util.List;


public class Simulation {
    private final List<Vector2d> initialPositions;
    private final List<MoveDirection> moves;

    private final List<Animal> animals;



    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves) {
        this.initialPositions = initialPositions;
        this.moves = moves;
        this.animals = createAnimals(initialPositions);
    }

    public List<Animal> createAnimals(List<Vector2d> initialPositions) {
        List<Animal> animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            animals.add(new Animal(position));
        }
        return animals;
    }

    public void run() {
        List<Animal> animals = createAnimals(initialPositions);
        int nrOfAnimals = animals.size();
        int nrOfMoves = moves.size();
        System.out.println(animals);

        for (int i = 0; i < nrOfMoves; i++) {
            Animal currentAnimal = animals.get(i % nrOfAnimals);
            MoveDirection currentMove = moves.get(i);

            currentAnimal.move(currentMove);
            System.out.println("Zwierzę " + i % nrOfAnimals + ": " + currentAnimal);
        }
    }

}



