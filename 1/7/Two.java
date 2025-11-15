public class Two{ 
      
    public static void main (String args[]){

        // Поиск первого четного числа в массиве
        int[] numbers = {1, 3, 5, 8, 9, 10};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.println("Найдено первое четное число: " + numbers[i]);
                break; // Выходим из цикла после нахождения
            }
        }



        // Ввыводим только чётные числа
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Пропускаем четные числа
            }
            System.out.println("Нечетное число: " + i);
        }
    }
}


