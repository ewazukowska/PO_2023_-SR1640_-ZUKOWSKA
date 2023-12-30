package agh.ics.oop.model;

import agh.ics.oop.presenter.SimulationPresenter;

public class ConsoleMapDisplay implements MapChangeListener {

    private int numbersOfUpdates = 0;
    private SimulationPresenter presenter;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        stringBuilder.append("Map ID: " + worldMap.getId());
        stringBuilder.append(worldMap);

        System.out.println(stringBuilder);

        presenter.drawMap();

        synchronized (this) {
            System.out.println(++numbersOfUpdates);
        }
    }

}
