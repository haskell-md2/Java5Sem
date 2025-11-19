// Final класс для математических констант - наследование бессмысленно
final class MathConstants {
    // Приватный конструктор - нельзя создать экземпляр
    private MathConstants() {}
    
    public static final double GOLDEN_RATIO = 1.61;
    public static final double PI = 3.14;
    
    // Final метод в final классе
    public static final double calculateCircleArea(double radius) {
        return PI * radius * radius; // Специфическая формула
    }
}

//НЕВОЗМОЖНО наследовать
// class MyConstants extends MathConstants {  // Ошибка компиляции!
//     // Нельзя изменить математические константы
// }