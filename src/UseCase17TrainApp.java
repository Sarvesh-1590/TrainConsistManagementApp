import java.util.Arrays;

public class UseCase17TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Arrays.sort() ===\n");

        // Test Case 1: Basic Alphabetical Sorting
        String[] basicSorting = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        runTestCase("Basic Alphabetical Sorting", basicSorting);

        // Test Case 2: Unsorted Input Handling
        String[] unsortedInput = {"Luxury", "General", "Sleeper", "AC Chair"};
        runTestCase("Unsorted Input Handling", unsortedInput);

        // Test Case 3: Already Sorted Array
        String[] alreadySorted = {"AC Chair", "First Class", "General"};
        runTestCase("Already Sorted Array", alreadySorted);

        // Test Case 4: Duplicate Bogie Names
        String[] duplicateNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        runTestCase("Duplicate Bogie Names", duplicateNames);

        // Test Case 5: Single Element Array
        String[] singleElement = {"Sleeper"};
        runTestCase("Single Element Array", singleElement);
    }

    private static void runTestCase(String testName, String[] arr) {
        System.out.println("--- Test: " + testName + " ---");
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        // Sorting the array using Java's built-in optimized method
        Arrays.sort(arr);
        
        System.out.println("Sorted Array:   " + Arrays.toString(arr) + "\n");
    }
}
