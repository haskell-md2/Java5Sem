// пишу всё в одном файле для удобства проверяющего.



public class One{
    public static void main(String[] args) {
        Dog dog = new Dog();


        dog.makeSound();
        dog.printNames();
    }
}

// мне тоже не нравятся примеры с животными, но у меня на данный момент кончилась фантазия :(

class Animal {
    String name;

    public Animal() {
        this.name = "Млекопитающее";
    }

    public void makeSound() {
        System.out.println("Издаёт звук: ");
    }
}

class Dog extends Animal {
    String name;

    public Dog() {
        super(); // вызов конструктора Animal
        this.name = "Пёс"; // инициализация поля подкласса
    }

    public void makeSound() {
        super.makeSound(); // вызов метода суперкласса
        System.out.println("Гав.."); // дополнение собственным поведением
    }

    public void printNames() {
        System.out.println("Вид:  " + this.name);
        System.out.println("Класс мира животных:  " + super.name); // доступ к полю суперкласса
    }
}
