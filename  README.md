# HeapSort Algorithm

## Overview

This project implements the **HeapSort** algorithm using the **in-place bottom-up heapify** method. It includes performance tracking, benchmark testing, and graphical representation of the algorithm's performance. The implementation tracks key operations such as comparisons, swaps, array accesses, and memory allocations. The project also includes a **CLI interface** to run the algorithm and gather performance metrics.

## Project Structure

assignment2-heapsort/
├── src/main/java/
│ ├── algorithms/HeapSort.java # Main HeapSort algorithm implementation
│ ├── metrics/PerformanceTracker.java # Metrics collection for comparisons, swaps, etc.
│ └── cli/BenchmarkRunner.java # CLI interface to run and benchmark the algorithm
├── src/test/java/
│ └── algorithms/HeapSortTest.java # Unit tests for the HeapSort algorithm
├── docs/
│ ├── analysis-report.pdf # Report analyzing the algorithm's performance
│ └── performance-plots/ # Folder containing performance plot images
├── README.md # Project overview, usage instructions, and analysis
└── pom.xml # Maven build configuration

markdown
Copy code

## Features

- **HeapSort Implementation**: A full implementation of HeapSort using bottom-up heapify.
- **Performance Metrics**: Tracks comparisons, swaps, array accesses, and memory allocations during sorting.
- **Benchmarking**: Collects performance data for different input sizes and saves the results to graphs.
- **JFreeChart Integration**: Generates performance graphs showing the time taken, number of comparisons, swaps, and array accesses for various input sizes.
- **Unit Tests**: Comprehensive unit tests to cover edge cases like empty arrays, single-element arrays, and arrays with duplicates.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/bexiiiii/assignment2-heapsort.git
    ```

2. Navigate to the project folder:
    ```bash
    cd assignment2-heapsort
    ```

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Run the benchmark tests:
    ```bash
    mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"
    ```

   This will run the **HeapSort** algorithm for different array sizes and generate performance data.

5. View the generated performance chart:
    - After running the benchmark tests, a **PNG** image of the performance graph will be saved in the `docs/performance-plots/` directory as **`HeapSort_Performance.png`**.

## Performance Analysis

The performance of the **HeapSort** algorithm is evaluated by measuring the time taken to sort arrays of different sizes. The results are saved and visualized in graphs showing:
- Time taken to sort
- Number of comparisons
- Number of swaps
- Number of array accesses

### Example Output

Benchmark Results:
Array size: 100 | Time taken to sort: 112458 nanoseconds
Comparisons: 682
Swaps: 489
Array accesses: 588

Array size: 1000 | Time taken to sort: 1544333 nanoseconds
Comparisons: 11664
Swaps: 8085
Array accesses: 9084

...



### Performance Plots

The performance plot for HeapSort will be saved in the `performance-plots/` folder, showing how the algorithm scales with increasing input sizes.



## Contact

For any questions or further information, feel free to contact [https://github.com/bexiiiii](https://github.com/bexiiiii).
