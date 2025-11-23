import java.util.StringJoiner;

public class Two{

    public static void main(String[] args) {

        // 1. Создание StringJoiner с разделителем ", "
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Apple");
        joiner1.add("Banana");
        joiner1.add("Cherry");
        System.out.println(joiner1.toString());
        // out: Apple, Banana, Cherry
        // Конкатенация элементов с разделителем

        // 2. StringJoiner с разделителем, префиксом и суффиксом
        StringJoiner joiner2 = new StringJoiner(";", "{", "}");
        joiner2.add("John").add("Jane").add("Jack");
        System.out.println(joiner2.toString());
        // out: {John;Jane;Jack}


        // 3. Использование метода merge() для объединения двух StringJoiner
        StringJoiner joiner3a = new StringJoiner("-");
        joiner3a.add("2025").add("11");
        StringJoiner joiner3b = new StringJoiner("-");
        joiner3b.add("23").add("11");
        StringJoiner merged = joiner3a.merge(joiner3b);
        System.out.println(merged.toString());
        // out: 2023-11-23-08


        // 4. Цепочка вызовов add()
        StringJoiner joiner4 = new StringJoiner("|");
        joiner4.add("A").add("B").add("C");
        System.out.println(joiner4.toString());
        // out: A|B|C


        // 5. Пустой StringJoiner возвращает только префикс и суффикс, если они заданы
        StringJoiner joiner5 = new StringJoiner(",", "[", "]");
        System.out.println(joiner5.toString());
        // out: []


        // 6. Использование StringJoiner для сборки CSV строки с обработкой пустых элементов
        StringJoiner csvJoiner = new StringJoiner(",");
        String[] data = {"Ivan", "", "Petrov", null, "123"};
        for (String item : data) {
            csvJoiner.add(item == null ? "NULL" : item);
        }
        System.out.println(csvJoiner.toString());
        // out: Ivan,,Petrov,NULL,123


    }
}

