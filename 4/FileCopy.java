import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл успешно скопирован из '" + sourceFile + "' в '" + destFile + "'");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Исходный файл не найден - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при чтении или записи файла: " + e.getMessage());
        }
    }
}
