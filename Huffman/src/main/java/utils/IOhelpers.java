package utils;

import bit.*;
import java.io.IOException;

public class IOhelpers{


    /**
     * Записывает 32-битное целое число побитово (от старшего к младшему).
     * @param bos Поток для побитовой записи.
     * @param value Значение int, которое нужно записать.
     * @throws IOException В случае ошибок ввода-вывода при записи.
     */
    public static void writeInt(BitOutputStream bos, int value) throws IOException {
        for (int i = 31; i >= 0; i--) {
            bos.writeBit((value >> i) & 1);
        }
    }

    /**
     * Записывает один байт побитово (от старшего к младшему).
     * @param bos Поток для побитовой записи.
     * @param value Байтовое значение, которое нужно записать.
     * @throws IOException В случае ошибок ввода-вывода при записи.
     */
    public static void writeByte(BitOutputStream bos, byte value) throws IOException {
        for (int i = 7; i >= 0; i--) {
            bos.writeBit((value >> i) & 1);
        }
    }

    /**
     * Читает 32-битное целое число, записанное побитово.
     * @param bis Поток для побитового чтения.
     * @return Прочитанное значение типа int.
     * @exception IOException При недостатке данных для полного чтения int.
     * @throws IOException В случае ошибок ввода-вывода или неполных данных.
     */
    public static int readInt(BitInputStream bis) throws IOException {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = bis.readBit();
            if (bit == -1) throw new IOException("Неполные данные для int");
            result |= (bit << i);
        }
        return result;
    }


    /**
     * Читает один байт, записанный побитово.
     * @param bis Поток для побитового чтения.
     * @return Прочитанный байт в виде int (0..255).
     * @exception IOException При недостатке данных для полного чтения байта.
     * @throws IOException В случае ошибок ввода-вывода или неполных данных.
    */
    public static int readByte(BitInputStream bis) throws IOException {
        int result = 0;
        for (int i = 7; i >= 0; i--) {
            int bit = bis.readBit();
            if (bit == -1) throw new IOException("Неполные данные для байта");
            result |= (bit << i);
        }
        return result;
    }
}