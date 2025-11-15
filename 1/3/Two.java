public class Two{ 
      
    public static void main (String args[]){
        Transport animal = new Car();
        
        boolean isCar = animal instanceof Car; // Вернет true
        boolean isPlane = animal instanceof Plane; // Вернет false
        
        System.out.println(isCar); // Выведет true
        System.out.println(isPlane); // Выведет false

        /*Пример для null-объекта*/
        Object obj = null;
        boolean isNullObject = obj instanceof Object; // Вернет false
        System.out.println(isNullObject); // Выведет false
    }
}

class Transport {}
class Car extends Transport {}
class Plane extends Transport {}

