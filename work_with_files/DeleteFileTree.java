package work_with_files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFileTree {
  /**
   * Main method of the class. It deletes a file tree using a custom FileVisitor.
   * @param args Command line arguments (not used in this program)
   * @throws IOException If an I/O error occurs
   */
  public static void main(String[] args) throws IOException {
    Path removePath = Paths.get("work_with_files/CopyHere");
    Files.walkFileTree(removePath, new MyFileVisitor3());
  }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {
  /**
   * Method called when visiting a file.
   * @param arg0 The file path
   * @param arg1 The file's basic file attributes
   * @return FileVisitResult.CONTINUE to continue the file tree walk
   * @throws IOException If an I/O error occurs
   */
  @Override
  public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1) throws IOException {
    System.out.println("Delete name: " + arg0.getFileName());
    Files.delete(arg0);
    return FileVisitResult.CONTINUE;
  }

  /**
   * Method called after visiting a directory.
   * @param arg0 The directory path
   * @param arg1 The exception thrown, if any, while visiting the directory
   * @return FileVisitResult.CONTINUE to continue the file tree walk
   * @throws IOException If an I/O error occurs
   */
  @Override
  public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException {
    System.out.println("Delete directory: " + arg0.getFileName());
    Files.delete(arg0);
    return FileVisitResult.CONTINUE;
  }
}
