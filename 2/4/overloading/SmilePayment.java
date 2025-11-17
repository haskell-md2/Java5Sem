package overloading;

public class SmilePayment extends Payment {
    
    @Override
    public boolean process(double amount) {
        System.out.println("Обработка платежа по биометрии: " + amount);
        
        
        boolean confirmed = redirectToPayPal(amount);
        if (confirmed) {
            System.out.println("Личность подтверждена.");
            return true;
        } else {
            System.out.println("Личность НЕ подтверждена");
            return false;
        }
    }
    
    private boolean redirectToPayPal(double amount) {
        return amount > 0;
    }
}