import java.util.Arrays;

public class UseCase18TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Linear Search ===\n");

        String[] standardList = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String[] singleList = {"BG101"};

        // Test Case 1: Search Match Found
        runTestCase("Bogie Found", standardList, "BG309");

        // Test Case 2: Search Match Not Found
        runTestCase("Bogie Not Found", standardList, "BG999");

        // Test Case 3: First Element Match
        runTestCase("First Element Match", standardList, "BG101");

        // Test Case 4: Last Element Match
        runTestCase("Last Element Match", standardList, "BG550");

        // Test Case 5: Single Element Match
        runTestCase("Single Element Match", singleList, "BG101");
    }

    private static void runTestCase(String testName, String[] arr, String target) {
        System.out.println("--- Test: " + testName + " ---");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Searching for: " + target);

        boolean found = linearSearch(arr, target);
        
        System.out.println("Result: " + (found ? "Found" : "Not Found") + "\n");
    }

    /**
     * Performs a sequential linear search on an array of standard strings.
     */
    public static boolean linearSearch(String[] arr, String target) {
        for (String element : arr) {
            if (element.equals(target)) {
                return true; // Early termination on match
            }
        }
        return false;
    }
}
