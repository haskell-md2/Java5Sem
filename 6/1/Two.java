public class Two{


    public static void main(String[] args) {

        Service1 service1 = new Service1();
        service1.processData("user data");
        service1.log("Direct log call");


        Service2 service2 = new Service2();
        service2.processData("user data");

        Service3 service3 = new Service3();
        System.out.println("=== Режим 1 ===");
        service3.processData("user data");
        
        System.out.println("\n=== Режим 2 ===");
        service3.setAuditMode(true);
        service3.processData("sensitive data");
    }
}


/*
Ответ на вопрос:
когда класс реализует два интерфейса, у которых некоторые методы совпадают сигнатурами,
то возникает проблема ромбовидного наследования. 
*/
interface Logger {
    default void log(String message) {
        System.out.println("[Logger] " + message);
    }
}

interface Auditor {
    default void log(String message) {
        System.out.println("[Auditor] " + message);
    }
}

// Попытка реализовать оба интерфейса прниведёт к краху!
/*
class Service implements Logger, Auditor {
    // ОШИБКА КОМПИЛЯЦИИ!
    // Error: class Service inherits unrelated defaults for log(String) 
    // from types Logger and Auditor
    
    public void processData(String data) {
        log(data); // Какой метод log() вызвать?
    }
}
*/


//Решить эту проблему можно следующими путями:

//1 - Переопределение с собственной реализацией
class Service1 implements Logger, Auditor {
    // Обязательно переопределяем конфликтующий метод
    @Override
    public void log(String message) {
        // Наша собственная реализация
        System.out.println("[Service]: " + message);
    }
    
    public void processData(String data) {
        log("Processing: " + data);
    }
}


//2 - Явно выбрать реализацию одного из интерфесов (что в целом всё равно является частным случаем пути 1)
class Service2 implements Logger, Auditor {
    @Override
    public void log(String message) {
        // Явно выбираем реализацию из Logger
        Logger.super.log(message);
    }
    
    public void processData(String data) {
        log("Processing: " + data);
    }
}

//3 - Условный выбор реализации
class Service3 implements Logger, Auditor {
    private boolean useAuditMode = false;
    
    public void setAuditMode(boolean mode) {
        this.useAuditMode = mode;
    }
    
    @Override
    public void log(String message) {
        // Выбираем реализацию в зависимости от режима
        if (useAuditMode) {
            Auditor.super.log(message);
        } else {
            Logger.super.log(message);
        }
    }
    
    public void processData(String data) {
        log("Processing: " + data);
    }
}