package overloading;

public class Payment {
    
    public boolean process(double amount) {
        System.out.println("Обработка платежа на сумму: " + amount);
        // Базовая логика - просто резервируем сумму
        return reserveFunds(amount);
    }
    
    protected boolean reserveFunds(double amount) {
        System.out.println("Резервирование средств: " + amount);
        return true;
    }
}