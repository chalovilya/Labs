public class KidsBike extends Bicycle {
    private int ageRecommendation;
    private boolean hasTrainingWheels;

    public KidsBike(String brand, int wheelSize, int gearCount, int ageRecommendation, boolean hasTrainingWheels) {
        super(brand, wheelSize, gearCount);
        this.ageRecommendation = ageRecommendation;
        this.hasTrainingWheels = hasTrainingWheels;
    }

    public KidsBike() {
        super();
        this.ageRecommendation = 5;
        this.hasTrainingWheels = true;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    public void setAgeRecommendation(int ageRecommendation) {
        this.ageRecommendation = ageRecommendation;
    }

    public boolean isHasTrainingWheels() {
        return hasTrainingWheels;
    }

    public void setHasTrainingWheels(boolean hasTrainingWheels) {
        this.hasTrainingWheels = hasTrainingWheels;
    }

    @Override
    public void ride() {
        System.out.println("Еду на детском велосипеде! Безопасно и весело.");
    }

    @Override
    public String getBikeType() {
        return "Детский велосипед";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Рекомендуемый возраст: " + ageRecommendation + "+ лет");
        System.out.println("Дополнительные колеса: " + (hasTrainingWheels ? "Есть" : "Нет"));
    }

    public void ride(String location) {
        System.out.println("Катаюсь на детском велосипеде в " + location + "! Мама рядом.");
    }
}
