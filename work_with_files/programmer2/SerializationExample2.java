package work_with_files.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import work_with_files.programmer1.Employee;

public class SerializationExample2 {
  public static void main(String[] args) {
    Employee employee;
    try (ObjectInputStream ois =
             new ObjectInputStream(new FileInputStream("work_with_files/employee2.bin"))) {
      employee = (Employee) ois.readObject();
      System.out.println("Employee object deserialized successfully.");
      System.out.println("Employee details: " + employee);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
