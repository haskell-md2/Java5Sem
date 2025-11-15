import java.util.Scanner;

public class One{ 
      
    public static void main (String args[]){



        Scanner in = new Scanner(System.in);
        System.out.println("Выбери своего героя: ");

        int mode = in.nextInt();

        if (mode == 0){
            // Самый простой вариант
            while (true) {
                System.out.println("Этот цикл будет выполняться вечно!");
            }
        }else if(mode == 1){
            // Через математическое условие
            int x = 1;
            while (x > 0) {
                System.out.println("x всегда больше 0: " + x);
            }
        }
        else{
            do {
                System.out.println("Сначала выполняется тело, потом проверка условия");
                System.out.println("Этот цикл тоже бесконечный!");
            } while (true);
        }



    }
}