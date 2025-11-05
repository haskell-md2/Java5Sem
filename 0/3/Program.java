import java.util.Scanner;
import java.io.IOException;

public class Program{ 
      
    public static void main (String args[]){
        
        try {

            Scanner in = new Scanner(System.in);
            System.out.println("Введи имя:");
            System.out.println("Привет, " +in.nextLine() + ".");

        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
        
    }
}