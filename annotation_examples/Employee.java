package annotation_examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation
public class Employee {
  /**
   * Name of the employee.
   */
  String name;

  /**
   * Salary of the employee.
   */
  double salary;

  /**
   * Constructor for the Employee class.
   * @param name Name of the employee.
   * @param salary Salary of the employee.
   */
  public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
  }

  /**
   * Increases the salary of the employee by a factor of 2.
   */
  @MyAnnotation
  public void increaseSalary() {
    salary *= 2;
  }

  /**
   * Returns a string representation of the employee.
   * @return String representation of the employee.
   */
  @Override
  public String toString() {
    return "Employee [name=" + name + ", salary=" + salary + "]";
  }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {}