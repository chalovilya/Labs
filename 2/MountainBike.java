public class MountainBike extends Bicycle {
    private boolean hasSuspension;
    private double frameWeight;

    public MountainBike(String brand, int wheelSize, int gearCount, boolean hasSuspension, double frameWeight) {
        super(brand, wheelSize, gearCount);
        this.hasSuspension = hasSuspension;
        this.frameWeight = frameWeight;
    }

    public MountainBike() {
        super();
        this.hasSuspension = true;
        this.frameWeight = 14.5;
    }

    public boolean isHasSuspension() {
        return hasSuspension;
    }

    public void setHasSuspension(boolean hasSuspension) {
        this.hasSuspension = hasSuspension;
    }

    public double getFrameWeight() {
        return frameWeight;
    }

    public void setFrameWeight(double frameWeight) {
        this.frameWeight = frameWeight;
    }

    @Override
    public void ride() {
        System.out.println("Еду на горном велосипеде по бездорожью! Отлично держит неровности.");
    }

    @Override
    public String getBikeType() {
        return "Горный велосипед";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Амортизация: " + (hasSuspension ? "Есть" : "Нет"));
        System.out.println("Вес рамы: " + frameWeight + " кг");
    }

    public void ride(String terrain) {
        System.out.println("Еду на горном велосипеде по " + terrain + "! Амортизация работает отлично.");
    }
}
