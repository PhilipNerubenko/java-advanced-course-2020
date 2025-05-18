package work_with_files.programmer1;

import java.io.Serializable;

public class Employee implements Serializable {
  static final long serialVersionUID = 2L;
  String name;
  String surname;
  String department;
  int age;
  transient double salary;
  Car car;

  public Employee(String name, String surname, String department,
      // int age,
      double salary, Car car) {
    this.name = name;
    this.surname = surname;
    this.department = department;
    // this.age = age;
    this.salary = salary;
    this.car = car;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", surname=" + surname + ", department=" + department +
        // ", age=" + age +
        ", car=" + car + "]";
  }
}
