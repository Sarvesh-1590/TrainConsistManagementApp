import java.io.*;
import java.util.*;

class Booking implements Serializable {
    String bookingId;
    String guestName;
    String roomType;
    String roomId;
    boolean isCancelled;

    Booking(String bookingId, String guestName, String roomType, String roomId) {
        this.bookingId = bookingId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
        this.isCancelled = false;
    }

    @Override
    public String toString() {
        return bookingId + ": Guest=" + guestName + ", RoomType=" + roomType + ", RoomID=" + roomId + ", Cancelled=" + isCancelled;
    }
}

public class UseCase12DataPersistenceRecovery {
    private static final String DATA_FILE = "hotel_state.ser";
    private static Map<String, Integer> inventory = new HashMap<>();
    private static Map<String, Booking> bookings = new HashMap<>();

    public static void main(String[] args) {
        // Try to restore state
        if (!restoreState()) {
            // If no state, initialize
            inventory.put("Deluxe", 2);
            inventory.put("Suite", 1);
            Booking b1 = new Booking("B001", "Alice", "Deluxe", "D101");
            Booking b2 = new Booking("B002", "Bob", "Deluxe", "D102");
            Booking b3 = new Booking("B003", "Charlie", "Suite", "S201");
            bookings.put(b1.bookingId, b1);
            bookings.put(b2.bookingId, b2);
            bookings.put(b3.bookingId, b3);
            inventory.put("Deluxe", inventory.get("Deluxe") - 2);
            inventory.put("Suite", inventory.get("Suite") - 1);
        }

        System.out.println("Current Bookings:");
        bookings.values().forEach(System.out::println);
        System.out.println("Inventory: " + inventory);

        // Simulate a booking cancellation
        cancelBooking("B002");
        System.out.println("\nAfter Cancellation:");
        bookings.values().forEach(System.out::println);
        System.out.println("Inventory: " + inventory);

        // Save state before exit
        saveState();
        System.out.println("\nSystem state saved. Restart the app to test recovery.");
    }

    private static void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null || booking.isCancelled) return;
        inventory.put(booking.roomType, inventory.get(booking.roomType) + 1);
        booking.isCancelled = true;
    }

    private static void saveState() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(inventory);
            out.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    private static boolean restoreState() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return false;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            inventory = (Map<String, Integer>) in.readObject();
            bookings = (Map<String, Booking>) in.readObject();
            System.out.println("State restored from file.");
            return true;
        } catch (Exception e) {
            System.out.println("Error restoring state: " + e.getMessage());
            return false;
        }
    }
}
