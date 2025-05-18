package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileExample {
  /**
   * Main method of the class. It reads and writes text to a file using RandomAccessFile.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (RandomAccessFile raf = new RandomAccessFile("work_with_files/FileForExample.txt", "rw")) {
      // Reading text from the file
      byte[] bytes = new byte[256];
      int count = raf.read(bytes);
      String text = new String(bytes, 0, count, StandardCharsets.UTF_8);
      System.out.println("Прочитанный текст: " + text);

      // Writing text to the end of the file
      raf.seek(raf.length());
      String russianText = "\nПривет, мир!";
      raf.write(russianText.getBytes(StandardCharsets.UTF_8));

      // Reading text from a specific position in the file
      raf.seek(101);
      bytes = new byte[256];
      count = raf.read(bytes);
      String textFromPosition = new String(bytes, 0, count, StandardCharsets.UTF_8);
      System.out.println("Текст с позиции 101: " + textFromPosition);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
