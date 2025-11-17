public class Logger {
    
    // Логирование только сообщений (без уровня)
    public static void log(String... messages) {
        System.out.print("[INFO] ");
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println();
    }
    
    // Логирование с указанием уровня (первый параметр - enum)
    public static void log(LogLevel level, String... messages) {
        System.out.print("[" + level + "] ");
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println();
    }
    
    //задел на следующее задание?
    enum LogLevel {
        INFO, DEBUG, ERROR, WARN
    }
    
    public static void main(String[] args) {

        //имитация логирования
        log("Приложение", "запущено");
        log("Пользователь", "вошел", "в", "систему");
        log(LogLevel.ERROR, "Файл не найден");
        log(LogLevel.DEBUG, "Переменная", "x = 10");
    }
}