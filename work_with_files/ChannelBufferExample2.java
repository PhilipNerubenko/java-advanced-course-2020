package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample2 {
  /**
   * Main method of the class. It reads and prints the content of a file using FileChannel and
   * ByteBuffer.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (RandomAccessFile raf = new RandomAccessFile("work_with_files/FileForExample2.txt", "rw");
         FileChannel channel = raf.getChannel();) {
      ByteBuffer buffer = ByteBuffer.allocate(5);

      channel.read(buffer);
      buffer.flip(); // switch from writing to reading mode

      System.out.println((char) buffer.get());
      System.out.println((char) buffer.get());
      System.out.println((char) buffer.get());

      buffer.rewind();

      System.out.println((char) buffer.get());

      System.out.println();

      buffer.compact();
      channel.read(buffer);
      buffer.flip(); // switch from writing to reading mode

      while (buffer.hasRemaining()) {
        System.out.print((char) buffer.get());
      }
      System.out.println();

      buffer.clear();
      channel.read(buffer);
      buffer.flip(); // switch from writing to reading mode

      System.out.println((char) buffer.get());
      buffer.mark();
      System.out.println((char) buffer.get());
      System.out.println((char) buffer.get());
      buffer.reset();
      while (buffer.hasRemaining()) {
        System.out.print((char) buffer.get());
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
