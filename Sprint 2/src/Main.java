public class Main {
    public static void main(String[] args) {
        // Get the Singleton instance of Inventory
        Inventory inventory = Inventory.getInstance();

        // Correctly initializing vehicles
        Vehicle bike = new Bike("B001", "Mountain Bike", 25, 15.0, true);
        Vehicle scooter = new Scooter("S001", "Electric Scooter", 30, 20.0, true);
        Vehicle skateboard = new Skateboard("SK002", "Maple Skateboard", 10, 5.0, "Wood");

        // Adding vehicles to inventory
        inventory.addVehicle(bike);
        inventory.addVehicle(scooter);
        inventory.addVehicle(skateboard);

        // Add equipment to inventory
        Equipment helmet = new Equipment("Helmet");
        Equipment kneePads = new Equipment("Knee Pads");
        inventory.addEquipment(helmet);
        inventory.addEquipment(kneePads);

        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // Demonstrate renting vehicles and equipment
        System.out.println("\n=== Renting Items ===");
        alice.rentVehicle(bike);  // Alice rents a bike
        bob.rentVehicle(scooter); // Bob rents a scooter
        charlie.rentVehicle(skateboard); // Charlie rents a skateboard
        alice.rentEquipment(helmet);  // Alice rents a helmet
        charlie.rentEquipment(kneePads); // Charlie rents knee pads

        // Print inventory after renting
        System.out.println("\n=== Inventory After Renting ===");
        inventory.printInventory();

        // Returning items
        System.out.println("\n=== Returning Items ===");
        alice.returnVehicle(bike);
        alice.returnEquipment(helmet);
        charlie.returnVehicle(skateboard);
        charlie.returnEquipment(kneePads);
        bob.returnVehicle(scooter);

        // Print inventory after returning
        System.out.println("\n=== Inventory After Returning ===");
        inventory.printInventory();
    }
}
