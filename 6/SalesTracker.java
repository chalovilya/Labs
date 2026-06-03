import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SalesTracker {
    private CopyOnWriteArrayList<String> sales = new CopyOnWriteArrayList<>();

    public void addSale(String product) {
        sales.add(product);
    }

    public void printSales() {
        if (sales.isEmpty()) {
            System.out.println("Продаж нет.");
            return;
        }
        System.out.println("=== Список проданных товаров ===");
        for (String product : sales) {
            System.out.println("- " + product);
        }
    }

    public int totalItems() {
        return sales.size();
    }

    public String mostPopular() {
        if (sales.isEmpty()) return "нет продаж";

        Map<String, Integer> countMap = new HashMap<>();
        for (String product : sales) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }

        String best = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                best = entry.getKey();
            }
        }
        return best + " (" + maxCount + " шт.)";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesTracker tracker = new SalesTracker();

        System.out.println("=== Учёт продаж (CopyOnWriteArrayList) ===");
        System.out.println("Команды: add <товар>, list, total, popular, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            if (input.startsWith("add ")) {
                String product = input.substring(4);
                tracker.addSale(product);
                System.out.println("Продажа добавлена: " + product);
            } else if (input.equalsIgnoreCase("list")) {
                tracker.printSales();
            } else if (input.equalsIgnoreCase("total")) {
                System.out.println("Всего продано товаров: " + tracker.totalItems());
            } else if (input.equalsIgnoreCase("popular")) {
                System.out.println("Наиболее популярный товар: " + tracker.mostPopular());
            } else {
                System.out.println("Неизвестная команда. Доступные: add, list, total, popular, exit");
            }
        }

        scanner.close();
    }
}
