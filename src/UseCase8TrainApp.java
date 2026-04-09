import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " - " + capacity + " seats";
    }
}

public class UseCase8TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a List to store bogie objects
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 40));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("All Bogies: " + bogies);

        // Use Stream API to filter bogies with capacity > 60
        System.out.println("Filtering bogies with capacity > 60...");
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // Display the filtered bogies
        System.out.println("Filtered Bogies: " + highCapacityBogies);

        // Verify original collection remains unchanged
        System.out.println("Original list size remains: " + bogies.size());
    }
}
