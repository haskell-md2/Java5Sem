
public class Two{

    public static void main(String[] args) {

        // Исходный String
        String str = "Исходная строка";

        // String -> StringBuffer
        StringBuffer sbuf = new StringBuffer(str);
        System.out.println("String -> StringBuffer: " + sbuf);

        // String -> StringBuilder
        StringBuilder sbld = new StringBuilder(str);
        System.out.println("String -> StringBuilder: " + sbld);

        // StringBuffer -> String
        String strFromSbuf = sbuf.toString(); // toString() возвращает содержимое как String
        System.out.println("StringBuffer -> String: " + strFromSbuf);

        // StringBuilder -> String
        String strFromSbld = sbld.toString();
        System.out.println("StringBuilder -> String: " + strFromSbld);

        // StringBuffer -> StringBuilder
        StringBuilder sbldFromSbuf = new StringBuilder(sbuf.toString());
        System.out.println("StringBuffer -> StringBuilder: " + sbldFromSbuf);

        // StringBuilder -> StringBuffer
        StringBuffer sbufFromSbld = new StringBuffer(sbld.toString());
        System.out.println("StringBuilder -> StringBuffer: " + sbufFromSbld);

    }
}

