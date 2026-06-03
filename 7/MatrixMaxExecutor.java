import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMaxExecutor {
    private static int globalMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {3, 8, 2, 5},
                {1, 9, 4, 7},
                {6, 2, 10, 3},
                {5, 1, 2, 8},
                {7, 4, 9, 6}
        };

        int rows = matrix.length;
        int numberOfThreads = 3;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        int rowsPerThread = rows / numberOfThreads;

        for (int t = 0; t < numberOfThreads; t++) {
            int startRow = t * rowsPerThread;
            int endRow = (t == numberOfThreads - 1) ? rows : (t + 1) * rowsPerThread;

            final int start = startRow;
            final int end = endRow;

            executor.submit(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int i = start; i < end; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j] > localMax) {
                            localMax = matrix[i][j];
                        }
                    }
                }
                synchronized (MatrixMaxExecutor.class) {
                    if (localMax > globalMax) {
                        globalMax = localMax;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " обработал строки " + start + "-" + (end-1) + " -> максимум: " + localMax);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}
