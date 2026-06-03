import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarehouseCompletionService {
    private static final int MAX_WEIGHT = 150;
    private static final int LOADERS_COUNT = 3;
    private static final int TOTAL_GOODS = 10;

    static class Good {
        int weight;
        String name;

        Good(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    static class LoaderTask implements Callable<Integer> {
        private final int id;
        private final List<Good> goods;
        private int totalWeight = 0;

        LoaderTask(int id, List<Good> goods) {
            this.id = id;
            this.goods = goods;
        }

        @Override
        public Integer call() {
            int weightCarried = 0;
            List<Good> carried = new ArrayList<>();

            for (Good good : goods) {
                if (weightCarried + good.weight <= MAX_WEIGHT) {
                    weightCarried += good.weight;
                    carried.add(good);
                    System.out.println("Грузчик " + id + " взял " + good.name + " (вес " + good.weight + " кг)");
                }
            }

            System.out.println("Грузчик " + id + " унёс " + weightCarried + " кг. Товаров: " + carried.size());
            return weightCarried;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Good> warehouse = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= TOTAL_GOODS; i++) {
            warehouse.add(new Good("Товар" + i, rand.nextInt(30) + 10));
        }

        System.out.println("=== Склад готов. Товаров: " + warehouse.size() + " ===\n");

        ExecutorService executor = Executors.newFixedThreadPool(LOADERS_COUNT);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 1; i <= LOADERS_COUNT; i++) {
            completionService.submit(new LoaderTask(i, warehouse));
        }

        int totalTransferred = 0;
        for (int i = 0; i < LOADERS_COUNT; i++) {
            Future<Integer> result = completionService.take();
            totalTransferred += result.get();
        }

        executor.shutdown();
        System.out.println("\n=== Всего перенесено: " + totalTransferred + " кг ===");
    }
}
