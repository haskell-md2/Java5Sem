public class One{

    public static void main(String[] args) {

        //StringBuilder (не потокобезопасный, но быстрее)
        StringBuilder sb = new StringBuilder("Start");

        // 1. append() - добавляет строку или значение к текущему содержимому
        sb.append(" - Middle");
        System.out.println(sb);

        // 2. insert(int offset, String str) - вставляет строку в указанную позицию
        sb.insert(6, "Inserted ");
        System.out.println(sb);

        // 3. replace(int start, int end, String str) - заменяет часть строки с start по end
        sb.replace(6, 14, "Replaced");
        System.out.println(sb);

        // 4. delete(int start, int end) - удаляет часть с start по end
        sb.delete(6, 14);
        System.out.println(sb);

        // 5. reverse() - переворачивает содержимое StringBuilder
        sb.reverse();
        System.out.println(sb);

        // 6. capacity() - возвращает текущую ёмкость внутреннего буфера
        System.out.println( sb.capacity());

        // 7. setCharAt(int index, char ch) - изменяет символ по индексу
        sb.setCharAt(0, 'Z');
        System.out.println( sb);

        // 8. charAt(int index) - возвращает символ по индексу
        char c = sb.charAt(1);
        System.out.println(c);

        // 9. length() - текущая длина содержимого
        System.out.println(sb.length());

        // 10. toString() - преобразует StringBuilder в String
        String finalStr = sb.toString();
        System.out.println(finalStr);

        // Теперь пример с StringBuffer (потокобезопасный)
        StringBuffer sf = new StringBuffer("Buffer");
        sf.append(" Example");
        System.out.println(sf);

    }
}

