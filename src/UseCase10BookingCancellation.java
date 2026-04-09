import java.util.*;

class Booking {
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

public class UseCase10BookingCancellation {
    // Inventory: roomType -> available count
    private static Map<String, Integer> inventory = new HashMap<>();
    // RoomType -> Stack of released room IDs (for rollback)
    private static Map<String, Stack<String>> releasedRooms = new HashMap<>();
    // BookingId -> Booking
    private static Map<String, Booking> bookings = new HashMap<>();

    public static void main(String[] args) {
        // Setup inventory
        inventory.put("Deluxe", 2);
        inventory.put("Suite", 1);
        releasedRooms.put("Deluxe", new Stack<>());
        releasedRooms.put("Suite", new Stack<>());

        // Simulate confirmed bookings
        Booking b1 = new Booking("B001", "Alice", "Deluxe", "D101");
        Booking b2 = new Booking("B002", "Bob", "Deluxe", "D102");
        Booking b3 = new Booking("B003", "Charlie", "Suite", "S201");
        bookings.put(b1.bookingId, b1);
        bookings.put(b2.bookingId, b2);
        bookings.put(b3.bookingId, b3);
        inventory.put("Deluxe", inventory.get("Deluxe") - 2);
        inventory.put("Suite", inventory.get("Suite") - 1);

        System.out.println("Initial Bookings:");
        bookings.values().forEach(System.out::println);
        System.out.println("Inventory: " + inventory);

        // Attempt cancellation
        cancelBooking("B002"); // Valid
        cancelBooking("B003"); // Valid
        cancelBooking("B003"); // Already cancelled
        cancelBooking("B999"); // Non-existent

        System.out.println("\nFinal Bookings:");
        bookings.values().forEach(System.out::println);
        System.out.println("Inventory: " + inventory);
        System.out.println("Released Rooms: " + releasedRooms);
    }

    public static void cancelBooking(String bookingId) {
        System.out.println("\nRequest to cancel booking: " + bookingId);
        Booking booking = bookings.get(bookingId);
        if (booking == null) {
            System.out.println("Error: Booking does not exist.");
            return;
        }
        if (booking.isCancelled) {
            System.out.println("Error: Booking already cancelled.");
            return;
        }
        // LIFO rollback: push released room ID
        releasedRooms.get(booking.roomType).push(booking.roomId);
        // Restore inventory
        inventory.put(booking.roomType, inventory.get(booking.roomType) + 1);
        // Mark as cancelled
        booking.isCancelled = true;
        System.out.println("Booking cancelled and inventory rolled back. Room " + booking.roomId + " released.");
    }
}
