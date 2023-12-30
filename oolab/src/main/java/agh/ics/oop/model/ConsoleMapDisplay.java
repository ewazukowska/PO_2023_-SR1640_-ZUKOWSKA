package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int numbersOfUpdates = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        stringBuilder.append("Map ID: " + worldMap.getId());
        stringBuilder.append(worldMap);

        System.out.println(stringBuilder);

        synchronized (this) {
            System.out.println(++numbersOfUpdates);
        }
    }

}
