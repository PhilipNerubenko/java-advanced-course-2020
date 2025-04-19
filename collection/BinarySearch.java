package collection;

import java.util.*;

/**
 * Class BinarySearch demonstrates the usage of binary search in Java.
 */
public class BinarySearch {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(-2);
    list.add(8);
    list.add(7);
    list.add(5);
    list.add(-4);
    list.add(-6);
    list.add(3);
    list.add(9);
    list.add(0);

    int index = Collections.binarySearch(list, 5);
    System.out.println("Index of 5: " + index);

    Collections.sort(list);
    System.out.println("Sorted list: " + list);

    index = Collections.binarySearch(list, 5);
    System.out.println("Index of 5 after sorting: " + index);

    index = Collections.binarySearch(list, 10);
    System.out.println("Index of 10: " + index);

    Collections.reverse(list);
    System.out.println("Reversed list: " + list);

    Collections.shuffle(list);
    System.out.println("Shuffled list: " + list);

    System.out.println();

    ArrayList<EmployeeBinarySearch> empList = new ArrayList<>();
    empList.add(new EmployeeBinarySearch(100, "John", 5000));
    empList.add(new EmployeeBinarySearch(15, "Jane", 6000));
    empList.add(new EmployeeBinarySearch(123, "Jack", 7000));
    empList.add(new EmployeeBinarySearch(15, "Jill", 8000));
    empList.add(new EmployeeBinarySearch(182, "Joe", 9000));
    empList.add(new EmployeeBinarySearch(15, "Jim", 10000));
    empList.add(new EmployeeBinarySearch(250, "Judy", 11000));

    for (EmployeeBinarySearch emp : empList) {
      System.out.println(emp);
    }

    Collections.sort(empList);

    System.out.println("Sorted Employee List:");
    for (EmployeeBinarySearch emp : empList) {
      System.out.println(emp);
    }

    int index2 = Collections.binarySearch(empList, new EmployeeBinarySearch(15, "Jane", 0));
    System.out.println("Index of Employee with ID 15: " + index2);

    int[] arr = {1, -3, 6, 32, 423, -46, 11, 43, 1};
    System.out.println("\nArray before sorting: " + Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.println("Array after sorting: " + Arrays.toString(arr));
    int index3 = Arrays.binarySearch(arr, 32);
    System.out.println("Index of 32: " + index3);
  }
}

class EmployeeBinarySearch implements Comparable<EmployeeBinarySearch> {
  int id;
  String name;
  int salary;

  public EmployeeBinarySearch(int id, String name, int salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  @Override
  public int compareTo(EmployeeBinarySearch anotherEmp) {
    int result = this.id - anotherEmp.id;
    if (result == 0) {
      result = this.name.compareTo(anotherEmp.name);
    }
    return result;
  }

  @Override
  public String toString() {
    return "EmployeeBinarySearch [id=" + id + ", name=" + name + ", salary=" + salary + "]";
  }
}