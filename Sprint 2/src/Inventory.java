import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class for managing inventory of vehicles and equipment.
 * Ensures centralized control over all items available for rental.
 */
public class Inventory {
    // Single instance of the Inventory class
    private static Inventory instance;

    // List of all vehicles in the inventory
    private List<Vehicle> vehicles;

    // List of all equipment in the inventory
    private List<Equipment> equipmentList;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the vehicle and equipment lists.
     */
    private Inventory() {
        vehicles = new ArrayList<>();
        equipmentList = new ArrayList<>();
    }

    /**
     * Static method to provide the single instance of the Inventory class.
     * Ensures that only one instance of the class is created.
     *
     * @return The single instance of the Inventory class.
     */
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    /**
     * Adds a vehicle to the inventory.
     *
     * @param vehicle The vehicle to be added.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added to inventory: " + vehicle.getName());
    }

    /**
     * Adds equipment to the inventory.
     *
     * @param equipment The equipment to be added.
     */
    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
        System.out.println("Equipment added to inventory: " + equipment.getName());
    }

    /**
     * Retrieves a list of all available vehicles for rental.
     *
     * @return List of available vehicles.
     */
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    /**
     * Retrieves a list of all available equipment for rental.
     *
     * @return List of available equipment.
     */
    public List<Equipment> getAvailableEquipment() {
        List<Equipment> availableEquipment = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            if (equipment.isAvailable()) {
                availableEquipment.add(equipment);
            }
        }
        return availableEquipment;
    }

    /**
     * Prints the details of all vehicles in the inventory.
     */
    public void printVehicleInventory() {
        System.out.println("\n=== Vehicle Inventory ===");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the inventory.");
        } else {
            for (Vehicle vehicle : vehicles) {
                vehicle.print();
                System.out.println("-------------------------");
            }
        }
    }

    /**
     * Prints the details of all equipment in the inventory.
     */
    public void printEquipmentInventory() {
        System.out.println("\n=== Equipment Inventory ===");
        if (equipmentList.isEmpty()) {
            System.out.println("No equipment in the inventory.");
        } else {
            for (Equipment equipment : equipmentList) {
                equipment.print();
                System.out.println("-------------------------");
            }
        }
    }

    /**
     * Prints the entire inventory of vehicles and equipment.
     */
    public void printInventory() {
        printVehicleInventory();
        printEquipmentInventory();
    }

    /**
     * Searches for a vehicle by its unique ID.
     *
     * @param id The ID of the vehicle to search for.
     * @return The vehicle if found, null otherwise.
     */
    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                System.out.println("Vehicle found: " + vehicle.getName());
                return vehicle;
            }
        }
        System.out.println("Vehicle with ID " + id + " not found.");
        return null;
    }

    /**
     * Searches for equipment by its name.
     *
     * @param name The name of the equipment to search for.
     * @return The equipment if found, null otherwise.
     */
    public Equipment findEquipmentByName(String name) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName()) {
                System.out.println("Equipment found: " + equipment.getName());
                return equipment;
            }
        }
        System.out.println("Equipment with name \"" + name + "\" not found.");
        return null;
    }
}
