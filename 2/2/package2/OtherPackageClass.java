package package2;

import package1.CoolClass;

public class OtherPackageClass {
    
    public void testAccess() {
        CoolClass parent = new CoolClass();
        
        System.out.println("Доступ из другого пакета:");
        
        // Public - доступен
        parent.accessPublicMethod();
        System.out.println("Public поле: " + parent.publicField);
        
        // Protected - НЕ доступен (не в том же пакете)
        /*
        parent.accessProtectedMethod();
        System.out.println(parent.protectedField);
        */
        
        // Default - НЕ доступен
        /*
        parent.accessDefaultMethod(); // Ошибка компиляции
        System.out.println(parent.defaultField); // Ошибка компиляции
        */

        // Private - НЕ доступен
        /*
        parent.accessPrivateMethod();
        System.out.println(parent.privateField);
        */
    }
}