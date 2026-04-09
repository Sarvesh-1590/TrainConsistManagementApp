import java.util.HashMap;
import java.util.Map;

public class UseCase6TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a HashMap to store bogie-capacity information
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // Use the put() method to map each bogie to its capacity
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 40);
        bogieCapacities.put("First Class", 24);

        System.out.println("Bogie-Capacity Mapping:");

        // Iterate over the map using entrySet() to display details
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }
    }
}
