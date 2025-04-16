# Java Advanced Course 2020

## Contents

1. [Lesson 1: Comparable and Comparator Interfaces](#lesson-1-comparable-and-comparator-interfaces)  

## Lesson 1: Comparable and Comparator Interfaces

This lesson covers:

- `Comparable` interface for natural ordering
- `Comparator` interface for custom ordering
- Different ways to implement comparison logic
- Sorting collections using both interfaces

### Interface Overview

| Interface    | Method          | Purpose                     | Example Use Case            |
|-------------|-----------------|-----------------------------|-----------------------------|
| Comparable  | `compareTo()`   | Natural ordering            | Sorting by employee ID      |
| Comparator  | `compare()`     | Custom ordering criteria    | Sorting by name or salary   |

### Implementation Examples

#### 1. Using Comparable

```java
class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee other) {
        return this.id - other.id;
    }
}
```

#### 2. Using Comparator

```java
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salary - emp2.salary;
    }
}
```

### Sorting Methods

```java
// Using Comparable (natural ordering)
Collections.sort(employees);

// Using Comparator (custom ordering)
Collections.sort(employees, new SalaryComparator());
```

The lesson code is available in these files:

- [StringSortExample.java](./comparation/StringSortExample.java)
- [ComparableEmployeeExample.java](./comparation/ComparableEmployeeExample.java)
- [EmployeeSort.java](./comparation/EmployeeSort.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---