public class A {
    // Прямая инициализация
    public final int a = 1;
    
    // Инициализация в конструкторе
    public final int b;
    public A() {
        b = 2; 
    }

    // Инициализация в блоке
    public final int c;
    {
        c = 3; 
    }
    
}
