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
}

public class UseCase13TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Performance Benchmark ===");

        // Create a large collection of bogies for benchmarking
        int numBogies = 1_000_000;
        List<Bogie> bogies = new ArrayList<>(numBogies);
        
        for (int i = 0; i < numBogies; i++) {
            if (i % 3 == 0) {
                bogies.add(new Bogie("Sleeper", 72));
            } else if (i % 3 == 1) {
                bogies.add(new Bogie("AC Chair", 40));
            } else {
                bogies.add(new Bogie("First Class", 24));
            }
        }
        System.out.println("Generated " + numBogies + " bogies for testing.\n");

        // --- Loop-Based Filtering ---
        long startLoop = System.nanoTime();
        List<Bogie> filteredByLoop = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                filteredByLoop.add(bogie);
            }
        }
        long endLoop = System.nanoTime();
        long loopTimeMs = (endLoop - startLoop) / 1_000_000;

        // --- Stream-Based Filtering ---
        long startStream = System.nanoTime();
        List<Bogie> filteredByStream = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamTimeMs = (endStream - startStream) / 1_000_000;

        // Print results
        System.out.println("Loop Filter Time: " + loopTimeMs + " ms | Found: " + filteredByLoop.size() + " bogies");
        System.out.println("Stream Filter Time: " + streamTimeMs + " ms | Found: " + filteredByStream.size() + " bogies");
    }
}
