package structures;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FrequencyTable {
    private final Map<Integer, Integer> frequencyMap = new HashMap<>();


    /**
     * Таблица частот появления байтов в потоке.
     * @param input Поток байтов, по которому строится таблица частот.
     * @throws IOException В случае ошибок ввода-вывода при чтении потока.
     */
    public FrequencyTable(InputStream in) throws IOException {
        countFrequencies(in);
    }


    /**
     * Подсчитывает частоты появления байтов во входном потоке и обновляет frequencyMap.
     * @param in Входной поток, из которого читаются байты для подсчёта частот.
     * @throws IOException В случае ошибок ввода-вывода при чтении из потока.
     */
    private void countFrequencies(InputStream in) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }
    }


    /**
     * Возвращает отображение «символ → частота».
     * @return Map, где ключ — байтовое значение символа, значение — его частота.
     */
    public Map<Integer, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}
