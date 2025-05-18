package reflection_example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Example2 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   * @throws ClassNotFoundException If the class is not found.
   * @throws InstantiationException If the class cannot be instantiated.
   * @throws IllegalAccessException If the constructor is not accessible.
   * @throws NoSuchMethodException If the method is not found.
   * @throws SecurityException If a security violation occurred.
   * @throws IllegalArgumentException If the argument is not valid.
   * @throws InvocationTargetException If the method invocation fails.
   */
  public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
                                                IllegalAccessException, NoSuchMethodException,
                                                SecurityException, IllegalArgumentException,
                                                InvocationTargetException {
    /**
     * Get the Class object for the Employee class.
     */
    Class employeeClass = Class.forName("reflection_example.Employee");

    // in earlier versions of java up to 11, deprecated
    /**
     * Create a new instance of the Employee class.
     */
    Object o = (Employee) employeeClass.newInstance();
    System.out.println(o);

    // recommended
    /**
     * Get the Constructor object for the constructor with no parameters.
     */
    Constructor<Employee> constructor1 = employeeClass.getConstructor();
    /**
     * Create a new instance of the Employee class using the constructor.
     */
    Employee o2 = constructor1.newInstance();

    /**
     * Get the Constructor object for the constructor with parameters int, String, and String.
     */
    Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
    /**
     * Create a new instance of the Employee class using the constructor.
     */
    Object o3 = constructor2.newInstance(5, "Philip", "IT");
    System.out.println(o3);

    /**
     * Get the Method object for the method with the name "setSalary" and parameter type double.
     */
    Method method = employeeClass.getMethod("setSalary", double.class);
    /**
     * Invoke the method on the object o3 with the argument 800.88.
     */
    method.invoke(o3, 800.88);
    System.out.println(o3);
  }
}
