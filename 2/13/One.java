public class One {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c + ": " + c.getDescription());
        }
    }
}

enum Color {
    RED("Стоять!"),
    YELOW("Приготовиться!"),
    GREEN("В путь!");

    private final String description; // дополнительное поле

    // Конструктор enum - вызывается для каждого элемента
    private Color(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}