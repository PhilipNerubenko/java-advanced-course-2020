package regex;

public class PrintfExample {
  /**
   * Method to print employee information.
   * @param emp The employee object
   */
  static void employeeInfo(Employee emp) {
    System.out.printf("%03d \t Hello %-12s \t %-12s \t %,.1f \n", emp.id, emp.name, emp.surname,
        emp.salary * (1 + emp.bonusPct));
  }

  /**
   * Main method of the class. It creates employee objects and prints their information.
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    Employee employee1 = new Employee(1, "Philip", "Nerubenko", 12345, 0.15);
    Employee employee2 = new Employee(15, "Ivan", "Petrov", 6542, 0.08);
    Employee employee3 = new Employee(123, "Mariya", "Sidorova", 8542, 0.12);
    employeeInfo(employee1);
    employeeInfo(employee2);
    employeeInfo(employee3);

    String newString = String.format(
        "%03d \t Hello %-12s \t %-12s \t %,.1f \n", 1, "Philip", "Nerubenko", 12345 * (1 + 0.15));
    System.out.println("\n" + newString);
  }
}

class Employee {
  int id; /**< Employee ID */
  String name; /**< Employee name */
  String surname; /**< Employee surname */
  int salary; /**< Employee salary */
  double bonusPct; /**< Employee bonus percentage */

  /**
   * Constructor of the class.
   * @param id Employee ID
   * @param name Employee name
   * @param surname Employee surname
   * @param salary Employee salary
   * @param bonusPct Employee bonus percentage
   */
  public Employee(int id, String name, String surname, int salary, double bonusPct) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.salary = salary;
    this.bonusPct = bonusPct;
  }
}
