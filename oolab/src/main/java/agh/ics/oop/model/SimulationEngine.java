package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private List<Thread> threads = new ArrayList<>();
    private ExecutorService executorService;
    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation);
            thread.start();
            threads.add(thread);
        }
    }

    public void awaitSimulationsEnd() throws InterruptedException {
        for(Thread thread : threads) {
            thread.join();
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
    public void runAsyncInThreadPool() {
        if(executorService == null) {
            executorService = Executors.newFixedThreadPool(4);
        }
        for (Simulation simulation : simulations) {
            executorService.submit(simulation);
        }

}}
