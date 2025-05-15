package reflection_example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Example1 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   * @throws ClassNotFoundException If the class is not found.
   * @throws NoSuchFieldException If the field is not found.
   * @throws SecurityException If a security violation occurred.
   * @throws NoSuchMethodException If the method is not found.
   */
  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException,
                                                SecurityException, NoSuchMethodException {
    /**
     * Get the Class object for the Employee class.
     */
    Class employeeClass = Class.forName("reflection_example.Employee");

    /**
     * Get the Class object for the Employee class.
     */
    Class employeeClass2 = Employee.class;

    /**
     * Create a new Employee object.
     */
    Employee employee = new Employee();
    /**
     * Get the Class object for the Employee class.
     */
    Class employeeClass3 = employee.getClass();

    /**
     * Get the Field object for the field with the name "id".
     */
    Field someField = employeeClass.getField("id");
    System.out.println("Type of id field = " + someField.getType());
    System.out.println("**********************\n");

    /**
     * Get an array of all the public fields of the Employee class.
     */
    Field[] fields = employeeClass.getFields();
    for (Field field : fields) {
      System.out.println("Type of " + field.getName() + " = " + field.getType());
    }
    System.out.println("**********************\n");

    /**
     * Get an array of all the fields of the Employee class.
     */
    Field[] allFields = employeeClass.getDeclaredFields();
    for (Field field : allFields) {
      System.out.println("Type of " + field.getName() + " = " + field.getType());
    }
    System.out.println("**********************\n");

    /**
     * Get the Method object for the method with the name "increaseSalary".
     */
    Method someMethod1 = employeeClass.getMethod("increaseSalary");
    System.out.println("Return type of method increaseSalary = " + someMethod1.getReturnType()
        + ", parameter types = " + Arrays.toString(someMethod1.getParameterTypes()));
    System.out.println("**********************\n");

    /**
     * Get the Method object for the method with the name "setSalary" and parameter type double.
     */
    Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
    System.out.println("Return type of method setSalary = " + someMethod2.getReturnType()
        + ", parameter types = " + Arrays.toString(someMethod2.getParameterTypes()));
    System.out.println("**********************\n");

    /**
     * Get an array of all the public methods of the Employee class.
     */
    Method[] methods = employeeClass.getMethods();
    for (Method method : methods) {
      System.out.println("Method name = " + method.getName()
          + ", return type = " + method.getReturnType()
          + ", parameter types = " + Arrays.toString(method.getParameterTypes()));
    }
    System.out.println("**********************\n");

    /**
     * Get an array of all the methods of the Employee class.
     */
    Method[] AllMethods = employeeClass.getDeclaredMethods();
    for (Method method : AllMethods) {
      System.out.println("Method name = " + method.getName()
          + ", return type = " + method.getReturnType()
          + ", parameter types = " + Arrays.toString(method.getParameterTypes()));
    }
    System.out.println("**********************\n");

    /**
     * Get an array of all the public methods of the Employee class.
     */
    Method[] AllMethods2 = employeeClass.getDeclaredMethods();
    for (Method method : AllMethods2) {
      if (Modifier.isPublic(method.getModifiers()))
        System.out.println("Method name = " + method.getName()
            + ", return type = " + method.getReturnType()
            + ", parameter types = " + Arrays.toString(method.getParameterTypes()));
    }
    System.out.println("**********************\n");

    /**
     * Get the Constructor object for the constructor with no parameters.
     */
    Constructor constructor1 = employeeClass.getConstructor();
    System.out.println("Constructor has " + constructor1.getParameterCount()
        + " parameter(s), parameter types = "
        + Arrays.toString(constructor1.getParameterTypes()));
    System.out.println("**********************\n");

    /**
     * Get the Constructor object for the constructor with parameters int, String, and String.
     */
    Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
    System.out.println("Constructor has " + constructor2.getParameterCount()
        + " parameter(s), parameter types = "
        + Arrays.toString(constructor2.getParameterTypes()));
    System.out.println("**********************\n");

    /**
     * Get an array of all the public constructors of the Employee class.
     */
    Constructor[] allConstructor = employeeClass.getConstructors();
    for (Constructor constructor : allConstructor) {
      System.out.println("Constructor " + constructor.getName() + " Constructor has "
          + constructor.getParameterCount() + " parameter(s), parameter types = "
          + Arrays.toString(constructor.getParameterTypes()));
    }
    System.out.println("**********************\n");
  }
}
