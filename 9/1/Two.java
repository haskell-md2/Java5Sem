import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Two {
    public static void main(String[] args) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // Запись одного байта — символа 'A'
            outputStream.write(65);
            // Запись одного байта — символа 'B'
            outputStream.write(66);
            
            // Получаем содержимое потока в виде массива байт
            byte[] data = outputStream.toByteArray();
            
            System.out.print("Содержимое потока: ");
            for (byte b : data) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
