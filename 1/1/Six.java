import java.util.Scanner;
import java.io.IOException;

public class Six{ 
      
    
    public static void main(String[] args) {

        // int -> byte
        int intValue = 127;
        byte byteValue = (byte) intValue;
        
        // int -> short
        int largeInt = 32767;
        short shortValue = (short) largeInt;
        
        // long -> int
        long longValue = 2_147_483_647L;
        int intFromLong = (int) longValue;
        
        // double -> int
        double doubleValue = 123.456;
        int intFromDouble = (int) doubleValue; //будет 123
        
    }

}