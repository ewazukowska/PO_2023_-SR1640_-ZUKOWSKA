package agh.ics.oop.model;


public class GrassField extends AbstractWorldMap {

    public GrassField(int numberOfGrassFields) {
        for (int i = 0; i < numberOfGrassFields; i++) {
            Vector2d position;
            Grass newGrass;
            do {
                position = new Vector2d(
                        (int) (Math.random() * Math.sqrt(numberOfGrassFields * 10)),
                        (int) (Math.random() * Math.sqrt(numberOfGrassFields * 10))
                );
            } while (grass.containsKey(position));
            newGrass = new Grass(position);
            grass.put(position, newGrass);
    } System.out.println(grass);
    }

    public Vector2d calculateUpperRight() {
        Vector2d end = new Vector2d(0, 0);

        for (Vector2d position : animals.keySet()) {
            end = end.upperRight(position);
        }
        for (Vector2d position : grass.keySet()) {
            end = end.upperRight(position);
        }
        return end;
    }
    public Vector2d calculateLowerLeft() {
        Vector2d beginning = new Vector2d(0, 0);
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
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(calculateLowerLeft(), calculateUpperRight());
    }
}
