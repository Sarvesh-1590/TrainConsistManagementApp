import java.util.ArrayList;
import java.util.List;

public class UseCase2TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create an ArrayList for passenger bogies
        List<String> bogies = new ArrayList<>();

        // Add bogies: Sleeper, AC Chair, First Class
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        // Print the list after insertion
        System.out.println("Bogies added: " + bogies);

        // Remove one bogie (for example AC Chair)
        bogies.remove("AC Chair");
        System.out.println("Bogie 'AC Chair' removed.");

        // Use contains() to check if Sleeper exists
        boolean hasSleeper = bogies.contains("Sleeper");
        System.out.println("Is 'Sleeper' present? " + hasSleeper);

        // Print final list state
        System.out.println("Current Bogies: " + bogies);
    }
}
