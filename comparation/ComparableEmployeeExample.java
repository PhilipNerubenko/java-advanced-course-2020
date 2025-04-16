package comparation;

import java.util.*;

/**
* Class ComparableEmployeeExample demonstrates sorting a list of EmployeeComparable objects using the Collections.sort() method.
*/
public class ComparableEmployeeExample {
   public static void main(String[] args) {
       List<EmployeeComparable> employees = new ArrayList<>();
       EmployeeComparable e1 = new EmployeeComparable(100, "John", "Doe", 50000);
       EmployeeComparable e2 = new EmployeeComparable(15, "Jane", "Smith", 60000);
       EmployeeComparable e3 = new EmployeeComparable(123, "Jane", "Johnson", 55000);

       /**
        * Sorts an array of EmployeeComparable objects using the Arrays.sort() method.
        * If there is no implementation of Comparable, it will throw a ClassCastException in Runtime.
        */
       Arrays.sort(new EmployeeComparable[] { e1, e2, e3 });
       
       employees.add(e1);
       employees.add(e2);
       employees.add(e3);

       System.out.println("Before sorting: " + employees);
       
       /**
        * Sorts the list of EmployeeComparable objects using the Collections.sort() method.
        */
       Collections.sort(employees);
       
       System.out.println("After sorting: " + employees);
   }
}


/**
* Class EmployeeComparable implements Comparable<EmployeeComparable> to compare EmployeeComparable objects based on their id.
*/
class EmployeeComparable implements Comparable<EmployeeComparable> {
   int id;
   // Integer id; // for third way to write
   String name;
   String surname;
   int salary;
   
   /**
    * Constructor for EmployeeComparable.
    * @param id the id of the employee.
    * @param name the name of the employee.
    * @param surname the surname of the employee.
    * @param salary the salary of the employee.
    */
   public EmployeeComparable(int id, String name, String surname, int salary) {
       this.id = id;
       this.name = name;
       this.surname = surname;
       this.salary = salary;
   }

   @Override
   /**
    * Returns a string representation of the EmployeeComparable object.
    * @return a string representation of the EmployeeComparable object.
    */
   public String toString() {
       return "EmployeeComparable [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
   }

   // First way to write
   @Override
   /**
    * Compares this EmployeeComparable object with the specified EmployeeComparable object for order.
    * @param anotherEmployee the EmployeeComparable object to be compared.
    * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
    */
   public int compareTo(EmployeeComparable anotherEmployee) {
      if (this.id < anotherEmployee.id) {
           return -1;
       } else if (this.id > anotherEmployee.id) {
           return 1;
       } else {
           return 0;
       }
   }

//    // Second way to write
//    @Override
//    /**
//     * Compares this EmployeeComparable object with the specified EmployeeComparable object for order.
//     * @param anotherEmployee the EmployeeComparable object to be compared.
//     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
//     */
//    public int compareTo(EmployeeComparable anotherEmployee) {
//        return this.id - anotherEmployee.id;
//    }

//    // Third way to write
//    @Override
//    /**
//     * Compares this EmployeeComparable object with the specified EmployeeComparable object for order.
//     * @param anotherEmployee the EmployeeComparable object to be compared.
//     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
//     */
//    public int compareTo(EmployeeComparable anotherEmployee) {
//        return this.id.compareTo(anotherEmployee.id);
//    }

//    // Fourth way to write
//    @Override
//    /**
//     * Compares this EmployeeComparable object with the specified EmployeeComparable object for order.
//     * @param anotherEmployee the EmployeeComparable object to be compared.
//     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
//     */
//    public int compareTo(EmployeeComparable anotherEmployee) {
//        int res = this.name.compareTo(anotherEmployee.name);
//        if (res == 0) {
//            res = this.surname.compareTo(anotherEmployee.surname);
//        }
//        return res;
//    }
}
