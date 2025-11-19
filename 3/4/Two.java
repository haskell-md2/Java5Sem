class SophisticatedArithmetic{
    Number sum(float a, float b){
        return  a + b;
    }
}


class Floatator extends  SophisticatedArithmetic{

    /* Некорректно, так как float и Number - нековариантны
    float sum(float a, float b){
        return toString(a + b);
    }
    */

   /*Так уже можно*/
    Float sum(float a, float b){
        return  a + b;
    }
 
}

public class Two{

    public static void main(String[] args) {

        Floatator flor = new Floatator();
        flor.sum(2, 3); //будет именно типа Float, а не Number

    }

}


