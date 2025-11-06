import java.util.Scanner;
import java.io.IOException;

public class Five{ 
      
    
    public static void main(String[] args) {

        //Пример 1
        // byte -> short -> int -> long
        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;
        // byte + short = int
        int result1 = b + s;
        // int + long = long
        long result2 = i + l;
        // byte + int = int
        int result3 = b + i;


        //Пример 2
        //int -> float -> double
        int i = 5;
        float f = 2.5f;
        double d = 3.14;
        // int + float = float
        float result1 = i + f;
        // float + double = double
        double result2 = f + d;
        
    }

}