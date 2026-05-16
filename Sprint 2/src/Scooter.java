/**
 * Represents a scooter for rental.
 */
public class Scooter extends Vehicle {
    private boolean isElectric;

    /**
     * Constructor to initialize a scooter with details.
     * @param id Unique identifier for the scooter.
     * @param name Name of the scooter.
     * @param maxSpeed Maximum speed of the scooter.
     * @param rentalPrice Rental price of the scooter.
     * @param isElectric Whether the scooter is electric or not.
     */
    public Scooter(String id, String name, int maxSpeed, double rentalPrice, boolean isElectric) {
        super(id, name, "Scooter", maxSpeed, rentalPrice, isElectric ? "Electric" : "Gasoline");
        this.isElectric = isElectric;
    }

    /**
     * Prints the details of the scooter, including specific attributes.
     */
    @Override
    public void print() {
        super.printDetails(); // Print common vehicle details
        System.out.println("Is Electric: " + (isElectric ? "Yes" : "No"));
    }
}
