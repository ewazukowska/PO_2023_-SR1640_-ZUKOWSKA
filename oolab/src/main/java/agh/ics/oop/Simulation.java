package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;


public class Simulation implements Runnable{
    private List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap map;
    public Simulation(List<MoveDirection> moves, List<Vector2d> positions, WorldMap map) {
        this.moves = moves;
        this.map = map;

        for (Vector2d position : positions){
            try{
                map.place(new Animal(position));
            } catch (PositionAlreadyOccupiedException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public synchronized void run() {
        animals = map.getAnimals();
        int nrOfAnimals = animals.size();
        int nrOfMoves = moves.size();
        System.out.println(animals);

        for (int i = 0; i < nrOfMoves; i++) {
            Animal currentAnimal = animals.get(i % nrOfAnimals);
            MoveDirection currentMove = moves.get(i);
            map.move(currentAnimal, currentMove);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

