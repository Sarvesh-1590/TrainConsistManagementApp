import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a LinkedHashSet for train formation to maintain order and uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Attach bogies: Engine, Sleeper, Cargo, Guard
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        System.out.println("Attaching bogies: Engine, Sleeper, Cargo, Guard...");

        // Attempt to attach a duplicate bogie
        System.out.println("Attempting to attach duplicate: Sleeper...");
        formation.add("Sleeper");

        // Display the final formation order - duplicates removed, order preserved
        System.out.println("Final Formation (Ordered & Unique): " + formation);
    }
}
