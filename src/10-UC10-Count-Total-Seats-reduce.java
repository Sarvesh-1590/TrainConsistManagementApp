import java.util.*;

class Bogie {
    String type;
    int capacity;
    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return type + " - " + capacity + " seats";
    }
}

public class 10-UC10-Count-Total-Seats-reduce {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 40));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Bogie List: " + bogies);

        // Stream aggregation using map() and reduce()
        int totalCapacity = bogies.stream()
            .map(b -> b.capacity)
            .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalCapacity + " seats");
    }
}
