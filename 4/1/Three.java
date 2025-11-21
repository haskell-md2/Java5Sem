/*
Аналогично -- внешний класс имеет полный доступ к внутренннему.
*/


public class Three {
    
    // Внутренний класс с private членами
    public class InnerClass {
        private int innerPrivField = 50;
        
        private void innerPrivateMethod() {
            System.out.println("Inner private method called");
        }
        
        private int calculateValue() {
            return innerPrivField * 2;
        }
    }
    
    // Внешний класс обращается к private членам внутреннего класса
    public void accessInnerPrivateMembers() {
        InnerClass inner = new InnerClass();
        
        System.out.println("Inner private field: " + inner.innerPrivField);
        

        inner.innerPrivateMethod();
        
        int result = inner.calculateValue();
        System.out.println("Result from private method: " + result);
        

        inner.innerPrivField = 75;
        System.out.println("Modified inner field: " + inner.innerPrivField);
    }
    
    public static void main(String[] args) {
        Three outer = new Three();
        outer.accessInnerPrivateMembers();
    }
}
