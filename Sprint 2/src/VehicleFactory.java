public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "bike":
                return new Bike("B001", "EcoBike", 3.5, "21-speed");
            case "scooter":
                return new Scooter("S001", "SuperScoot", 5.0, 300);
            case "segway":
                return new Segway("SG001", "Ninebot", 6.0, "Gyroscopic");
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
