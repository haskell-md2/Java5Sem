public class One{ 
      
    public static void main (String args[]){


        /*Работает */
        OuterClass1 outer1 = new OuterClass1();
        OuterClass1.PublicInner publicInner = outer1.new PublicInner();
        publicInner.display();


        /*пример нерабочего кода*/
        // Попытка использования извне
        OuterClass2 outer2 = new OuterClass2();
        // OuterClass2.PrivateInner inner = outer.new PrivateInner(); // ОШИБКА 
        outer2.usePrivateInner(); // правильный способ через метод внешнего класса


        /*Рабочий пример */
        OuterClass3 outer = new OuterClass3();
        OuterClass3.DefaultInner inner = outer.new DefaultInner(); // работает
        inner.display();

    }
}

class OuterClass1 {
    private String outerField = "outer data";
    
    public class PublicInner {
        private String innerField = "public inner data";
        
        public void display() {
            System.out.println(outerField); // доступ к private полю внешнего класса
            System.out.println(innerField);
        }
    }
}

class OuterClass2 {
    private String data = "Private data";
    
    private class PrivateInner {
        public void accessOuterData() {
            System.out.println(data); // доступ к private полю
        }
    }
    
    public void usePrivateInner() {
        PrivateInner inner = new PrivateInner();
        inner.accessOuterData();
    }
}

class OuterClass3 {
    String data = "some data";
    
    class DefaultInner { // без модификатора доступа
        public void display() {
            System.out.println(data);
        }
    }
}