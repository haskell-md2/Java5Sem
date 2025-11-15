public class Three{ 
      
    public static void main (String args[]){

        Integer num = null; // Объектная оболочка примитивного типа int
    
        try {
            int unpackedNum = num.intValue(); // Попытка распаковки вызывает NullPointerException
            System.out.println(unpackedNum);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    
        try {
            int sum = num + 10; 
            System.out.println(sum);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
    }
}


