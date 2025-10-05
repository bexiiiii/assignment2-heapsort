package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long memoryAllocations;

    public PerformanceTracker() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }

    // Методы для инкрементации счетчиков
    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }
    public void incrementArrayAccesses() { arrayAccesses++; }
    public void incrementMemoryAllocations() { memoryAllocations++; }

    // Методы для получения значений счетчиков
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getMemoryAllocations() { return memoryAllocations; }

    // Метод для вывода всех метрик
    public void report() {
        System.out.println("Performance Metrics:");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array accesses: " + arrayAccesses);
        System.out.println("Memory allocations: " + memoryAllocations);
    }
}
