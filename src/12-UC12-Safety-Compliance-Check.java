import java.util.*;

class GoodsBogie {
    String type;
    String cargo;
    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
    @Override
    public String toString() {
        return type + " carrying " + cargo;
    }
}

public class UC12_Safety_Compliance_Check {
    public static void main(String[] args) {
        List<GoodsBogie> bogies = Arrays.asList(
            new GoodsBogie("Cylindrical", "Petroleum"),
            new GoodsBogie("Rectangular", "Coal"),
            new GoodsBogie("Cylindrical", "Petroleum"),
            new GoodsBogie("Box", "Grain")
        );

        System.out.println("Goods Bogies: " + bogies);

        boolean isSafe = bogies.stream()
            .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT.");
        } else {
            System.out.println("Train is NOT SAFETY COMPLIANT!");
        }
    }
}
