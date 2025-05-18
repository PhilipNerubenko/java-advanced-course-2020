package reflection_example;

import java.lang.reflect.Field;

public class Example3 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   * @throws NoSuchFieldException If the field is not found.
   * @throws SecurityException If a security violation occurred.
   * @throws IllegalArgumentException If the argument is not valid.
   * @throws IllegalAccessException If the field is not accessible.
   */
  public static void main(String[] args) throws NoSuchFieldException, SecurityException,
                                                IllegalArgumentException, IllegalAccessException {
    /**
     * Create a new Employee object.
     */
    Employee employee = new Employee(10, "Philip", "IT");
    /**
     * Get the Class object for the Employee class.
     */
    Class employeeClass = employee.getClass();
    /**
     * Get the Field object for the field with the name "salary".
     */
    Field field = employeeClass.getDeclaredField("salary");
    /**
     * Make the field accessible.
     */
    field.setAccessible(true);
    /**
     * Get the value of the field from the employee object.
     */
    double salaryValue = (double) field.get(employee);
    System.out.println(salaryValue);

    /**
     * Set the value of the field in the employee object.
     */
    field.set(employee, 1500);
    System.out.println(employee);
  }
}
