import java.util.List;
import java.util.ArrayList;

public class Order {
    private List<String> dishes;
    private double cost;
    private String time;

    public Order(List<String> dishes, double cost, String time) {
        this.dishes = new ArrayList<>(dishes);
        this.cost = cost;
        this.time = time;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public void setDishes(List<String> dishes) {
        this.dishes = new ArrayList<>(dishes);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{dishes=" + dishes + ", cost=" + cost + ", time='" + time + "'}";
    }
}
