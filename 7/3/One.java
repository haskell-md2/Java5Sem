import java.util.Date;
import java.util.Formatter;

public class One{

    public static void main(String[] args) {

        Formatter formatter = new Formatter();

        // 1. %b - логическое значение
        boolean flag = true;
        formatter.format("Свобода - это Рабство, Незнание - Сила, Война - это Мир: %b%n", flag);

        // 2. %c - символ
        char ch = 'A';
        formatter.format("%c? %n", ch);

        // 3. %d - десятичное целое число
        int number = 42;
        formatter.format("Ответ на главный вопрос Вселенной: %d%n", number);

        // 4. %f - десятичное число с плавающей точкой
        double pi = 3.142;
        formatter.format("Чиним пи, путём округления: %.2f%n", pi); // округление до 2 знаков

        //5. %t - время и дата, пример вывода текущей даты и времени
        Date now = new Date();
        formatter.format("Точное местное время: %tF %tT%n", now, now);

        // // Вывод результата
        System.out.println(formatter);

        // Закрываем Formatter
        formatter.close();
    }
}

