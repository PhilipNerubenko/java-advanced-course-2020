package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesExample2 {
   /**
    * Main method of the class. It demonstrates various operations with files and directories using Path and Files classes.
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       Path filePath = Paths.get("/home/philip/Рабочий стол/Java projects/java-advanced-course-2020/work_with_files/test1.txt");
       Path directotyPath = Paths.get("/home/philip/Рабочий стол/Java projects/java-advanced-course-2020/work_with_files");

       try {
           // Copying a file to a directory with a new name
           Files.copy(filePath, directotyPath.resolve("test1.txt"),
           StandardCopyOption.REPLACE_EXISTING);

           // Copying a file to a directory with a new name
           Files.copy(filePath, directotyPath.resolve("test16.txt"),
           StandardCopyOption.REPLACE_EXISTING);

           // Copying a directory to a new location
           Files.copy(directotyPath, directotyPath.resolve("B(for_lesson_work_with_files)"));

           // Moving a file to a new location
           Files.move(Paths.get("work_with_files/test1.txt"), Paths.get("work_with_files/test12.txt"));

           // Deleting a file
           Files.delete(Paths.get("work_with_files/test16.txt"));
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}

