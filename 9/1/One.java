import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class One {
    public static void main(String[] args) {
        byte[] data = {65, 66, 67, 68}; // байты, соответствующие символам A, B, C, D
        InputStream inputStream = new ByteArrayInputStream(data);
        
        try {
            int b;
            while ((b = inputStream.read()) != -1) {
                System.out.print((char) b); // выводим символ, считанный из потока
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}