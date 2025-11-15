import java.util.Arrays;

public class Two{ 
      
    public static void main (String args[]){

        /* .toString() */
        int[] numbers = {-1,0,1,2,5,10};
        System.out.println("Numbers: " + Arrays.toString(numbers)); //out: Numbers: [-1, 0, 1, 2, 5, 10]

        /* .binarySearch()*/
        int index= Arrays.binarySearch(numbers,2);
        System.out.println("Index: "+ index);  //out: Index: 3

        /* .equals() */
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};
        System.err.println("result: " + Arrays.equals(arr1, arr2));//out: result: true
        System.err.println("result: " + Arrays.equals(arr1, arr3));//out: result: false

        /*.compare()*/
        int[] arr4 = {1, 2};
        // Сравнение одинаковых массивов
        System.out.println("compare(arr1, arr2): " + Arrays.compare(arr1, arr2));//out: 0

        // arr1 < arr3 (3 < 4)
        System.out.println("compare(arr1, arr3): " + Arrays.compare(arr1, arr3));//out: -1

        // arr4 < arr1 (короче)
        System.out.println("compare(arr4, arr1): " + Arrays.compare(arr4, arr1));//out: -1

        /*.sort() */
        int[] rand_numbers = {5, 2, 8, 1, 9, 3};
        Arrays.sort(rand_numbers);
        System.out.println("Sorted: " + Arrays.toString(rand_numbers));//out: Sorted: [1, 2, 3, 5, 8, 9]
    }
}


