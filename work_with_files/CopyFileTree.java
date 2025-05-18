package work_with_files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFileTree {
  /**
   * Main method of the class. It copies a file tree using a custom FileVisitor.
   * @param args Command line arguments (not used in this program)
   * @throws IOException If an I/O error occurs
   */
  public static void main(String[] args) throws IOException {
    Path sourcePath = Paths.get("work_with_files/X");
    Path destinationPath = Paths.get("work_with_files/CopyHere");
    Files.walkFileTree(sourcePath, new MyFileVisitor2(sourcePath, destinationPath));
    System.out.println("Done!");
  }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
  Path source;
  Path destination;

  /**
   * Constructor of the class.
   * @param source The source path
   * @param destination The destination path
   */
  public MyFileVisitor2(Path source, Path destination) {
    this.source = source;
    this.destination = destination;
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
    Path newDestination = destination.resolve(source.relativize(arg0));
    Files.copy(arg0, newDestination, StandardCopyOption.REPLACE_EXISTING);
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
    Path newDestination = destination.resolve(source.relativize(arg0));
    Files.copy(arg0, newDestination, StandardCopyOption.REPLACE_EXISTING);
    return FileVisitResult.CONTINUE;
  }
}
