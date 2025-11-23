import java.util.Date;
import java.util.Formatter;

public class Three{

    public static void main(String[] args) {

        Date now = new Date();
        Formatter formatter = new Formatter();

        // %tH - часы (00–23)
        // %tM - минуты (00–59)
        // %tS - секунды (00–59)
        // %tY - год в четырёхзначном формате
        // %tB - полное название месяца

        formatter.format("Текущее время: %tH:%tM:%tS%n", now, now, now);
        formatter.format("Год: %tY%n", now);
        formatter.format("Месяц: %tB%n", now);

        System.out.println(formatter);

        formatter.close();
    }
}

