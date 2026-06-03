import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class CapitalAfterLowercaseFinder {
    public static void main(String[] args) {
        // Тестовые тексты
        String[] testTexts = {
                "Hello World! This is a Test.",
                "aBc dEf gHi jKl",
                "I like Java Programming.",
                "small BIG smallBIG",
                "aA bB cC dD",
                "No matches here."
        };

        for (String text : testTexts) {
            System.out.println("Исходный текст: \"" + text + "\"");
            String result = highlightCapitalAfterLowercase(text);
            System.out.println("Результат:     \"" + result + "\"");
            System.out.println("-".repeat(60));
        }
    }

    public static String highlightCapitalAfterLowercase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        try {
            // Регулярное выражение:
            // [a-z] - строчная буква
            // ([A-Z]) - заглавная буква (захватываем в группу)
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);

            // Заменяем найденные совпадения, добавляя "!" с двух сторон
            // $1 - строчная буква, $2 - заглавная буква
            String result = matcher.replaceAll("$1!$2!");

            return result;
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            return text;
        }
    }

    // Метод для получения списка всех найденных позиций
    public static List<String> findMatches(String text) {
        List<String> matches = new ArrayList<>();

        if (text == null || text.isEmpty()) {
            return matches;
        }

        try {
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                matches.add(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        }

        return matches;
    }
}
