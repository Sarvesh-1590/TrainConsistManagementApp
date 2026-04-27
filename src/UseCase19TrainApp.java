import java.util.Arrays;

public class UseCase19TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Binary Search ===\n");

        String[] standardList = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String[] singleList = {"BG101"};
        String[] emptyList = {};
        String[] unsortedList = {"BG309", "BG101", "BG550", "BG205", "BG412"};

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

        // Test Case 6: Empty Array
        runTestCase("Empty Array Handling", emptyList, "BG101");

        // Test Case 7: Unsorted Input Handling
        runTestCase("Unsorted Input Handling", unsortedList, "BG205");
    }

    private static void runTestCase(String testName, String[] arr, String target) {
        System.out.println("--- Test: " + testName + " ---");
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Searching for: " + target);

        // Precondition: Binary search requires sorted data.
        if (!isSorted(arr)) {
            System.out.println("Array is unsorted. Sorting before applying Binary Search...");
            Arrays.sort(arr);
            System.out.println("Sorted Array: " + Arrays.toString(arr));
        }

        boolean found = binarySearch(arr, target);
        System.out.println("Result: " + (found ? "Found" : "Not Found") + "\n");
    }

    /**
     * Helper method to check if the array is sorted.
     */
    private static boolean isSorted(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Performs an optimized binary search on a sorted array of standard strings.
     */
    public static boolean binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents overflow
            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                return true; // Match found
            } else if (cmp < 0) {
                low = mid + 1; // Key is in the right half
            } else {
                high = mid - 1; // Key is in the left half
            }
        }
        
        return false; // Exhausted search space
    }
}
