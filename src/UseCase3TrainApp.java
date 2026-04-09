import java.util.HashSet;
import java.util.Set;

public class UseCase3TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a HashSet for bogie IDs to ensure uniqueness
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // Duplicate ID

        System.out.println("Bogie IDs added: BG101, BG102, BG101");

        // Print the final set - duplicates should be removed automatically
        System.out.println("Unique Bogie IDs: " + bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}
