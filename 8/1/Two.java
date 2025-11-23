

public class Two{


    static void printSquare(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным");
        }
        System.out.println(num * num);
    }

    public static void main(String[] args) {


        //ArithmeticException
        try {
            int a = 42 / 0; // Деление на нуль
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
        }


        //ArrayIndexOutOfBoundsException
        int[] array = {1, 2, 3};
        try {
            int val = array[5]; // Нет элемента с индексом 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: индекс вне границ массива");
        }


        //IllegalArgumentException 
        try {
            printSquare(-5);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        
   

        //ClassCastException
        Object text = "Java";
        try {
            Integer number = (Integer) text; // Ошибка приведения типов
        } catch (ClassCastException e) {
            System.out.println("Ошибка: неправильное приведение типов");
        }

        //NullPointerException
        String s = null;
        try {
            System.out.println(s.length()); // Попытка вызвать метод у null
        } catch (NullPointerException e) {
            System.out.println("Ошибка: обращение к методу/полю объекта, равного null");
        }

    }
}
