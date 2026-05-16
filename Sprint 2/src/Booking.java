import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Booking.java
 *
 * Represents a booking made by a user for a specific vehicle.
 * Adds support for loyalty point calculation based on rental cost using Strategy pattern.
 */
public class Booking {
    private String bookingId;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isActive;

    public Booking(String bookingId, User user, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = false;
    }

    /**
     * Starts the booking if the vehicle is available.
     */
    public void start() {
        if (vehicle.rent(user.getName())) {
            isActive = true;
            System.out.println("Booking started: " + bookingId + " for " + user.getName());
        } else {
            System.out.println("Vehicle not available for booking.");
        }
    }

    /**
     * Ends the booking, returns the vehicle, and awards loyalty points.
     */
    public void end() {
        vehicle.returnItem();
        isActive = false;

        Duration duration = Duration.between(startTime, endTime);
        long minutes = duration.toMinutes();
        double totalCost = vehicle.getRentalPrice() * (minutes / 60.0);

        user.addLoyaltyPoints(totalCost);

        System.out.println("Booking ended: " + bookingId);
        System.out.println("Cost: £" + totalCost + " | Loyalty Points Earned: " +
                user.getLoyaltyPoints());
    }

    /**
     * Prints full booking details.
     */
    public void print() {
        System.out.println("Booking ID: " + bookingId);
        user.print();
        vehicle.print();
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Status: " + (isActive ? "Active" : "Completed"));
    }

    public boolean isActive() {
        return isActive;
    }
}
