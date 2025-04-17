# Java Advanced Course 2020

## Contents

1. [Lesson 1: Comparable and Comparator Interfaces](#lesson-1-comparable-and-comparator-interfaces)
2. [Lesson 2: Java Generics](#lesson-2-java-generics)

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

## Lesson 2: Java Generics

This lesson covers:

- Generic classes and interfaces
- Type parameters and bounds 
- Wildcards in generic types
- Type erasure concept
- Practical examples with Teams and Participants

### Generics Overview

| Concept | Description | Example Use Case |
|---------|-------------|------------------|
| Type Parameter | Generic type placeholder | `class Box<T>` |
| Bounded Type | Restricting generic types | `<T extends Number>` |
| Wildcard | Unknown generic type | `List<?>` |

### Implementation Examples

#### 1. Generic Class

```java
class Team<T extends Participant> {
    private List<T> participants = new ArrayList<>();
    
    public void addParticipant(T participant) {
        participants.add(participant);
    }
}
```

#### 2. Wildcard Usage

```java
public static double sum(ArrayList<? extends Number> list) {
    double sum = 0;
    for (Number n : list) {
        sum += n.doubleValue();
    }
    return sum;
}
```

### Generic Methods

```java
public static <T> T getSecondElement(ArrayList<T> list) {
    return list.get(1);
}
```

The lesson code is available in these files:

Basic generics examples:

- [ParameterizedClass.java](./generics/ParameterizedClass.java)
- [ParameterizedClass2.java](./generics/ParameterizedClass2.java)
- [ParameterizedMethod.java](./generics/ParameterizedMethod.java)
- [GenericsBoundingExample.java](./generics/GenericsBoundingExample.java)
- [WildcardExample.java](./generics/WildcardExample.java)
- [TypeErasure.java](./generics/TypeErasure.java)

Team game implementation:

- [Team.java](./generics/game/Team.java)
- [Participant.java](./generics/game/Participant.java)
- [Employee.java](./generics/game/Employee.java)
- [Student.java](./generics/game/Student.java)
- [Schoolar.java](./generics/game/Schoolar.java)
- [Test.java](./generics/game/Test.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---