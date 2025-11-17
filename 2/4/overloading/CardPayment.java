package overloading;

public class CardPayment extends Payment {
    
    @Override
    public boolean process(double amount) {
        System.out.println("Обработка карточного платежа: " + amount);
        

        boolean auth = authorizeWithBank(amount);
        if (auth) {
            System.out.println("Платеж одобрен");
            return true;
        } else {
            System.out.println("Отказ");
            return false;
        }
    }
    
    private boolean authorizeWithBank(double amount) {
        return amount <= 1000;
    }
}