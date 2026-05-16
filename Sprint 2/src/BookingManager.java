public class BookingManager {
    private static BookingManager instance;
    private int bookingCounter = 1;

    private BookingManager() {
        // private constructor to restrict instantiation
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    public String generateBookingId() {
        return "BK" + String.format("%03d", bookingCounter++);
    }

    // You can also manage global bookings here in future
}
