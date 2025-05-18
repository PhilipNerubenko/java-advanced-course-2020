package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesExample3 {
  /**
   * Main method of the class. It demonstrates writing to and reading from a file using Path and
   * Files classes.
   * @param args Command line arguments (not used in this program)
   * @throws IOException If an I/O error occurs
   */
  public static void main(String[] args) throws IOException {
    Path filePath = Paths.get("work_with_files/text10.txt");
    Files.createFile(filePath);
    String dialog = "-Hello\n-Hello\n-How are you?\n-Good! how are you?\n-Good too!";
    Files.write(filePath, dialog.getBytes());

    List<String> list = Files.readAllLines(filePath);
    list.stream().forEach(System.out::println);
  }
}
