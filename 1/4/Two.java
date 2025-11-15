public class Two{ 
      
    public static void main (String args[]){

        /*ТАК ДЕЛАТЬ НЕ НАДО! - устаревший вариант
        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean(false);
        Boolean bool3 = new Boolean("true");
        Boolean bool4 = new Boolean("false");
        ------------------- */

        /* 1-ый вариант*/
        Boolean bool1 = Boolean.valueOf(true); 
        Boolean bool2 = Boolean.valueOf(false);

        /* 2-ой вариант*/
        bool1 = Boolean.valueOf("true");
        bool2 = Boolean.valueOf("False"); 
        Boolean bool3 = Boolean.valueOf("TRUE"); 
        Boolean bool4 = Boolean.valueOf("FALSE"); 

        /* 3-ий вариант */
        boolean simpleTrue = true;
        Boolean boxedBool = simpleTrue;
    }
}


