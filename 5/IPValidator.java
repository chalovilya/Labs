import java.util.Scanner;
import java.util.regex.*;

public class IPValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] testIPs = {
                "192.168.1.1",
                "0.0.0.0",
                "255.255.255.255",
                "256.1.1.1",
                "192.168.1",
                "192.168.1.1.1",
                "abc.def.ghi.jkl",
                "192.168.1.-1",
                "01.02.03.04",
                "255.0.255.0"
        };

        for (String ip : testIPs) {
            System.out.println("IP-адрес: \"" + ip + "\"");
            System.out.println("Результат: " + (isValidIP(ip) ? "Корректен ✓" : "Некорректен ✗"));
            System.out.println("-".repeat(40));
        }

        System.out.println("\n--- Интерактивный режим ---");
        System.out.print("Введите IP-адрес для проверки (или 'exit' для выхода): ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (isValidIP(input)) {
                System.out.println("✓ IP-адрес корректен!");
            } else {
                System.out.println("✗ IP-адрес некорректен!");
                System.out.println("IP-адрес должен иметь формат: X.X.X.X, где X от 0 до 255");
            }
            System.out.print("Введите IP-адрес для проверки: ");
        }

        scanner.close();
    }

    public static boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        try {

            String octet = "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])";
            String ipPattern = "^" + octet + "\\." + octet + "\\." + octet + "\\." + octet + "$";

            Pattern pattern = Pattern.compile(ipPattern);
            Matcher matcher = pattern.matcher(ip);
            return matcher.matches();
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            return false;
        }
    }

    public static boolean isValidIPAlternative(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String ipPattern = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            for (int i = 1; i <= 4; i++) {
                int octet = Integer.parseInt(matcher.group(i));
                if (octet < 0 || octet > 255) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
