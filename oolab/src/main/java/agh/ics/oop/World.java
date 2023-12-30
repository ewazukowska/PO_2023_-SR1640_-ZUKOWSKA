package agh.ics.oop;

import agh.ics.oop.model.*;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class World {
    public static void main(String[] args) {
        Application.launch(SimulationApp.class, args);
        System.out.println("System wystartował");
        List<MoveDirection> directions = OptionsParser.parse(args);
        ConsoleMapDisplay observer = new ConsoleMapDisplay();
        try {

            List <Simulation> simulations = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                AbstractWorldMap map;
                int mapSizeX = random.nextInt(10) + 2;
                int mapSizeY = random.nextInt(10) + 2;

                if (Math.random() < 0.5) {
                    map = new RectangularMap(mapSizeX, mapSizeY);
                }
                else {
                    map = new GrassField(mapSizeY);
                }
                map.addObserver(observer);
                Simulation simulation = new Simulation(directions, List.of(new Vector2d(0, 0), new Vector2d(3, 4)), map);
                simulations.add(simulation);
            }

            SimulationEngine simulationEngine = new SimulationEngine(simulations);
            simulationEngine.runAsyncInThreadPool();
            simulationEngine.awaitSimulationsEnd();

        }
        catch (IllegalArgumentException | InterruptedException er) {
            er.printStackTrace();
        }
    }
}

