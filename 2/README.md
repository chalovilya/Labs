# Лабораторная работа №2: ООП (Вариант 5 – Велосипеды)

## Задание
Создать иерархию классов: Bicycle (абстрактный), MountainBike (Горный велосипед), KidsBike (Детский велосипед), BMX.

## Классы
- Bicycle – базовый класс с полями brand, wheelSize, price, статическим счётчиком totalBicycles. Содержит абстрактные методы ride() и getType(), геттеры/сеттеры, перегруженный метод printInfo().
- MountainBike – добавляет поля suspensionType, gearCount, frameMaterial. Переопределяет ride() и getType(). Имеет метод offroadRide().
- KidsBike – добавляет поля ageRange, hasTrainingWheels, color. Переопределяет ride() и getType(). Имеет метод removeTrainingWheels().
- BMX – добавляет поля rotationType, trickLevel, handlebarType. Переопределяет ride() и getType(). Имеет метод doTrick().

## Демонстрация ООП
- Абстракция: класс Bicycle абстрактный, методы ride() и getType() без реализации
- Инкапсуляция: поля private/protected, доступ через геттеры/сеттеры
- Наследование: дочерние классы расширяют Bicycle
- Полиморфизм: переопределение ride() и getType(), перегрузка printInfo(), массив Bicycle[]

Запуск: java Main
