class PassengerBogie {
    private String name;
    private int capacity;

    public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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
        return name + " - Capacity " + capacity;
    }
}

public class UseCase14TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Invalid Capacity Check ===");

        // Test Case 1: Valid Capacity
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Successfully created: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        // Test Case 2: Zero Capacity
        try {
            PassengerBogie acChair = new PassengerBogie("AC Chair", 0);
            System.out.println("Successfully created: " + acChair);
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        // Test Case 3: Negative Capacity
        try {
            PassengerBogie firstClass = new PassengerBogie("First Class", -10);
            System.out.println("Successfully created: " + firstClass);
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }
    }
}
