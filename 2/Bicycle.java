public abstract class Bicycle {
    private String brand;
    private int wheelSize;
    private int gearCount;
    private static int totalBicycles = 0;

    public Bicycle(String brand, int wheelSize, int gearCount) {
        this.brand = brand;
        this.wheelSize = wheelSize;
        this.gearCount = gearCount;
        totalBicycles++;
    }

    public Bicycle() {
        this("Unknown", 26, 1);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }

    public static int getTotalBicycles() {
        return totalBicycles;
    }

    public abstract void ride();

    public abstract String getBikeType();

    public void displayInfo() {
        System.out.println("=== Информация о велосипеде ===");
        System.out.println("Тип: " + getBikeType());
        System.out.println("Бренд: " + brand);
        System.out.println("Размер колес: " + wheelSize + "\"");
        System.out.println("Количество скоростей: " + gearCount);
    }

    @Override
    public String toString() {
        return getBikeType() + " [" + brand + ", колеса " + wheelSize + "\", " + gearCount + " скоростей]";
    }
} 
