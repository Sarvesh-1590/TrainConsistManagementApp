import java.util.Arrays;

public class UseCase20TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Exception Handling in Search ===\n");

        String[] emptyList = {};
        String[] twoElementsList = {"BG101", "BG205"};
        String[] standardList = {"BG101", "BG205", "BG309"};
        String[] singleList = {"BG101"};

        // Test Case 1: Exception When Empty Data
        runTestCase("Throws Exception When Empty", emptyList, "BG101");

        // Test Case 2: Search Allowed When Data Exists
        runTestCase("Allows Search When Data Exists", twoElementsList, "BG101");

        // Test Case 3: Bogie Found After Validation
        runTestCase("Bogie Found After Validation", standardList, "BG205");

        // Test Case 4: Bogie Not Found After Validation
        runTestCase("Bogie Not Found After Validation", standardList, "BG999");

        // Test Case 5: Single Element Valid Case
        runTestCase("Single Element Valid Case", singleList, "BG101");
    }

    private static void runTestCase(String testName, String[] arr, String target) {
        System.out.println("--- Test: " + testName + " ---");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Searching for: " + target);

        try {
            boolean found = searchBogie(arr, target);
            System.out.println("Result: " + (found ? "Found" : "Not Found") + "\n");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    /**
     * Helper method to search array using defensive programming.
     * Throws IllegalStateException immediately if the array is empty.
     */
    public static boolean searchBogie(String[] arr, String target) {
        // Fail-Fast: State validation
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Cannot search: Train consist is empty.");
        }
        
        // Normal Array Processing
        for (String bogie : arr) {
            if (bogie.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
