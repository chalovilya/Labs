import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, Order> restaurantOrders = new HashTable<>();

        // Заказы по номерам столиков
        Order order1 = new Order(Arrays.asList("Паста", "Салат"), 25.50, "12:30");
        Order order2 = new Order(Arrays.asList("Пицца", "Кола"), 18.00, "13:15");
        Order order3 = new Order(Arrays.asList("Суп", "Чай"), 12.00, "14:00");

        // Вставка
        restaurantOrders.put(5, order1);
        restaurantOrders.put(8, order2);
        restaurantOrders.put(5, order3); // столик 5 — обновляем заказ

        System.out.println("Таблица после вставки:");
        restaurantOrders.printTable();

        // Поиск
        System.out.println("\nПоиск столика 8: " + restaurantOrders.get(8));
        System.out.println("Поиск столика 5: " + restaurantOrders.get(5));

        // Удаление
        System.out.println("\nУдаляем столик 8: " + restaurantOrders.remove(8));
        System.out.println("Размер после удаления: " + restaurantOrders.size());

        System.out.println("\nТаблица после удаления:");
        restaurantOrders.printTable();

        System.out.println("Пуста ли таблица? " + restaurantOrders.isEmpty());
    }
}
