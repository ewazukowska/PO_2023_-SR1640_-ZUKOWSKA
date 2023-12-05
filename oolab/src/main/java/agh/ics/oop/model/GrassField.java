package agh.ics.oop.model;


import java.util.*;

public class GrassField extends AbstractWorldMap {

    protected Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int numberOfGrassFields) {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) (Math.random() * Math.sqrt(numberOfGrassFields * 10)), (int) (Math.random() * Math.sqrt(numberOfGrassFields * 10)), numberOfGrassFields);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grass.put(grassPosition, new Grass(grassPosition));
        }
    }

    public Vector2d calculateUpperRight() {
        Vector2d end = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Vector2d position : animals.keySet()) {
            end = end.upperRight(position);
        }
        for (Vector2d position : grass.keySet()) {
            end = end.upperRight(position);
        }
        return end;
    }
    public Vector2d calculateLowerLeft() {
        Vector2d beginning = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Vector2d position : animals.keySet()) {
            beginning = beginning.lowerLeft(position);
        }
        for (Vector2d position : grass.keySet()) {
            beginning = beginning.lowerLeft(position);
        }
        return beginning;
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        //zaczynamy od zwierząt
        WorldElement element = super.objectAt(position);

        //teraz trawa
        if (element == null && grass.containsKey(position)) {
            return grass.get(position);
        }

        return element;
    }

    public List<Grass> getGrass() {
        return new ArrayList<>(grass.values());
    }

    @Override
    public Collection<WorldElement> getElements() {
        var elements = super.getElements();
        elements.addAll(grass.values());
        return elements;
    }

    @Override
    public Boundary getCurrentBounds() {
        Vector2d beginning = calculateLowerLeft();
        Vector2d end = calculateUpperRight();
        return new Boundary(beginning, end);
    }
}
