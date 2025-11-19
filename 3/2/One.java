
public class One{
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        warrior.performTurn();
        // Алгоритм performTurn() всегда выполняется одинаково,
        // несмотря на конкретную реализацию персонажа
    }
}


abstract class GameCharacter {
    private String name;
    private int health;
    
    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }
    
    // final метод, определяющий НЕИЗМЕНЯЕМЫЙ алгоритм действий персонажа
    public final void performTurn() {
        System.out.println("--- Ход персонажа " + name + " ---");
        selectTarget();      
        usePrimaryAbility(); 
        move();             
        endTurn();     
    }
    
    // Шаги, которые подклассы МОГУТ изменять
    protected abstract void selectTarget();
    protected abstract void usePrimaryAbility();
    protected abstract void move();
    
    // ФИНАЛЬНЫЙ шаг - нельзя изменить логику завершения хода
    private final void endTurn() {
        System.out.println("Проверка статусов...");
        System.out.println("Оставшееся здоровье: " + health);
        System.out.println("--- Конец хода ---\n");
    }
    
    // final геттер
    public final String getName() {
        return name;
    }
}

class Warrior extends GameCharacter {
    public Warrior() {
        super("Воин", 100);
    }
    
    @Override
    protected void selectTarget() {
        System.out.println("Воин выбирает ближайшего врага");
    }
    
    @Override
    protected void usePrimaryAbility() {
        System.out.println("Воин наносит удар мечом");
    }
    
    @Override
    protected void move() {
        System.out.println("Воин двигается вперед");
    }
    
    //НЕВОЗМОЖНО переопределить final метод
    // @Override
    // public void performTurn() { ... }
    
    //ЕВОЗМОЖНО переопределить final метод (даже private!)
    // @Override
    // private void endTurn() { ... }
}
