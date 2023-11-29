package agh.ics.oop.model;

import java.util.*;

public class RandomPositionGenerator implements Iterable<Vector2d>{

    private final int maxHeight;
    private final int maxWidth;
    private final int grassCount;
    private final Set<Vector2d> generatedPositions = new HashSet<>();


    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;

    }
    @Override
    public Iterator<Vector2d> iterator() {
        List<Vector2d> positions = generateAllPositions();
        Collections.shuffle(positions);

        return new Iterator<Vector2d>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < grassCount;
            }

            public Vector2d next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Wygenerowano już ostatnią pozycję");
            }
                Vector2d randomPosition = positions.get(currentIndex);
                currentIndex++;
                return randomPosition;
        }

    };
    }
    private List<Vector2d> generateAllPositions() {
        List<Vector2d> positions = new ArrayList<>();
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }
        return positions;
    }
    }
