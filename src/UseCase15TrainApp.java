class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = "Empty";
    }

    public void assignCargo(String newCargo) {
        if (shape.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("Cannot assign Petroleum to a Rectangular bogie due to safety constraints.");
        }
        this.cargo = newCargo;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }
}

public class UseCase15TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Safe Cargo Assignment ===\n");

        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // Test Case 1: Safe Assignment
        System.out.println("Attempting to assign: Coal to " + bogie.getShape() + " bogie.");
        try {
            bogie.assignCargo("Coal");
            System.out.println("Success: Cargo securely assigned.");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("[Finally Block] Assignment operation attempt completed for Coal.\n");
        }

        // Test Case 2: Unsafe Assignment
        System.out.println("Attempting to assign: Petroleum to " + bogie.getShape() + " bogie.");
        try {
            bogie.assignCargo("Petroleum");
            System.out.println("Success: Cargo securely assigned.");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("[Finally Block] Assignment operation attempt completed for Petroleum.\n");
        }

        System.out.println("System Check: The program continues executing normally after handling exceptions.");
    }
}
