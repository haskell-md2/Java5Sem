public class  One{

    // Метод, который генерирует два исключения
    public static void generateExceptions() throws ArrayIndexOutOfBoundsException {
        try {
            int a = 0 / 0;  // Генерация ArithmeticException - обработается в блоке catch ниже
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: деление на ноль");
        }

        // Это исключение не будет обработано в этом методе, а будет пойман в мэйне
        int[] arr = new int[2];
        System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
    }

    public static void main(String[] args) {
        try {
            generateExceptions();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение в main: выход за границы массива");
        }
    }
}