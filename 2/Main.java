public class Main {
    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike("Trek", 27, 21, true, 13.5);
        KidsBike kidsBike =
                new KidsBike("Puky", 16, 1, 4, true);
        BMX bmx = new BMX("Haro", 20, 1, "park", true);

        mountainBike.displayInfo();
        System.out.println();
        kidsBike.displayInfo();
        System.out.println();
        bmx.displayInfo();
        System.out.println();

        System.out.println("=== Переопределение методов ===");
        mountainBike.ride();
        kidsBike.ride();
        bmx.ride();
        System.out.println();

        System.out.println("=== Перегрузка методов ===");
        mountainBike.ride("горной тропе");
        kidsBike.ride("парке");
        bmx.ride("барспин");
        System.out.println();

        System.out.println("=== Геттеры и сеттеры ===");
        System.out.println("Бренд: " + mountainBike.getBrand());
        mountainBike.setBrand("Specialized");
        System.out.println("Новый бренд: " + mountainBike.getBrand());
        System.out.println();

        System.out.println("=== Статический счетчик ===");
        System.out.println("Всего создано велосипедов: " + Bicycle.getTotalBicycles());
        System.out.println();

        System.out.println("=== Массив велосипедов ===");
        Bicycle[] bikes = {mountainBike, kidsBike, bmx};
        for (Bicycle bike : bikes) {
            System.out.println(bike.toString());
            bike.ride();
            System.out.println();
        }

        System.out.println("=== Upcasting и Downcasting ===");
        Bicycle upcastedBike = mountainBike;
        System.out.println("Upcasting: " + upcastedBike.getBikeType());

        if (upcastedBike instanceof MountainBike) {
            MountainBike downcastedBike = (MountainBike) upcastedBike;
            System.out.println("Downcasting: " + downcastedBike.getBikeType());
            System.out.println("Вес рамы: " + downcastedBike.getFrameWeight() + " кг");
        }
    }
}
