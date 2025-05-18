package work_with_files.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample2 {
  public static void main(String[] args) {
    Car car = new Car("Toyota", "Red");
    Employee employee = new Employee("John", "Doe", "IT",
        // 28,
        50000, car);

    try (ObjectOutputStream oos =
             new ObjectOutputStream(new FileOutputStream("work_with_files/employee2.bin"))) {
      oos.writeObject(employee);
      System.out.println("Employee object serialized successfully.");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
