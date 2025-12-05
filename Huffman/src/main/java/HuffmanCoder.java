import bit.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import structures.*;

public class HuffmanCoder {
    private final HuffmanTree tree;
    private final Map<Integer, String> codes;

    /**
     * Кодер, использующий дерево Хаффмана для сжатия данных.
     * @param tree Дерево Хаффмана с кодами символов.
     */
    HuffmanCoder(HuffmanTree tree) {
        this.tree = tree;
        this.codes = tree.getCodes();
    }

    /**
     * Кодирует данные из входного потока и записывает их в выходной побитовый поток.
     * @param in Входной байтовый поток с исходными данными.
     * @param out Побитовый выходной поток для записи сжатых данных.
     * @throws IOException В случае ошибок чтения или записи.
     */
    void encode(InputStream in, BitOutputStream out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            String code = codes.get(b);
            for (char c : code.toCharArray()) {
                out.writeBit(c == '1' ? 1 : 0);
            }
        }
        out.flush();
    }

}