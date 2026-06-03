# Лабораторная работа №4: Обработка исключений (Вариант 2, Вариант 4)

## Задание 1: ArrayAverage.java
Вычисление среднего арифметического элементов массива. Пользователь вводит размер и элементы через пробел.

- **NumberFormatException** – если введено не число
- **ArrayIndexOutOfBoundsException** – если введено меньше чисел, чем нужно

## Задание 2: FileCopy.java (Вариант 2)
Копирование файла source.txt в destination.txt. Чтение и запись по одному символу.

- **FileNotFoundException** – если исходный файл не найден
- **IOException** – ошибки чтения и записи файлов
- Потоки закрываются в finally с проверкой на null

## Задание 3: DivisionProgram.java + CustomNumberFormatException.java (Вариант 4)
Деление двух чисел. При вводе не числа выбрасывается собственное исключение CustomNumberFormatException.

- Создан класс исключения `CustomNumberFormatException`, наследуемый от Exception
- Метод `log()` записывает ошибки в exceptions_log.txt (режим дозаписи)
- Обрабатывается также деление на ноль (ArithmeticException)

## Запуск
```bash
java ArrayAverage
java FileCopy
java DivisionProgram
