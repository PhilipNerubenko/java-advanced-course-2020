package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PathAndFilesExample1 {
  /**
   * Main method of the class. It demonstrates various operations with files and directories using
   * Path and Files classes.
   * @param args Command line arguments (not used in this program)
   * @throws IOException If an I/O error occurs
   */
  public static void main(String[] args) throws IOException {
    Path filePath = Paths.get("work_with_files/test1.txt");
    Path directotyPath = Paths.get(
        "/home/philip/Рабочий стол/Java projects/java-advanced-course-2020/work_with_files");

    // Printing file and directory names
    System.out.println("filePath.getFileName() " + filePath.getFileName());
    System.out.println("directotyPath.getFileName() " + directotyPath.getFileName());

    // Printing parent directories
    System.out.println("\nfilePath.getParent() " + filePath.getParent());
    System.out.println("directotyPath.getParent() " + directotyPath.getParent());

    // Printing root directories
    System.out.println("\nfilePath.getRoot() " + filePath.getRoot());
    System.out.println("directotyPath.getRoot() " + directotyPath.getRoot());

    // Checking if the file and directory are absolute paths
    System.out.println("\nfilePath.isAbsolute() " + filePath.isAbsolute());
    System.out.println("directotyPath.isAbsolute() " + directotyPath.isAbsolute());

    // Printing absolute paths of the file and directory
    System.out.println("\nfilePath.toAbsolutePath() " + filePath.toAbsolutePath());
    System.out.println("directotyPath.toAbsolutePath() " + directotyPath.toAbsolutePath());

    // Printing parent and root directories of the absolute paths
    System.out.println(
        "\nfilePath.toAbsolutePath().getParent() " + filePath.toAbsolutePath().getParent());
    System.out.println(
        "filePath.toAbsolutePath().getRoot() " + filePath.toAbsolutePath().getRoot());

    // Resolving a file path relative to a directory path
    System.out.println("\ndirectoryPath.resolve(filePath) " + directotyPath.resolve(filePath));

    // Resolving a relative path between two paths
    Path anotherPath = Paths.get("/home/philip/Рабочий стол/Java "
        + "projects/java-advanced-course-2020/work_with_files/N/Z/test20.txt");
    System.out.println(
        "\ndirectoryPath.relativize(anotherPath) " + directotyPath.relativize(anotherPath));

    // Creating a file and directory if they don't exist
    if (!Files.exists(filePath)) {
      Files.createFile(filePath);
    }

    if (!Files.exists(directotyPath)) {
      Files.createDirectory(directotyPath);
    }

    // Checking if the file is readable, writable and executable
    System.out.println("\nFiles.isReadable(filePath) " + Files.isReadable(filePath));
    System.out.println("Files.isWritable(filePath) " + Files.isWritable(filePath));
    System.out.println("Files.isExecutable(filePath) " + Files.isExecutable(filePath));

    // Checking if two file paths are the same and getting file size
    Path filePath2 = Paths.get("/home/philip/Рабочий стол/Java "
        + "projects/java-advanced-course-2020/work_with_files/test1.txt");
    System.out.println(
        "\nFiles.isSameFile(filePath, filePath2) " + Files.isSameFile(filePath, filePath2));
    System.out.println("Files.size(filePath) " + Files.size(filePath));
    System.out.println("Files.getAtribute(filePath, \"basic:size\") "
        + Files.getAttribute(filePath, "basic:size"));

    // Reading and printing file attributes
    Map<String, Object> attributes = Files.readAttributes(filePath, "*");
    for (Map.Entry<String, Object> entry : attributes.entrySet()) {
      System.out.println(
          "Files.readAttributes(filePath, \"*\") " + entry.getKey() + " : " + entry.getValue());
    }
  }
}
