import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] testPasswords = {
                "Password123",
                "pass123",
                "PASSWORD",
                "Pass1",
                "VeryLongPassword123456789",
                "Pass@word123",
                "Abc12345",
                "A1"
        };

        for (String password : testPasswords) {
            System.out.println("Пароль: \"" + password + "\"");
            System.out.println("Результат: " + (isValidPassword(password) ? "Корректен ✓" : "Некорректен ✗"));
            System.out.println("-".repeat(40));
        }

        System.out.println("\n--- Интерактивный режим ---");
        System.out.print("Введите пароль для проверки (или 'exit' для выхода): ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (isValidPassword(input)) {
                System.out.println("✓ Пароль корректен!");
            } else {
                System.out.println("✗ Пароль некорректен!");
                printPasswordRequirements();
            }
            System.out.print("Введите пароль для проверки: ");
        }

        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            return false;
        }
    }

    public static void printPasswordRequirements() {
        System.out.println("Требования к паролю:");
        System.out.println("- Длина от 8 до 16 символов");
        System.out.println("- Только латинские буквы и цифры");
        System.out.println("- Содержит хотя бы одну заглавную букву");
        System.out.println("- Содержит хотя бы одну цифру");
    }
}
