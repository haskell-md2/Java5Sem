public class One {
    public static void main(String[] args) {


        // 1. Вызов через объект JsonProcessor
        JsonProcessor jsonProcessor = new JsonProcessor("JSON-Handler-1");
        jsonProcessor.process("bla-bla-bla");  // Абстрактный метод
        System.out.println();
        jsonProcessor.processWithLogging("{\"id\": 123}");  // непереопределенный default метод
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        
        // 2. Вызов статического метода через имя интерфейса
        boolean valid1 = DataProcessor.isValidData("test data");
        System.out.println("Result: " + valid1);
        System.out.println();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // 3. Вызов через ссылку на интерфейс
        DataProcessor processor = new JsonProcessor("Generic-Processor");
        processor.process("interface reference data");  // Полиморфизм
        System.out.println();
        processor.processWithLogging("more data");  // Вызов через интерфейс
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
    }
}

interface DataProcessor {
    // Абстрактный метод (обязателен к реализации)
    void process(String data);
    
    // Default метод (неабстрактный, с реализацией)
    default void processWithLogging(String data) {
        System.out.println("=== Начинаем чистить данные ===");
        System.out.println("Вход: " + data);
        process(data);
        System.out.println("=== Данные обработаны ===");
    }
    
    // Статический метод для валидации данных
    static boolean isValidData(String data) {
        System.out.println("Валидация: " + data);
        return data != null && !data.trim().isEmpty() && data.length() >= 3;
    }
}


class JsonProcessor implements DataProcessor {
    private String processorName;
    
    public JsonProcessor(String name) {
        this.processorName = name;
    }
    
    // Реализация абстрактного метода (обязательно)
    @Override
    public void process(String data) {
        System.out.println("[" + processorName + "] Обработка JSON: " + data);
    }
    
    // Переопределение default метода (опционально)
    /*
    @Override
    public void processWithLogging(String data) {
        System.out.println("*** " + processorName + " - Enhanced logging ***");
        System.out.println("Timestamp: " + System.currentTimeMillis());
        System.out.println("Data length: " + data.length());
        process(data);
        System.out.println("*** Logging completed ***");
    }
    */
}