package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class SimulationEngine {
    private List<Simulation> simulations;
    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        List<Thread> threads = new ArrayList<>();
        for (Simulation simulation : simulations) {
            // Osobny wątek dla każdej symulacji
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
    public void runAsyncInThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (Simulation simulation : simulations) {
            executorService.submit(simulation);
        }

        executorService.shutdown();
    }

}
