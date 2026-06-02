# Лабораторные работы по предмету "Кроссплатформенные технологии программирования"

**Студент:** Чалов Илья 
**Группа:** БСТ2403  

---

## Список работ

| № | Название | Описание | Папка |
|---|----------|----------|-------|
| 1 | Базовые алгоритмы | Простые числа, палиндромы | [/1](/1) |
| 2 | Объектно-ориентированное программирование | Иерархия классов "Сотрудники" | [/2](/2) |
| 3 | Хэш-таблицы | Учёт заказов в интернет-магазине | [/3](/3) |
| 4 | Обработка исключений | Среднее арифметическое, копирование файлов, деление на ноль | [/4](/4) |
| 5 | Регулярные выражения | Поиск чисел, проверка пароля, IP-адресов, слов по букве | [/5](/5) |
| 6 | Коллекции | Топ-10 слов, стек, учёт продаж | [/6](/6) |
| 7 | Многопоточность | Сумма массива, чётные/нечётные числа, барьер грузчиков | [/7](/7) |
| 8 | Аннотации и рефлексия | Многопоточная обработка данных с аннотациями | [/8](/8) |

---

## Как запустить любую работу

1. Перейдите в папку нужной лабораторной работы:
   ```bash
   cd 1
2. Скомпилируйте все файлы:
    ```bash
    javac *.java
3. Запустите нужный класс:
    ```bash
    java Primes

---

## Структура репозитория

```text
Labs/
├── README.md
├── .gitignore
├── 1/
│   ├── Primes.java
│   ├── Palindrome.java
│   └── README.md
├── 2/
│   ├── Bicycle.java
│   ├── BMX.java
│   ├── KidsBike.java
│   ├── MountainBike.java
│   ├── Main.java
│   └── README.md
├── 3/
│   ├── HashTable.java
│   ├── Order.java
│   ├── Entry.java
│   ├── Main.java
│   └── README.md
├── 4/
│   ├── ArrayAverage.java
│   ├── FileCopy.java
│   ├── CustomNumberFormatException.java
│   ├── NumberParser.java
│   ├── ExceptionLogger.java
│   └── README.md
├── 5/
│   ├── NumberFinder.java
│   ├── PasswordValidator.java
│   ├── CapitalAfterLowercaseFinder.java
│   ├── IPValidator.java
│   ├── WordsStartingWithLetter.java
│   └── README.md
├── 6/
│   ├── TopWords.java
│   ├── MyStack.java
│   ├── SalesTracker.java
│   └── README.md
├── 7/
│   ├── ArraySumExecutor.java
│   ├── MatrixMaxExecutor.java
│   ├── WarehouseCompletionService.java
│   └── README.md
└── 8/
    ├── DataProcessor.java
    ├── FilterProcessor.java
    ├── UpperCaseProcessor.java
    ├── ReverseProcessor.java
    ├── DataManager.java
    ├── Main.java
    └── README.md
