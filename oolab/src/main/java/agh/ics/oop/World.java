package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");
        run(args);
        System.out.println("System zakonczyl dzialanie");
    }
    public static void run(String[] args) {
        System.out.println("Zwierzak idzie do przodu");

        if (args.length > 0) {
            StringBuilder argumentString = new StringBuilder();
            argumentString.append(args[0]);
            for (int i = 1; i < args.length; i++) {
                argumentString.append(", ").append(args[i]);
            }
            System.out.println("Argumenty: " + argumentString);
        } else {
            System.out.println("Brak przekazanych argumentów.");
        }
    }
}
