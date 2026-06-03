import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArraySumExecutor {
    private static int totalSum = 0;

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int numberOfThreads = 4;  // 4 потока в пуле
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        int partSize = array.length / numberOfThreads;  // 100 / 4 = 25 элементов на поток

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * partSize;
            int end = (i == numberOfThreads - 1) ? array.length : (i + 1) * partSize;

            executor.submit(() -> {
                int localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                synchronized (ArraySumExecutor.class) {
                    totalSum += localSum;
                }
                System.out.println(Thread.currentThread().getName() + " посчитал сумму: " + localSum);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Общая сумма массива: " + totalSum);
    }
}
