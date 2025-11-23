public class CustomException extends Exception {
    
    // Конструктор без аргументов
    public CustomException() {
        super();
    }

    // Конструктор с сообщением об ошибке
    public CustomException(String message) {
        super(message);
    }

    // Конструктор с сообщением и причиной (другим исключением)
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}