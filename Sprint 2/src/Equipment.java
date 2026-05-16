/**
 * Represents safety equipment for rental.
 */
public class Equipment {
    private String equipmentName;
    private boolean isAvailable;

    /**
     * Constructor to initialize equipment with a name.
     * @param equipmentName The name of the equipment.
     */
    public Equipment(String equipmentName) {
        this.equipmentName = (equipmentName != null && !equipmentName.isEmpty()) ? equipmentName : "Unknown Equipment";
        this.isAvailable = true;
    }

    /**
     * Checks if the equipment is available for rent.
     * @return true if available, otherwise false.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Marks the equipment as rented if available.
     */
    public void rent(String renterName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(equipmentName + " has been rented by " + renterName + ".");
        } else {
            System.out.println(equipmentName + " is not available.");
        }
    }

    /**
     * Marks the equipment as available for rental.
     */
    public void returnEquipment() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(equipmentName + " has been returned.");
        } else {
            System.out.println(equipmentName + " was already available.");
        }
    }

    /**
     * Prints the details of the equipment.
     */
    public void print() {
        System.out.println("Equipment - Name: " + equipmentName + ", Available: " + (isAvailable ? "Yes" : "No"));
    }

    public boolean getName() {
        return false;
    }
}
