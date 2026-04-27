import java.util.Arrays;

public class UseCase16TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Bubble Sort Algorithm ===\n");

        // Test Cases Arrays
        int[] basicUnsorted = {72, 56, 24, 70, 60};
        int[] alreadySorted = {24, 56, 60, 70, 72};
        int[] duplicateVals = {72, 56, 56, 24};
        int[] singleElement = {50};
        int[] allEqualVals = {40, 40, 40};

        // Execute tests
        runTestCase("Basic Unsorted Array", basicUnsorted);
        runTestCase("Already Sorted Array", alreadySorted);
        runTestCase("Duplicate Values Handling", duplicateVals);
        runTestCase("Single Element Array", singleElement);
        runTestCase("All Equal Values Array", allEqualVals);
    }

    private static void runTestCase(String testName, int[] arr) {
        System.out.println("--- Test: " + testName + " ---");
        System.out.println("Original Array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array:   " + Arrays.toString(arr) + "\n");
    }

    /**
     * Bubble Sort Algorithm
     * Manually sorts the integer array in ascending order without using Collections.sort()
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        // Nested loop processing for comparison and swapping
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap values when left element is greater than right element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: If no elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
