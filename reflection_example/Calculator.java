package reflection_example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
  /**
   * Prints the sum of two integers.
   * @param a First integer.
   * @param b Second integer.
   */
  void sum(int a, int b) {
    System.out.println("The sum is: " + (a + b));
  }
  /**
   * Prints the subtraction of two integers.
   * @param a First integer.
   * @param b Second integer.
   */
  void sub(int a, int b) {
    System.out.println("The subtraction is: " + (a - b));
  }
  /**
   * Prints the multiplication of two integers.
   * @param a First integer.
   * @param b Second integer.
   */
  void mul(int a, int b) {
    System.out.println("The multiplication is: " + (a * b));
  }
  /**
   * Prints the division of two integers.
   * @param a First integer.
   * @param b Second integer.
   */
  void div(int a, int b) {
    System.out.println("The division is: " + (a / b));
  }
}

class TetsCalculator {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    try (BufferedReader br =
             new BufferedReader(new FileReader("reflection_example/FileForCalculator.txt"))) {
      /**
       * Read the method name, first argument, and second argument from the file.
       */
      String methodName = br.readLine();
      String firstArgument = br.readLine();
      String secondArgument = br.readLine();

      /**
       * Create a new Calculator object.
       */
      Calculator calculator = new Calculator();
      /**
       * Get the Class object for the Calculator class.
       */
      Class cl = calculator.getClass();
      /**
       * Get the Method object for the method with the name methodName.
       */
      Method method = null;
      Method[] methods = cl.getDeclaredMethods();
      for (Method value : methods) {
        if (value.getName().equals(methodName)) {
          method = value;
        }
      }
      /**
       * Invoke the method with the first argument and second argument.
       */
      method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
