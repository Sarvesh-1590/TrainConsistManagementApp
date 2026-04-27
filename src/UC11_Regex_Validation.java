import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UC11_Regex_Validation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Define regex patterns
        String trainIdPattern = "TRN-\\d{4}";
        String cargoCodePattern = "PET-[A-Z]{2}";
        Pattern trainPattern = Pattern.compile(trainIdPattern);
        Pattern cargoPattern = Pattern.compile(cargoCodePattern);

        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainId = scanner.nextLine();
        Matcher trainMatcher = trainPattern.matcher(trainId);
        if (trainMatcher.matches()) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Invalid Train ID format.");
        }

        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);
        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Invalid Cargo Code format.");
        }
    }
}
