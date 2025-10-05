package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void testSort() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort.sort(arr);
        int[] expected = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testEmptyArray() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = {};
        heapSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSingleElement() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = {5};
        heapSort.sort(arr);
        int[] expected = {5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testWithDuplicates() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = {3, 1, 2, 3, 2, 1};
        heapSort.sort(arr);
        int[] expected = {1, 1, 2, 2, 3, 3};
        assertArrayEquals(expected, arr);
    }

    // **Cross-Validation with Java's Built-in Sorting**
    @Test
    public void testCrossValidation() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = generateRandomArray(1000); // Example size 1000
        int[] arrCopy = arr.clone();  // Create a copy to use with Arrays.sort()

        heapSort.sort(arr);
        Arrays.sort(arrCopy);

        // Compare the results
        assertArrayEquals(arrCopy, arr);
    }

    // **Test for Random Data**
    @Test
    public void testWithRandomData() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = generateRandomArray(1000); // Example size 1000
        heapSort.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]); // Check if array is sorted
        }
    }

    // **Test for Sorted Data**
    @Test
    public void testWithSortedData() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = {1, 2, 3, 4, 5, 6}; // Already sorted
        heapSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, arr);
    }

    // **Test for Reverse-Sorted Data**
    @Test
    public void testWithReverseSortedData() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = {6, 5, 4, 3, 2, 1}; // Reverse sorted
        heapSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, arr);
    }

    // **Test for Nearly-Sorted Data**
    @Test
    public void testWithNearlySortedData() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = generateRandomArray(1000);
        arr[500] = 999; // Example: only one element is out of order
        heapSort.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            assertTrue(arr[i - 1] <= arr[i]); // Check if array is sorted
        }
    }

    // **Performance Test**
    @Test
    public void testPerformance() {
        HeapSort heapSort = new HeapSort(new PerformanceTracker());  // Передаем PerformanceTracker
        int[] arr = new int[1000000];  // 1 million elements
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);  // Random numbers
        }
        long startTime = System.nanoTime();
        heapSort.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Time to sort 1 million elements: " + (endTime - startTime) + " nanoseconds");
    }

    // Utility method to generate random arrays
    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100000);  // Random values between 0 and 100000
        }
        return arr;
    }
}
