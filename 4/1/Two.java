/*
Ответ на вопрос:
внутренний класс имеет полный доступ ко всем полям и методам внешнего класса, включая private члены. 
*/


public class Two{
    private int privField = 10;
    
    private void privateMethod() {
        System.out.println("Private method of outer class");
    }
    
    // Внутренний класс
    public class InnerClass {
        public void accessOuterMembers() {
            // Доступ к private полям внешнего класса
            System.out.println("Private field: " + privField);
            

            privateMethod();
            
            // Модификация private поля
            privField = 20;
            System.out.println("Modified field: " + privField);
        }
    }
    
    public static void main(String[] args) {
        Two outer = new Two();
        Two.InnerClass inner = outer.new InnerClass();
        inner.accessOuterMembers();
    }
}

