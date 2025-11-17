import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;

public class Two{

    //метод умеет работать с классами, производными от Number
    public static void processNumbers(List<? extends Number> numbers) {
        for (Number n : numbers) {
            System.out.println(n);
        }
    }

    //метод умеет работать с Integer и с его родительскими классами 
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {

        //пример для extends
        List<Integer> intList = Arrays.asList(1, 2, 3);
        processNumbers(intList); // Можно передать List<Integer>

        List<Double> doubleList = Arrays.asList(1.1, 2.2);
        processNumbers(doubleList); // Можно передать List<Double>

        //примеры для super
        List<Number> numList = new ArrayList<>();
        addIntegers(numList); // Можно передать List<Number>

        List<Object> objList = new ArrayList<>();
        addIntegers(objList); // Можно передать List<Object>

        Object obj = null;
        for (Object o : objList) {
            System.out.println(o);
        }

    }
}