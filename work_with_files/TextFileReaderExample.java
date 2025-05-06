package work_with_files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReaderExample {
  /**
   * Main method of the class. It reads and prints the content of a text file.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (FileReader fileReader = new FileReader("work_with_files/FileForExample.txt");) {
      // Reading and printing characters one by one
      int character;
      while ((character = fileReader.read()) != -1) {
        System.out.print((char) character);
      }
      System.out.println();
      System.out.println("Чтение завершено");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
