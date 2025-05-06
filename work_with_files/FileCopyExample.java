package work_with_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyExample {
  /**
   * Main method of the class. It copies the content of one file to another.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (BufferedReader reader =
             new BufferedReader(new FileReader("work_with_files/FileForExample.txt"));
         BufferedWriter writer =
             new BufferedWriter(new FileWriter("work_with_files/FileForExample2.txt"))) {
      // Reading and writing characters one by one
      int character;
      while ((character = reader.read()) != -1) {
        writer.write(character);
      }

      // Reading and writing lines one by one
      String line;
      while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.newLine();
      }
      System.out.println("File copied successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
