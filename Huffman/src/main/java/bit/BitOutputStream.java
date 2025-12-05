package bit;

import java.io.IOException;
import java.io.OutputStream;

public class BitOutputStream implements AutoCloseable {
    private OutputStream out;
    private int currentByte;
    private int numBitsFilled;


    /**
     * Поток для побитовой записи в байтовый OutputStream.
     * @param out Выходной байтовый поток, в который будут записываться биты.
     */
    public BitOutputStream(OutputStream out) {
        this.out = out;
        this.currentByte = 0;
        this.numBitsFilled = 0;
    }

    /**
     * Записывает один бит в поток.
     * @param bit Записываемый бит (0 или 1).
     * @exception IllegalArgumentException Если значение bit не равно 0 или 1.
     * @throws IOException В случае ошибок ввода-вывода при записи в поток.
     */
    public void writeBit(int bit) throws IOException {
        if (bit != 0 && bit != 1) throw new IllegalArgumentException("Бит должен быть 0 или 1");
        currentByte = (currentByte << 1) | bit;
        numBitsFilled++;
        if (numBitsFilled == 8) {
            out.write(currentByte);
            numBitsFilled = 0;
            currentByte = 0;
        }
    }



    /**
     * Записывает один байт (8 бит) в поток.
     * @param b Записываемый байт (0..255).
     * @throws IOException В случае ошибок ввода-вывода при записи в поток.
     */
    public void writeByte(int b) throws IOException {
        if (numBitsFilled == 0) {
            out.write(b);
        } else {
            for (int i = 7; i >= 0; i--) {
                writeBit((b >>> i) & 1);
            }
        }
    }


    /**
     * Сбрасывает буфер и дописывает неполный байт в поток.
     * @throws IOException В случае ошибок ввода-вывода при записи/сбросе.
     */
    public void flush() throws IOException {
        if (numBitsFilled > 0) {
            currentByte <<= (8 - numBitsFilled);
            out.write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
        out.flush();
    }

    /**
     * Возвращает исходный OutputStream.
     * @return Внутренний выходной поток, в который записываются данные.
     */
    public OutputStream getOut(){
        return out;
    }


    /**
     * Сбрасывает буфер и закрывает поток.
     * @throws IOException В случае ошибок при сбросе буфера или закрытии потока.
     */
    @Override
    public void close() throws IOException {
        flush();
        out.close();
    }
}