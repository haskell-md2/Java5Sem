import overloading.*;

public class One{ 
      
    public static void main (String args[]){

        // Summator s = new Summator();

        // System.out.println(s.add(1, 2));//out: 3
        // System.err.println(s.add("1", "2")); //out 12

        Payment card = new CardPayment();
        Payment paypal = new SmilePayment();
        
        // Один метод process(), но разное поведение
        card.process(500);     
        System.out.println();
        paypal.process(200);   
    
    }
}


