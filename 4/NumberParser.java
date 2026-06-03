import java.util.Scanner;

public class NumberParser {
    public static int parseToInt(String input) throws CustomNumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            CustomNumberFormatException customException =
                    new CustomNumberFormatException("Некорректный формат числа: '" + input + "'", e);
            ExceptionLogger.log(customException);
            throw customException;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        String userInput = scanner.nextLine();

        try {
            int result = parseToInt(userInput);
            System.out.println("Успешно преобразовано: " + result);
        } catch (CustomNumberFormatException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        scanner.close();
    }
}
