import bit.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import structures.*;
import utils.IOhelpers;


public class Main {

    public static void main(String[] args) {
        try {
            checkArguments(args);

            String mode = args[0];
            String filename = args[1];

            if (mode.equals("-co")) {
                compress(filename, filename + ".huff");
                System.err.println("OKey");
            } else if (mode.equals("-deco")) {
                decompress(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

static void compress(String inputFile, String outputFile) throws IOException {
    try (FileInputStream fis = new FileInputStream(inputFile);
         FileOutputStream fos = new FileOutputStream(outputFile);
         BitOutputStream bos = new BitOutputStream(fos)) {

        byte[] filenameBytes = inputFile.getBytes(StandardCharsets.UTF_8);
        IOhelpers.writeInt(bos, filenameBytes.length);
        for (byte b : filenameBytes) {
            IOhelpers.writeByte(bos, b);
        }

        long size = fis.getChannel().size();
        IOhelpers.writeInt(bos, (int) size);   

        FrequencyTable freqTable = new FrequencyTable(fis);
        HuffmanTree tree = new HuffmanTree(freqTable.getFrequencyMap());
        HuffmanCoder coder = new HuffmanCoder(tree);

        tree.writeTree(bos);
        fis.getChannel().position(0);
        coder.encode(fis, bos);

        System.out.println("Сжатие завершено: " + outputFile);
    }
}


static void decompress(String inputFile) throws IOException {
    try (FileInputStream fis = new FileInputStream(inputFile);
         BitInputStream bis = new BitInputStream(fis)) {

        int filenameLength = IOhelpers.readInt(bis);
        byte[] filenameBytes = new byte[filenameLength];
        for (int i = 0; i < filenameLength; i++) {
            filenameBytes[i] = (byte) IOhelpers.readByte(bis);
        }
        String originalFilename = new String(filenameBytes, StandardCharsets.UTF_8);

        int originalSize = IOhelpers.readInt(bis);  

        HuffmanTree tree = HuffmanTree.readTree(bis);

        try (FileOutputStream fos = new FileOutputStream(originalFilename)) {
            HuffmanNode node = tree.getRoot();
            int written = 0;

            while (written < originalSize) {
                int bit = bis.readBit();
                if (bit == -1) break;  

                node = (bit == 0) ? node.getLeft() : node.getRight();
                if (node.isLeaf()) {
                    fos.write(node.getSymbol());
                    written++;
                    node = tree.getRoot();
                }
            }
        }

        System.out.println("Распаковка завершена: " + originalFilename);
    }
}



static void checkArguments(String[] args) {
    int argsAmount = args.length;
    if (argsAmount != 2) {
        throw new IllegalArgumentException("Недостаточно аргументов!");
    }
    String arg = args[0];
    if (!arg.equals("-co") && !arg.equals("-deco")) {
        throw new IllegalArgumentException("Режим указан неправильно!");
    }
    String file = args[1];
    File f = new File(file);
    if (!f.exists()) {
        throw new IllegalArgumentException("Файл не найден!");
    }
}
}


