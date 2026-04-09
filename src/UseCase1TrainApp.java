import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        // Application prints welcome message
        System.out.println("=== Train Consist Management App ===");

        // Train consist is initialized
        List<String> bogies = new ArrayList<>();

        // Initial bogie count is displayed
        System.out.println("Initial Bogie Count: " + bogies.size());
    }
}
