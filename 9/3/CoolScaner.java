import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoolScaner{
    public static void main(String[] args) {
        try {
            // Создаем объект Scanner, считывающий из файла "input.txt"
            Scanner fileScanner = new Scanner(new File("input.txt"));

            // Читаем файл построчно
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close(); // Закрытие сканера после использования
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}