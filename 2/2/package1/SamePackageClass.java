package package1;

public class SamePackageClass {
    
    public void testAccess() {
        CoolClass parent = new CoolClass();
        
        System.out.println("Доступ из того же пакета:");
        
        // Public - доступен
        parent.accessPublicMethod();
        System.out.println("Public поле: " + parent.publicField);
        
        // Protected - доступен
        parent.accessProtectedMethod();
        System.out.println("Protected поле: " + parent.protectedField);
        
        // Default - доступен
        parent.accessDefaultMethod();
        System.out.println("Default поле: " + parent.defaultField);
        
        // Private - НЕ доступен
        /*
        parent.accessPrivateMethod(); // Ошибка компиляции
        System.out.println(parent.privateField); // Ошибка компиляции
        */
    }
}