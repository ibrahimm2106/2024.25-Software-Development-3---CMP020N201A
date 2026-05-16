import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user who can rent vehicles and equipment.
 */
public class User {
    private String username;
    private List<Vehicle> rentedVehicles;
    private List<Equipment> rentedEquipment;

    /**
     * Constructor to initialize a user with a username.
     * @param username The name of the user.
     */
    public User(String username) {
        this.username = username;
        this.rentedVehicles = new ArrayList<>();
        this.rentedEquipment = new ArrayList<>();
    }

    /**
     * Getter for username.
     * @return The name of the user.
     */
    public String getName() {
        return username;
    }

    /**
     * Rents a vehicle if it is available.
     * @param vehicle The vehicle to rent.
     */
    public void rentVehicle(Vehicle vehicle) {
        if (vehicle.isAvailable()) {
            vehicle.rent(this.getName());
            rentedVehicles.add(vehicle);
            System.out.println(username + " has rented " + vehicle.getName() + ".");
        } else {
            System.out.println(vehicle.getName() + " is not available for rent.");
        }
    }

    /**
     * Returns a vehicle that the user has rented.
     * @param vehicle The vehicle to return.
     */
    public void returnVehicle(Vehicle vehicle) {
        if (rentedVehicles.remove(vehicle)) {
            vehicle.returnVehicle();
            System.out.println(vehicle.getName() + " has been returned by " + this.getName() + ".");
        } else {
            System.out.println("Vehicle not found in " + this.getName() + "'s rented vehicles.");
        }
    }

    /**
     * Rents equipment if it is available.
     * @param equipment The equipment to rent.
     */
    public void rentEquipment(Equipment equipment) {
        if (equipment.isAvailable()) {
            equipment.rent(this.getName());
            rentedEquipment.add(equipment);
            System.out.println(username + " has rented " + equipment.getName() + ".");
        } else {
            System.out.println(equipment.getName() + " is not available for rent.");
        }
    }

    /**
     * Returns equipment that the user has rented.
     * @param equipment The equipment to return.
     */
    public void returnEquipment(Equipment equipment) {
        if (rentedEquipment.remove(equipment)) {
            equipment.returnEquipment();
            System.out.println(equipment.getName() + " has been returned by " + this.getName() + ".");
        } else {
            System.out.println("Equipment not found in " + this.getName() + "'s rented equipment.");
        }
    }

    /**
     * Prints the rented items by the user.
     */
    public void printRentedItems() {
        System.out.println("\nUser: " + username);
        System.out.println("Rented Vehicles:");
        for (Vehicle vehicle : rentedVehicles) {
            vehicle.print();
        }
        System.out.println("Rented Equipment:");
        for (Equipment equipment : rentedEquipment) {
            equipment.print();
        }
    }
}
