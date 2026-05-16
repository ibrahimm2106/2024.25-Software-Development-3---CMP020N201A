import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a vehicle for rental with enhanced features.
 */
public abstract class Vehicle {
    private String id;
    private String name;
    private String type;
    private int maxSpeed;
    private double rentalPrice;
    private String fuelType;
    private boolean isAvailable;
    private boolean isUnderMaintenance;
    private int totalMilesDriven;
    private int lastMaintenanceMiles;
    private String condition;
    private boolean hasGPS;
    private List<String> safetyFeatures;
    private List<String> rentalHistory;

    /**
     * Constructor to initialize a vehicle with details.
     * @param id Unique identifier for the vehicle.
     * @param name Name of the vehicle.
     * @param type Type or category of the vehicle.
     * @param maxSpeed Maximum speed of the vehicle.
     * @param rentalPrice Rental price of the vehicle.
     * @param fuelType Fuel type of the vehicle (e.g., Electric, Gasoline).
     */
    public Vehicle(String id, String name, String type, int maxSpeed, double rentalPrice, String fuelType) {
        this.id = (id != null) ? id : "Unknown ID";
        this.name = (name != null) ? name : "Unknown Name";
        this.type = (type != null) ? type : "Unknown Type";
        this.maxSpeed = maxSpeed;
        this.rentalPrice = rentalPrice;
        this.fuelType = (fuelType != null) ? fuelType : "N/A"; // Provide default value if null
        this.isAvailable = true;
        this.isUnderMaintenance = false;
        this.totalMilesDriven = 0;
        this.lastMaintenanceMiles = 0;
        this.condition = "Excellent"; // Default condition
        this.hasGPS = false; // Default value
        this.safetyFeatures = new ArrayList<>();
        this.rentalHistory = new ArrayList<>();
    }

    /**
     * Marks the vehicle as rented if available and not under maintenance.
     * @param renterName Name of the renter.
     */
    public void rent(String renterName) {
        if (isAvailable && !isUnderMaintenance) {
            isAvailable = false;
            rentalHistory.add(renterName);
            System.out.println(name + " (ID: " + id + ") has been rented by " + renterName + ".");
        } else if (isUnderMaintenance) {
            System.out.println(name + " (ID: " + id + ") is under maintenance and cannot be rented.");
        } else {
            System.out.println(name + " (ID: " + id + ") is already rented.");
        }
    }

    /**
     * Marks the vehicle as available for rental.
     */
    public void returnVehicle() {
        isAvailable = true;
        System.out.println(name + " (ID: " + id + ") has been returned.");
    }

    /**
     * Sets the vehicle under maintenance.
     */
    public void setUnderMaintenance() {
        isUnderMaintenance = true;
        System.out.println(name + " (ID: " + id + ") is now under maintenance.");
    }

    /**
     * Ends the maintenance status of the vehicle.
     */
    public void endMaintenance() {
        isUnderMaintenance = false;
        lastMaintenanceMiles = totalMilesDriven;
        System.out.println(name + " (ID: " + id + ") is no longer under maintenance.");
    }

    /**
     * Updates the mileage of the vehicle.
     * @param milesDriven The number of miles driven since the last update.
     */
    public void updateMileage(int milesDriven) {
        totalMilesDriven += milesDriven;
    }

    /**
     * Adds a safety feature to the vehicle.
     * @param feature Name of the safety feature.
     */
    public void addSafetyFeature(String feature) {
        if (feature != null && !feature.isEmpty()) {
            safetyFeatures.add(feature);
        }
    }

    /**
     * Prints the details of the vehicle.
     */
    public void print() {
        printDetails();
    }

    /**
     * Common method to print vehicle details, used within the print method.
     */
    protected void printDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Rental Price: $" + rentalPrice + " per hour");
        System.out.println("Available: " + isAvailable);
        System.out.println("Under Maintenance: " + isUnderMaintenance);
        System.out.println("Condition: " + condition);
        System.out.println("Total Miles Driven: " + totalMilesDriven);
        System.out.println("Last Maintenance Miles: " + lastMaintenanceMiles);
        System.out.println("Has GPS: " + hasGPS);
        System.out.println("Safety Features: " + (safetyFeatures.isEmpty() ? "None" : String.join(", ", safetyFeatures)));
        System.out.println("Rental History: " + (rentalHistory.isEmpty() ? "None" : String.join(", ", rentalHistory)));
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isUnderMaintenance() {
        return isUnderMaintenance;
    }

    public int getTotalMilesDriven() {
        return totalMilesDriven;
    }

    public int getLastMaintenanceMiles() {
        return lastMaintenanceMiles;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    public List<String> getSafetyFeatures() {
        return safetyFeatures;
    }

    public List<String> getRentalHistory() {
        return rentalHistory;
    }
}
