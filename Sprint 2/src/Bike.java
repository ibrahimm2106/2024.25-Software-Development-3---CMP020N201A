public class Bike extends Vehicle {
    private boolean hasGears;

    public Bike(String id, String name, int maxSpeed, double rentalPrice, boolean hasGears) {
        super(id, name, "Bike", maxSpeed, rentalPrice, "N/A"); // Bikes typically don't have a specific fuel type, assuming "N/A"
        this.hasGears = hasGears;
    }

    @Override
    public void print() {
        super.printDetails();
        System.out.println("Has Gears: " + hasGears);
    }
}
