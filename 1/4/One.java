public class One{ 
      
    public static void main (String args[]){

        // Преобразование десятичного целого числа из строки
        Integer decimal = Integer.decode("10");

        // Преобразование шестнадцатеричного числа
        Integer hex = Integer.decode("0xFF");
        
        // Преобразование восьмеричного числа (начинается с нуля)
        Integer octalValue = Integer.decode("012");
    }
}