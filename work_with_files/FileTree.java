package work_with_files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTree {
  /**
   * Main method of the class. It walks a file tree using a custom FileVisitor.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    Path path = Paths.get("work_with_files/X");
    try {
      Files.walkFileTree(path, new MyFileVisitor());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class MyFileVisitor implements FileVisitor<Path> {
  /**
   * Method called after visiting a directory.
   * @param arg0 The directory path
   * @param arg1 The exception thrown, if any, while visiting the directory
   * @return FileVisitResult.CONTINUE to continue the file tree walk
   * @throws IOException If an I/O error occurs
   */
  @Override
  public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException {
    System.out.println("Exit from Directory: " + arg0);
    return FileVisitResult.CONTINUE;
  }

  /**
   * Method called before visiting a directory.
   * @param arg0 The directory path
   * @param arg1 The directory's basic file attributes
   * @return FileVisitResult.CONTINUE to continue the file tree walk
   * @throws IOException If an I/O error occurs
   */
  @Override
  public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {
    System.out.println("Enter to Directory: " + arg0);
    return FileVisitResult.CONTINUE;
  }

  /**
   * Method called when visiting a file.
   * @param arg0 The file path
   * @param arg1 The file's basic file attributes
   * @return FileVisitResult.CONTINUE to continue the file tree walk
   * @throws IOException If an I/O error occurs
   */
  @Override
  public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1) throws IOException {
    System.out.println("File name: " + arg0.getFileName());
    return FileVisitResult.CONTINUE;
  }

  /**
   * Method called when a file could not be visited.
   * @param arg0 The file path
   * @param arg1 The exception thrown while visiting the file
   * @return FileVisitResult.TERMINATE to terminate the file tree walk
   * @throws IOException If an I/O error occurs
   */
  @Override
  public FileVisitResult visitFileFailed(Path arg0, IOException arg1) throws IOException {
    System.out.println("Error while visiting file: " + arg0 + " " + arg1.getMessage());
    return FileVisitResult.TERMINATE;
  }
}
