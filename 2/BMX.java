public class BMX extends Bicycle {
    private String style;
    private boolean hasPegs;

    public BMX(String brand, int wheelSize, int gearCount, String style, boolean hasPegs) {
        super(brand, wheelSize, gearCount);
        this.style = style;
        this.hasPegs = hasPegs;
    }

    public BMX() {
        super();
        this.style = "street";
        this.hasPegs = false;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isHasPegs() {
        return hasPegs;
    }

    public void setHasPegs(boolean hasPegs) {
        this.hasPegs = hasPegs;
    }

    @Override
    public void ride() {
        System.out.println("Делаю трюки на BMX! Tailwhip, barspin, 360!");
    }

    @Override
    public String getBikeType() {
        return "BMX";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Стиль катания: " + style);
        System.out.println("Пеги: " + (hasPegs ? "Есть" : "Нет"));
    }

    public void ride(String trick) {
        System.out.println("Выполняю трюк на BMX: " + trick + "!");
    }
}
