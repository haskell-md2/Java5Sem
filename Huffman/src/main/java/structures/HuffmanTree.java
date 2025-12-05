package structures;

import bit.BitInputStream;
import bit.BitOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class HuffmanTree {
    private final HuffmanNode root;
    private final Map<Integer, String> codes;


    /**
     * Дерево Хаффмана, построенное по таблице частот.
     * @param freqMap Отображение «символ → частота».
     */
    public HuffmanTree(Map<Integer, Integer> freqMap) {
        root = buildTree(freqMap);
        codes = buildCodes(root);
    }


    /**
     * Создаёт дерево Хаффмана по уже готовому корневому узлу.
     * @param root Корневой узел дерева.
     */
    public HuffmanTree(HuffmanNode root) {
        this.root = root;
        this.codes = buildCodes(root);
    }

    /**
     * Строит дерево Хаффмана по таблице частот.
     * @param freqMap Отображение «символ → частота».
     * @return Корневой узел построенного дерева.
     */
    private HuffmanNode buildTree(Map<Integer, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            pq.add(new HuffmanNode(left.freq + right.freq, left, right));
        }
        return pq.poll();
    }

    /**
     * Строит коды Хаффмана для всех листьев дерева.
     * @param root Корень дерева, для которого строятся коды.
     * @return Map, где ключ — символ, значение — строка с битовым кодом.
     */
    private Map<Integer, String> buildCodes(HuffmanNode root) {
        Map<Integer, String> map = new HashMap<>();
        class StackItem {
            HuffmanNode node;
            String code;
            StackItem(HuffmanNode node, String code) {
                this.node = node;
                this.code = code;
            }
        }
        Stack<StackItem> stack = new Stack<>();
        stack.push(new StackItem(root, ""));
        while (!stack.isEmpty()) {
            StackItem current = stack.pop();
            if (current.node.isLeaf()) {
                map.put(current.node.symbol, current.code);
            } else {
                if (current.node.right != null)
                    stack.push(new StackItem(current.node.right, current.code + "1"));
                if (current.node.left != null)
                    stack.push(new StackItem(current.node.left, current.code + "0"));
            }
        }
        return map;
    }

    /**
     * Возвращает отображение «символ → код Хаффмана».
     * @return Map с кодами Хаффмана для всех символов.
     */
    public Map<Integer, String> getCodes() {
        return codes;
    }

    /**
     * Возвращает корневой узел дерева.
     * @return Корневой узел HuffmanNode.
     */
    public HuffmanNode getRoot() {
        return root;
    }

    /**
     * Записывает структуру дерева Хаффмана в поток.
     * @param out Побитовый выходной поток для записи дерева.
     * @throws IOException В случае ошибок ввода-вывода при записи.
     */
    public void writeTree(BitOutputStream out) throws IOException {
        writeNode(root, out);
    }
    /**
     * Рекурсивно записывает узел дерева и его потомков.
     * @param node Текущий узел дерева для записи.
     * @param out Побитовый выходной поток.
     * @throws IOException В случае ошибок ввода-вывода при записи.
     */
    private void writeNode(HuffmanNode node, BitOutputStream out) throws IOException {
        if (node.isLeaf()) {
            out.writeBit(1);
            out.writeByte(node.symbol);
        } else {
            out.writeBit(0);
            writeNode(node.left, out);
            writeNode(node.right, out);
        }
    }

    /**
     * Восстанавливает дерево Хаффмана из потока.
     * @param in Побитовый входной поток с закодированным деревом.
     * @return Восстановленное дерево Хаффмана.
     * @throws IOException В случае ошибок ввода-вывода при чтении.
     */
    public static HuffmanTree readTree(BitInputStream in) throws IOException {
        HuffmanNode root = readNode(in);
        return new HuffmanTree(root);
    }

    /**
     * Рекурсивно читает узел дерева и его потомков.
     * @param in Побитовый входной поток.
     * @return Восстановленный узел дерева.
     * @throws IOException В случае ошибок ввода-вывода при чтении.
     */
    private static HuffmanNode readNode(BitInputStream in) throws IOException {
        int bit = in.readBit();
        if (bit == 1) {
            int symbol = in.readByte();
            return new HuffmanNode(symbol, 0);
        } else {
            HuffmanNode left = readNode(in);
            HuffmanNode right = readNode(in);
            return new HuffmanNode(0, left, right);
        }
    }
}