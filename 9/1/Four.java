/*
    Интерфейс AutoCloseable предназначен для объектов, которые используют внешние ресурсы
    (файлы, сетевые соединения, потоки и т.п.) и требуют гарантированного освобождения этих ресурсов после использования. 
    Главное его назначение — автоматическое закрытие ресурса при выходе из блока try-with-resources
 */

public class Four {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            resource.use();
        } // тут автоматически вызовется resource.close()
    }
}

class MyResource implements AutoCloseable {
    public void use() {
        System.out.println("Используем ресурс");
    }
    
    @Override
    public void close() {
        System.out.println("Ресурс освобожден");
    }
}
