package bit;

import java.io.IOException;
import java.io.InputStream;

public class BitInputStream implements AutoCloseable {
    private InputStream in;
    private int currentByte;
    private int numBitsRemaining;

    /**
     * Поток для побитового чтения из байтового InputStream.
     * @param in Входной байтовый поток, из которого будут читаться биты.
     */
    public BitInputStream(InputStream in) {
        this.in = in;
        this.currentByte = 0;
        this.numBitsRemaining = 0;
    }

    /**
     * Читает один бит из потока.
     * @return Прочитанный бит (0 или 1), либо -1 при достижении конца потока.
     * @throws IOException В случае ошибок ввода-вывода при чтении из потока.
     */
    public int readBit() throws IOException {
        if (numBitsRemaining == 0) {
            currentByte = in.read();
            if (currentByte == -1) return -1;
            numBitsRemaining = 8;
        }
        numBitsRemaining--;
        return (currentByte >>> numBitsRemaining) & 1;
    }


    /**
     * Читает один байт (8 бит) из потока.
     * @return Прочитанный байт в виде int (0..255) либо -1 при достижении конца потока.
     * @throws IOException В случае ошибок ввода-вывода при чтении из потока.
     */    
    public int readByte() throws IOException {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int bit = readBit();
            if (bit == -1) return -1;
            result = (result << 1) | bit;
        }
        return result;
    }


    /**
     * Возвращает исходный InputStream.
     * @return Внутренний входной поток, из которого читаются данные.
     */
    public InputStream getIn(){
        return getIn();
    }


    /**
     * Закрывает поток и освобождает связанные ресурсы.
     * @throws IOException В случае ошибок при закрытии потока.
     */
    @Override
    public void close() throws IOException {
        in.close();
    }
}