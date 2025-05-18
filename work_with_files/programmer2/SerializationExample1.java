package work_with_files.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample1 {
  public static void main(String[] args) {
    List<String> employee;
    try (ObjectInputStream ois =
             new ObjectInputStream(new FileInputStream("work_with_files/employee1.bin"))) {
      employee = (ArrayList) ois.readObject();
      System.out.println("Employee list deserialized successfully.");
      System.out.println("Employee list: " + employee);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
