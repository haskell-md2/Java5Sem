import java.util.Scanner;
import java.io.IOException;

public class Program{ 
      
    public static void main (String args[]){
        
        try {

            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя:");
            System.out.println("Привет, " +in.nextLine() + ".");
            in.close();

        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
        
    }
}