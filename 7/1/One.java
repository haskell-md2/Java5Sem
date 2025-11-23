public class One {

    public static void main(String[] args) {
        String s = "  Hello, World! ";
        String s2 = "hello, world!";
        String s3 = "World";
        String s4 = "Hello, World";

        // 1. возвращает длину строки 
        int len = s.length();
        System.out.println(len);

        // 2. возвращает символ по указанному индексу 
        char ch = s.charAt(2);
        System.out.println(ch);

        // 3. возвращает новую строку без ведущих и замыкающих пробелов
        String trimmed = s.trim();
        System.out.println(trimmed);

        // 4. возвращает новую строку, где все буквы переведены в верхний регистр
        String upper = trimmed.toUpperCase();
        System.out.println(upper);

        // 5.  возвращает новую строку, где все буквы переведены в нижний регистр
        String lower = trimmed.toLowerCase();
        System.out.println(lower);

        // 6. сравнивает строки с учетом регистра
        boolean eq1 = trimmed.equals(s4);
        System.out.println(eq1);

        // 7. сравнивает строки без учета регистра
        boolean eq2 = trimmed.equalsIgnoreCase(s2.trim());
        System.out.println(eq2);

        // 8. проверяет, содержит ли строка подстроку
        boolean hasWorld = trimmed.contains("World");
        System.out.println(hasWorld);

        // 9. возвращает индекс первого вхождения подстроки или -1, если не найдено
        int index = trimmed.indexOf("World");
        System.out.println(index);

        // 10. substring(int beginIndex, int endIndex) – возвращает подстроку
        // от beginIndex (включительно) до endIndex (не включительно)
        String sub = trimmed.substring(7, 11); // "Java"
        System.out.println(sub);

        // Дополнительно можно показать concat() – конкатенация (склеивание) строк:
        // concat(String str) – возвращает новую строку, являющуюся результатом объединения
        String concatenated = s3.concat(" is awful");
        System.out.println(concatenated);
    }
    
}
