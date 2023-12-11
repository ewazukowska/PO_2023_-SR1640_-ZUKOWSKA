package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);
        try {
/*

            for (MoveDirection direction : directions) {
                switch (direction) {
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                    case LEFT -> System.out.println("Zwierzak idzie w lewo");
                }
            }
            List<Vector2d> positions = List.of(new Vector2d(3, 4), new Vector2d(0, 0));

            RectangularMap map1 = new RectangularMap(9, 4);
            ConsoleMapDisplay observer = new ConsoleMapDisplay();
            map1.addObserver(observer);

            Simulation simulation1 = new Simulation(directions, positions, map1);
            //simulation1.run();

            GrassField map2 = new GrassField(10);
            map2.addObserver(observer);

            Simulation simulation2 = new Simulation(directions, positions, map2);
            //simulation2.run();

            List<Simulation> simulations = List.of(simulation1, simulation2);

            SimulationEngine simulationEngine = new SimulationEngine(simulations);

            //simulationEngine.runSync();
            simulationEngine.runAsync();

            System.out.println("System zakończył działanie");
*/

            List <Simulation> simulations = new ArrayList<>();
            Random random = new Random();
            List<Thread> threads = new ArrayList<>();

            for (int i = 0; i < 1000; i++) {
                AbstractWorldMap map;
                ConsoleMapDisplay observer;
                int mapSizeX = random.nextInt(10) + 2;
                int mapSizeY = random.nextInt(10) + 2;

                if (Math.random() < 0.5) {
                    map = new RectangularMap(mapSizeX, mapSizeY);

                }
                else {
                    map = new GrassField(mapSizeY);
                }
                observer = new ConsoleMapDisplay();
                map.addObserver(observer);
                Simulation simulation = new Simulation(directions, List.of(new Vector2d(0, 0), new Vector2d(3, 4)), map);
                simulations.add(simulation);
            }
            SimulationEngine simulationEngine = new SimulationEngine(simulations);
            simulationEngine.runAsyncInThreadPool();
            simulationEngine.awaitSimulationsEnd();

        }
        catch (IllegalArgumentException er) {
            er.printStackTrace();
        }
        catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

    }
}

