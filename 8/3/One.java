
public class  One{

    public static void main(String[] args) {


        try {
            throw new IllegalArgumentException("Плохой параметр");
        } catch (IllegalArgumentException | NullPointerException e) {
            // Несколько исключений обрабатываются одинаково
            System.out.println("Исключение обработано: " + e);
        }

        //Иерархия исключений
        try {
            throw new Ex2(); //допустим, выброшено исключение 2
        } catch (Ex3 e) {
            System.out.println("Обработка Ex3");
        } catch (Ex2 e) {
            System.out.println("Обработка Ex2");
        } catch (Ex1 e) {
            System.out.println("Обработка Ex1");
        }

    }
}


class Ex1 extends Exception {}
class Ex2 extends Ex1 {}
class Ex3 extends Ex2 {}