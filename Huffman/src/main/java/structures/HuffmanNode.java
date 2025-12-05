package structures;

public class HuffmanNode {
    Integer symbol;
    int freq;
    HuffmanNode left, right;


    /**
     * Узел дерева Хаффмана: лист или внутренний узел.
     * @param symbol Символ (байт) для листа.
     * @param freq Частота появления символа.
     */
    HuffmanNode(Integer symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
    }


    /**
     * Создаёт внутренний узел по двум дочерним.
     * @param freq Суммарная частота левого и правого поддерева.
     * @param left Левый дочерний узел.
     * @param right Правый дочерний узел.
     */
    HuffmanNode(int freq, HuffmanNode left, HuffmanNode right) {
        this.symbol = null;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    /**
     * Возвращает левый дочерний узел.
     * @return Левый потомок или null, если его нет.
     */
    public HuffmanNode getLeft(){
        return left;
    }

    /**
     * Возвращает правый дочерний узел.
     * @return Правый потомок или null, если его нет.
     */
    public HuffmanNode getRight(){
        return right;
    }

    /**
     * Возвращает символ узла.
     * @return Код символа (байт, расширенный до int).
     */
    public Integer getSymbol(){
        return symbol;
    }

    /**
     * Проверяет, является ли данный узел листом дерева Хаффмана.
     * Узел считается листом, если у него задан символ (symbol != null).
     * @return true, если символ задан и узел является листом; false в противном случае.
     */
    public boolean isLeaf() {
        return symbol != null;
    }
}