//Почему бы не написать нам какой-нибудь болеее реалистичный пример в этот раз?


public class One {
    public static void main(String[] args) {
        // Создание объекта вложенного класса из интерфейса
        DatabaseOperation.Query query = new DatabaseOperation.Query("SELECT * FROM users", 30);
        query.printInfo();
        
        System.out.println("SQL: " + query.getSql());
        System.out.println("Timeout: " + query.getTimeout());

        /* out:
        SQL: SELECT * FROM users, Timeout: 30
        SQL: SELECT * FROM users
        Timeout: 30
         */
    }
}

interface DatabaseOperation {
    void execute();
    
    // Вложенный класс внутри интерфейса (заметим, что автоматически ставится неявно public static)
    class Query {
        private String sql;
        private int timeout;
        
        public Query(String sql, int timeout) {
            this.sql = sql;
            this.timeout = timeout;
        }
        
        public String getSql() {
            return sql;
        }
        
        public int getTimeout() {
            return timeout;
        }
        
        public void printInfo() {
            System.out.println("SQL: " + sql + ", Timeout: " + timeout);
        }
    }
}