/**
 * Segway.java
 *
 * Represents a Segway (self-balancing electric vehicle) in the ZipAbout system.
 * Inherits rental and maintenance logic from Vehicle.
 * Adds a unique attribute: balance system.
 *
 * Demonstrates inheritance and polymorphism.
 *
 * Author: Anwar Ali
 * Date: Nov 2025
 */
public class Segway extends Vehicle {

    /** Type of balance system (e.g., "Gyroscopic") */
    private String balanceSystem;

    /**
     * Constructs a new Segway object.
     *
     * @param id             Unique vehicle ID
     * @param name           Display name
     * @param rentalPrice    Rental price per hour
     * @param balanceSystem  Description of balance system
     */
    public Segway(String id, String name, double rentalPrice, String balanceSystem) {
        super(id, name, rentalPrice);
        this.balanceSystem = balanceSystem;
    }

    /**
     * Prints Segway details, overriding the abstract method from Vehicle.
     */
    @Override
    public void print() {
        System.out.println("Segway: " + getName() +
                " | Balance System: " + balanceSystem +
                " | Price: £" + getRentalPrice() +
                " | Available: " + isAvailable() +
                " | Maintenance: " + (isUnderMaintenance() ? "Yes" : "No"));
    }

    public String getBalanceSystem() {
        return balanceSystem;
    }
}
