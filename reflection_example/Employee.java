package reflection_example;

public class Employee {
  /**
   * ID of the employee.
   */
  public int id;

  /**
   * Name of the employee.
   */
  public String name;

  /**
   * Department of the employee.
   */
  public String department;

  /**
   * Salary of the employee.
   */
  private double salary = 1000;

  /**
   * Default constructor for the Employee class.
   */
  public Employee() {}

  /**
   * Constructor for the Employee class.
   * @param id ID of the employee.
   * @param name Name of the employee.
   * @param department Department of the employee.
   */
  public Employee(int id, String name, String department) {
    this.id = id;
    this.name = name;
    this.department = department;
  }

  /**
   * Constructor for the Employee class.
   * @param id ID of the employee.
   * @param name Name of the employee.
   * @param department Department of the employee.
   * @param salary Salary of the employee.
   */
  //    public Employee(int id, String name, String department, double salary) {
  //        this.id = id;
  //        this.name = name;
  //        this.department = department;
  //        this.salary = salary;
  //    }

  /**
   * Returns the salary of the employee.
   * @return Salary of the employee.
   */
  //    public double getSalary() {
  //        return salary;
  //    }

  /**
   * Sets the salary of the employee.
   * @param salary Salary of the employee.
   */
  //    public void setSalary(double salary) {
  //        this.salary = salary;
  //    }

  /**
   * Changes the department of the employee.
   * @param newDepartment New department of the employee.
   */
  private void changeDepartment(String newDepartment) {
    department = newDepartment;
    System.out.println("New department is: " + department);
  }

  /**
   * Increases the salary of the employee by a factor of 2.
   */
  public void increaseSalary() {
    salary *= 2;
  }

  /**
   * Returns a string representation of the employee.
   * @return String representation of the employee.
   */
  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", department=" + department
        + ", salary=" + salary + "]";
  }
}
