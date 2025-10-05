package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils;

public class BenchmarkRunner {

    public static void main(String[] args) {
        // Array sizes for testing
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        // Arrays to store data for the graph
        long[] times = new long[sizes.length];
        long[] comparisons = new long[sizes.length];
        long[] swaps = new long[sizes.length];
        long[] arrayAccesses = new long[sizes.length];

        System.out.println("Benchmark Results:");

        // Loop through all array sizes
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            int[] arr = generateRandomArray(size);

            // Start timer
            long startTime = System.nanoTime();
            heapSort.sort(arr);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            times[i] = duration;
            comparisons[i] = tracker.getComparisons();
            swaps[i] = tracker.getSwaps();
            arrayAccesses[i] = tracker.getArrayAccesses();

            // Output results to console
            System.out.println("Array size: " + size + " | Time taken to sort: " + duration + " nanoseconds");
            System.out.println("Comparisons: " + comparisons[i]);
            System.out.println("Swaps: " + swaps[i]);
            System.out.println("Array accesses: " + arrayAccesses[i]);

            // Reset metrics after each measurement
            tracker = new PerformanceTracker();
            heapSort = new HeapSort(tracker);
        }

        // Create graph and save it as an image
        createGraph(sizes, times, comparisons, swaps, arrayAccesses);

        // Save benchmark results to CSV
        saveResultsToCSV(sizes, times, comparisons, swaps, arrayAccesses);
    }

    // Generate random array
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);  // random number between 0 and 100000
        }
        return arr;
    }

    // Save benchmark results to CSV
    private static void saveResultsToCSV(int[] sizes, long[] times, long[] comparisons, long[] swaps, long[] arrayAccesses) {
        File file = new File("benchmark_results.csv"); // Saving to the root directory
        try (FileWriter writer = new FileWriter(file)) {
            // Write CSV header
            writer.append("Array Size, Time (nanoseconds), Comparisons, Swaps, Array Accesses\n");

            // Write data for each benchmark
            for (int i = 0; i < sizes.length; i++) {
                writer.append(sizes[i] + "," + times[i] + "," + comparisons[i] + "," + swaps[i] + "," + arrayAccesses[i] + "\n");
            }

            System.out.println("Benchmark results saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving benchmark results to CSV: " + e.getMessage());
        }
    }

    // Create graph and save it as an image
    private static void createGraph(int[] sizes, long[] times, long[] comparisons, long[] swaps, long[] arrayAccesses) {
        // Create chart using JFreeChart
        JFreeChart chart = ChartFactory.createLineChart(
                "HeapSort Performance", // Chart title
                "Array Size", // X-axis label
                "Time (nanoseconds)", // Y-axis label
                createDataset(sizes, times, comparisons, swaps, arrayAccesses), // Data for the chart
                PlotOrientation.VERTICAL, // Plot orientation
                true, // Show legend
                true, // Tooltips
                false // URLs
        );

        // Save chart as a PNG image in the root directory
        File file = new File("HeapSort_Performance.png");

        try {
            // Save chart as PNG image
            ChartUtils.saveChartAsPNG(file, chart, 800, 600);
            System.out.println("Chart saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving chart: " + e.getMessage());
        }
    }

    // Create dataset for the chart
    private static DefaultCategoryDataset createDataset(int[] sizes, long[] times, long[] comparisons, long[] swaps, long[] arrayAccesses) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data to the dataset
        for (int i = 0; i < sizes.length; i++) {
            dataset.addValue(times[i], "Time", String.valueOf(sizes[i]));
            dataset.addValue(comparisons[i], "Comparisons", String.valueOf(sizes[i]));
            dataset.addValue(swaps[i], "Swaps", String.valueOf(sizes[i]));
            dataset.addValue(arrayAccesses[i], "Array Accesses", String.valueOf(sizes[i]));
        }

        return dataset;
    }
}
