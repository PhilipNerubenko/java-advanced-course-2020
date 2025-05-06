package work_with_files;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriterExample {
  /**
   * Main method of the class. It writes text to a file.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    String rubai = "Много лет размышлял я над жизнью земной.\n"
        + "Непонятного нет для меня под луной.\n"
        + "Мне известно, что мне ничего не известно!\n"
        + "Вот последняя правда, открытая мной.\n";
    String s = "Привет";

    try (FileWriter fileWriter = new FileWriter("work_with_files/FileForExample.txt", true)) {
      // Writing characters one by one
      for (int i = 0; i < rubai.length(); i++) {
        fileWriter.write(rubai.charAt(i));
      }

      // Writing strings
      fileWriter.write(rubai);
      fileWriter.write(s);

      System.out.println("Запись завершена");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
