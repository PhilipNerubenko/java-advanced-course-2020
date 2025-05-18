package work_with_files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {
  /**
   * Main method of the class. It demonstrates various operations with files and directories.
   * @param args Command line arguments (not used in this program)
   * @throws IOException If an I/O error occurs
   */
  public static void main(String[] args) throws IOException {
    // Creating File objects for a file and directories
    File file = new File("work_with_files/FileForExample.txt");
    File folder = new File("/home/philip/Рабочий стол/Java "
        + "projects/java-advanced-course-2020/work_with_files/"
        + "for_work_with_directory_class_file_example");
    File folder2 = new File("/home/philip/Рабочий стол/Java "
        + "projects/java-advanced-course-2020/work_with_files/"
        + "for_work_with_directory_class_file_example2");
    File file2 = new File("/home/philip/Рабочий стол/Java "
        + "projects/java-advanced-course-2020/work_with_files/"
        + "for_work_with_directory_class_file_example/test20.txt");

    // Printing absolute paths of the file and directories
    System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
    System.out.println("folder.getAbsolutePath() " + folder.getAbsolutePath());

    // Checking if the file and directories are absolute paths
    System.out.println("\nfile.isAbsolute() " + file.isAbsolute());
    System.out.println("folder.isAbsolute() " + folder.isAbsolute());

    // Checking if the file and directories are directories
    System.out.println("\nfile.isDirectory() " + file.isDirectory());
    System.out.println("folder.isDirectory() " + folder.isDirectory());

    // Checking if the file and directories exist
    System.out.println("\nfile.exists() " + file.exists());
    System.out.println("folder.exists() " + folder.exists());
    System.out.println("folder2.exists() " + folder2.exists());
    System.out.println("file2.exists() " + file2.exists());

    // Creating a new file and directory
    System.out.println("\nfile2.createNewFile() " + file2.createNewFile());
    System.out.println("folder2.mkdir() " + folder2.mkdir());

    // Printing the length of the file and directories
    System.out.println("\nfile.legth() " + file.length());
    System.out.println("folder.legth() " + folder.length());
    System.out.println("folder2.legth() " + folder2.length());
    System.out.println("file2.legth() " + file2.length());

    // Listing files in the directory
    File[] files = folder.listFiles();
    System.out.println("\nfolder.listFiles() " + Arrays.toString(files));

    // Checking if the file is hidden
    System.out.println("\nfile.isHidden() " + file.isHidden());

    // Checking if the file can be read
    System.out.println("\nfile.canRead() " + file.canRead());

    // Checking if the file can be written
    System.out.println("\nfile.canWrite() " + file.canWrite());

    // Checking if the file can be executed
    System.out.println("\nfile.canExecute() " + file.canExecute());

    // Deleting the directory and file
    System.out.println("\nfolder.delete() " + folder.delete());
    System.out.println("file2.delete() " + file2.delete());
    System.out.println("folder2.delete() " + folder2.delete());
    System.out.println("folder.delete() " + folder.delete());
  }
}
