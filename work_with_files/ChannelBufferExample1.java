package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

public class ChannelBufferExample1 {
  /**
   * Main method of the class. It reads and prints the content of a file using FileChannel and
   * ByteBuffer.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (RandomAccessFile file = new RandomAccessFile("work_with_files/FileForExample.txt", "rw");
         FileChannel channel = file.getChannel()) {
      // Increase buffer size to handle multi-byte characters better
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      StringBuilder stringBuilder = new StringBuilder();

      // Configure decoder to handle incomplete characters
      CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder()
                                   .onMalformedInput(CodingErrorAction.REPLACE)
                                   .onUnmappableCharacter(CodingErrorAction.REPLACE);

      int bytesRead = channel.read(buffer);
      while (bytesRead != -1) {
        System.out.println("Read " + bytesRead);

        buffer.flip(); // switch from writing to reading mode

        // Decode complete buffer at once
        CharBuffer charBuffer = decoder.decode(buffer);
        stringBuilder.append(charBuffer);

        buffer.clear(); // switch from reading to writing mode
        bytesRead = channel.read(buffer);
      }

      System.out.println(stringBuilder.toString());

      String text = "\nЭто строка будет записана в файл";

      // The first way to write to a file
      ByteBuffer writeBuffer = ByteBuffer.allocate(text.getBytes().length);
      writeBuffer.put(text.getBytes());

      writeBuffer.flip(); // switch from writing to reading mode

      channel.write(writeBuffer);

      // The second way to write to a file
      ByteBuffer writeBuffer2 = ByteBuffer.wrap(text.getBytes());
      channel.write(writeBuffer2);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
