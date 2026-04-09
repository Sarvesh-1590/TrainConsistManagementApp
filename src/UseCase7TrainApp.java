import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

public class UseCase7TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a List to store bogie objects
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies with their seating capacities
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 40));
        bogies.add(new Bogie("First Class", 24));

        // Use Comparator.comparingInt to sort by capacity (ascending)
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("Sorted Bogies by Capacity:");

        // Display the sorted bogies
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
    }
}
