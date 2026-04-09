import java.util.LinkedList;

public class UseCase4TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a LinkedList for the consist to maintain physical sequence
        LinkedList<String> consist = new LinkedList<>();

        // Add bogies: Engine, Sleeper, AC, Cargo, Guard
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("Initial Consist: " + consist);

        // Insert a Pantry Car at position 2
        consist.add(2, "Pantry Car");
        System.out.println("After Inserting Pantry Car: " + consist);

        // Remove the first and last bogie
        consist.removeFirst();
        consist.removeLast();

        // Display the final ordered train consist
        System.out.println("Final Consist (After removing first & last): " + consist);
    }
}
