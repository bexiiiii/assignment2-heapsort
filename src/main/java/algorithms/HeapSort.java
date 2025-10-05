package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {

    private PerformanceTracker tracker;

    // Constructor to initialize the PerformanceTracker
    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // Build heap using bottom-up heapify
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);  // Move root to the end
            heapify(arr, i, 0);  // Heapify the reduced heap
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
            tracker.incrementComparisons();
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
            tracker.incrementComparisons();
        }

        if (largest != i) {
            swap(arr, i, largest);
            tracker.incrementSwaps();  // Increment swap count

            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        tracker.incrementArrayAccesses();  // Increment array access count
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
