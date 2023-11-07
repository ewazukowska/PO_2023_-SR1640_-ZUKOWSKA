package agh.ics.oop.model;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int count = 0;

        for (String arg : args) {
            switch (arg) {
                case "f" -> directions[count] = MoveDirection.FORWARD;
                case "b" -> directions[count] = MoveDirection.BACKWARD;
                case "r" -> directions[count] = MoveDirection.RIGHT;
                case "l" -> directions[count] = MoveDirection.LEFT;
            }
            count++;
        }
        return java.util.Arrays.copyOf(directions, count);
    }
}
