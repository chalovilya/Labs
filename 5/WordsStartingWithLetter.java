import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class WordsStartingWithLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "Java is a powerful programming language. Java developers write object-oriented code. " +
                "JavaScript is another popular language. Just learn Java and JavaScript. " +
                "JUnit is for testing, while Jenkins is for CI/CD.";

        System.out.println("Исходный текст:");
        System.out.println(text);
        System.out.println("-".repeat(60));

        // Тестовые сценарии
        char[] testLetters = {'J', 'a', 'p', 'l', 'z'};

        for (char letter : testLetters) {
            System.out.println("\nСлова, начинающиеся с буквы '" + letter + "':");
            List<String> words = findWordsStartingWith(text, letter);
            if (words.isEmpty()) {
                System.out.println("  (не найдено)");
            } else {
                for (String word : words) {
                    System.out.println("  - " + word);
                }
            }
            System.out.println("  Всего найдено: " + words.size());
        }

        // Интерактивный режим
        System.out.println("\n--- Интерактивный режим ---");
        while (true) {
            System.out.print("\nВведите букву для поиска (или 'exit' для выхода): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Пожалуйста, введите одну букву!");
                continue;
            }

            char letter = input.charAt(0);
            List<String> foundWords = findWordsStartingWith(text, letter);

            if (foundWords.isEmpty()) {
                System.out.println("Слова, начинающиеся с буквы '" + letter + "', не найдены.");
            } else {
                System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
                for (String word : foundWords) {
                    System.out.println("  - " + word);
                }
                System.out.println("Всего найдено: " + foundWords.size());
            }
        }

        scanner.close();
    }

    public static List<String> findWordsStartingWith(String text, char letter) {
        List<String> words = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return words;
        }

        try {
            Pattern pattern = Pattern.compile("\\b[" + Character.toUpperCase(letter) + Character.toLowerCase(letter) + "][A-Za-z]*\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                words.add(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        }

        return words;
    }

    public static List<String> findWordsStartingWithCaseSensitive(String text, char letter) {
        List<String> words = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return words;
        }

        try {
            Pattern pattern = Pattern.compile("\\b[" + letter + "][A-Za-z]*\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                words.add(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        }

        return words;
    }

    public static List<String> findWordsStartingWithInText(String text, char letter) {
        List<String> words = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return words;
        }

        try {
            Pattern pattern = Pattern.compile("\\b[" + Character.toUpperCase(letter) + Character.toLowerCase(letter) + "][A-Za-z']*\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String word = matcher.group();
                word = word.replaceAll("'+$", "");
                words.add(word);
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        }

        return words;
    }
}
