package work_with_files.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample1 {
  public static void main(String[] args) {
    List<String> employee = new ArrayList<>();
    employee.add("John Doe");
    employee.add("Jane Smith");
    employee.add("Alice Johnson");

    try (ObjectOutputStream oos =
             new ObjectOutputStream(new FileOutputStream("work_with_files/employee1.bin"))) {
      oos.writeObject(employee);
      System.out.println("Employee list serialized successfully.");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}