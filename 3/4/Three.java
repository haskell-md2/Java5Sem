class SophisticatedArithmetic{
    Number sum(float a, float b){
        return  a + b;
    }
}


class Floatator extends  SophisticatedArithmetic{


    /* без Override может допускаться такое безобразие - из-за изменённой сигнатруы
    получилось не переопределение, а просто перегрузка!*/
    String sum(int a, int b){
        return  Integer.toString(a+b);
    }

    /* А если писать так, то зло не пройдёт - программа не скомпилируется.
    @Override
    String sum(int a, int b){
        return  Integer.toString(a+b);
    }
    */

    @Override
    Float sum(float a, float b){
        return  a + b;
    }
 
}

public class Three{

    public static void main(String[] args) {

        Floatator flor = new Floatator();

        flor.sum(2f, 3f); //все работает как надо
        flor.sum(2, 3); //перегрузка, возвращает String


        /*
        Проще говоря, @Override превращает логические ошибки в ошибки компиляции
        */
    }

}


