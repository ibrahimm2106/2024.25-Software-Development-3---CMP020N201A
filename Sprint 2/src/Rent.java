import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Represents a rental transaction between a user and a vehicle.
 */
public class Rent {
    private User renter;
    private Vehicle vehicle;
    private LocalDateTime rentDate;
    private LocalDateTime dueDate;
    private double rentalFee;

    /**
     * Constructor to initialize a rental transaction.
     * @param renter The user renting the vehicle.
     * @param vehicle The vehicle being rented.
     * @param rentDate The date and time when the rental starts.
     * @param dueDate The expected due date and time for returning the vehicle.
     */
    public Rent(User renter, Vehicle vehicle, LocalDateTime rentDate, LocalDateTime dueDate) {
        this.renter = renter;
        this.vehicle = vehicle;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.rentalFee = calculateRentalFee();

        // Mark the vehicle as rented
        if (vehicle.isAvailable()) {
            vehicle.rent(renter.getName());
            System.out.println("Rental created successfully: " + vehicle.getName() + " rented by " + renter.getName() + " from " + rentDate + " to " + dueDate);
        } else {
            System.out.println("Vehicle " + vehicle.getName() + " is not available for rent.");
        }
    }

    /**
     * Calculates the rental fee based on the rental period.
     * Assumes rental price is per hour.
     * @return The calculated rental fee.
     */
    private double calculateRentalFee() {
        long hours = Duration.between(rentDate, dueDate).toHours();
        return vehicle.getRentalPrice() * Math.max(hours, 1); // Charge for at least one hour
    }

    /**
     * Completes the rental, marking the vehicle as available and printing summary.
     */
    public void completeRental() {
        if (!vehicle.isAvailable()) {
            vehicle.returnVehicle();  // Mark the vehicle as available
            System.out.println("Rental completed: " + vehicle.getName() + " returned by " + renter.getName() + ". Total fee: $" + rentalFee);
        } else {
            System.out.println("Vehicle " + vehicle.getName() + " is already available.");
        }
    }

    // Getters and Setters
    public User getRenter() {
        return renter;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    /**
     * Extends the rental period.
     * @param additionalHours The number of hours to extend the rental.
     */
    public void extendRental(int additionalHours) {
        if (additionalHours > 0) {
            dueDate = dueDate.plusHours(additionalHours);
            rentalFee = calculateRentalFee();
            System.out.println("Rental extended for " + vehicle.getName() + ". New due date: " + dueDate + ". Updated fee: $" + rentalFee);
        } else {
            System.out.println("Invalid number of hours for extension.");
        }
    }

    /**
     * Prints the rental details.
     */
    public void printRentalDetails() {
        System.out.println("\n=== Rental Details ===");
        System.out.println("Renter: " + renter.getName());
        System.out.println("Vehicle: " + vehicle.getName());
        System.out.println("Rent Date: " + rentDate);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Rental Fee: $" + rentalFee);
    }
}
