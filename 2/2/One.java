import package1.*;
import package2.*;

public class One{ 
      
    public static void main (String args[]){

        
        CoolClass parent = new CoolClass();
        SamePackageClass samePackage = new SamePackageClass();
        OtherPackageClass otherPackage = new OtherPackageClass();
        
        // Тестируем доступ из другого пакета
        System.out.println("\n1. Доступ из другого пакета (Main):");
        parent.accessPublicMethod();      // Доступно - public
        
        // Тестируем доступ через класс из того же пакета
        System.out.println("\n2. Доступ из того же пакета:");
        samePackage.testAccess();
        
        // Тестируем доступ через класс из другого пакета
        System.out.println("\n3. Доступ из другого пакета:");
        otherPackage.testAccess();

    }
}


