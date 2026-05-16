/**
 * Represents a skateboard for rental.
 */
public class Skateboard extends Vehicle {
    private String material;

    /**
     * Constructor to initialize a skateboard with details.
     * @param id Unique identifier for the skateboard.
     * @param name Name of the skateboard.
     * @param maxSpeed Maximum speed of the skateboard.
     * @param rentalPrice Rental price of the skateboard.
     * @param material Material type of the skateboard.
     */
    public Skateboard(String id, String name, int maxSpeed, double rentalPrice, String material) {
        super(id, name, "Skateboard", maxSpeed, rentalPrice, "N/A"); // Skateboards do not use fuel, so set "N/A"
        this.material = (material != null && !material.isEmpty()) ? material : "Unknown Material";
    }

    /**
     * Prints the details of the skateboard, including specific attributes.
     */
    @Override
    public void print() {
        super.printDetails(); // Print common vehicle details
        System.out.println("Material: " + material);
    }
}
