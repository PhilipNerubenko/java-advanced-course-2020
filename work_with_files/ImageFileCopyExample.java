package work_with_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileCopyExample {
  /**
   * Main method of the class. It copies the content of one image file to another.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    try (FileInputStream fis = new FileInputStream("work_with_files/ImageForExample.png");
         FileOutputStream fos = new FileOutputStream("work_with_files/copyImage.png")) {
      // Reading and writing bytes one by one
      int i;
      while ((i = fis.read()) != -1) {
        fos.write(i);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
