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

## Lesson 3: Java Collections Framework

This lesson covers:

- ArrayList and its methods
- LinkedList implementation
- Vector and Stack classes
- Iterator and ListIterator
- Queue and Deque interfaces
- Set interface implementations
- Map interface implementations

### Collection Hierarchy Overview

```bash
Collection<E>
├── List<E>
│   ├── ArrayList<E>
│   ├── LinkedList<E>
│   └── Vector<E>
│       └── Stack<E>
├── Queue<E>
│   ├── PriorityQueue<E>
│   └── Deque<E>
│       ├── ArrayDeque<E>
│       └── LinkedList<E>
└── Set<E>
    ├── HashSet<E>
    ├── LinkedHashSet<E>
    └── TreeSet<E>
    
Map<K,V>
├── HashMap<K,V>
│   └── LinkedHashMap<K,V>
├── SortedMap<K,V>
│   └── NavigableMap<K,V>
│       └── TreeMap<K,V>
└── Hashtable<K,V>
```

### List Interface Implementation Examples

#### ArrayList Operations

```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");           // Adding elements
list.add(1, "Orange");      // Adding at index
list.remove("Apple");       // Removing element
list.get(0);               // Accessing element
list.set(0, "Banana");     // Replacing element
list.indexOf("Banana");    // Finding element index
```

#### LinkedList vs ArrayList

| Operation     | ArrayList | LinkedList |
|--------------|-----------|------------|
| Add/Remove at end | O(1) | O(1) |
| Add/Remove at middle | O(n) | O(1) |
| Get/Set | O(1) | O(n) |
| Memory usage | Less | More |

### Queue Interface Implementations

#### PriorityQueue Example

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();
queue.offer(5);        // Adding elements
queue.offer(1);
queue.poll();          // Removing highest priority element
queue.peek();          // Viewing highest priority element
```

### Set Interface Implementations

| Implementation | Order | Null Elements | Duplicates | Performance |
|----------------|-------|---------------|------------|-------------|
| HashSet | None | One null | No | O(1) |
| LinkedHashSet | Insertion | One null | No | O(1) |
| TreeSet | Natural | No null | No | O(log n) |

### Map Interface Implementations

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("One", 1);            // Adding entries
map.get("One");              // Retrieving values
map.remove("One");           // Removing entries
map.containsKey("One");      // Checking for key
map.containsValue(1);        // Checking for value
```

### Important Methods Overview

| Collection Type | Key Methods |
|----------------|-------------|
| List | add(), remove(), get(), set(), indexOf() |
| Queue | offer(), poll(), peek() |
| Set | add(), remove(), contains() |
| Map | put(), get(), remove(), containsKey() |

### Iteration Patterns

```java
// Using Iterator
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
}

// Using ListIterator (bidirectional)
ListIterator<String> listIterator = list.listIterator();
while (listIterator.hasNext()) {
    listIterator.next();
    listIterator.previous();
}
```

### Binary Search and Sorting

```java
Collections.sort(list);                    // Natural ordering
Collections.sort(list, comparator);        // Custom ordering
int index = Collections.binarySearch(list, key);  // Binary search
```

The lesson code is available in these files:

ArrayList examples:

- [ArrayListEx1.java](./collection/ArrayListEx1.java)
- [ArrayListMethods1.java](./collection/ArrayListMethods1.java)
- [ArrayListMethods2.java](./collection/ArrayListMethods2.java)
- [ArrayListMethods3.java](./collection/ArrayListMethods3.java)
- [ArrayListMethods4.java](./collection/ArrayListMethods4.java)
- [ArrayListMethods5.java](./collection/ArrayListMethods5.java)

LinkedList and Iteration:

- [LinkedListEx1.java](./collection/LinkedListEx1.java)
- [IteratorExample.java](./collection/IteratorExample.java)
- [ListIteratorExample.java](./collection/ListIteratorExample.java)

Vector and Stack:

- [VectorExample.java](./collection/VectorExample.java)
- [StackExample.java](./collection/StackExample.java)
- [StackExample2.java](./collection/StackExample2.java)

Queue implementations:

- [LinkedListExample.java](./collection/queue_interface/LinkedListExample.java)
- [PriorityQueueExample1.java](./collection/queue_interface/PriorityQueueExample1.java)
- [PriorityQueueExample2.java](./collection/queue_interface/PriorityQueueExample2.java)
- [ArrayDequeExample.java](./collection/queue_interface/ArrayDequeExample.java)

Set implementations:

- [HashSetExample.java](./collection/set_interface/HashSetExample.java)
- [HashSetExample2.java](./collection/set_interface/HashSetExample2.java)
- [LinkedHashSetExample.java](./collection/set_interface/LinkedHashSetExample.java)
- [TreeSetExample.java](./collection/set_interface/TreeSetExample.java)
- [TreeSetExample2.java](./collection/set_interface/TreeSetExample2.java)

Map implementations:

- [HashMapEx1.java](./collection/map_interface/HashMapEx1.java)
- [HashCodeEx1.java](./collection/map_interface/HashCodeEx1.java)
- [LinkedHashMapExample.java](./collection/map_interface/LinkedHashMapExample.java)
- [TreeMapExample.java](./collection/map_interface/TreeMapExample.java)
- [HashTableExample.java](./collection/map_interface/HashTableExample.java)

Utility:

- [BinarySearch.java](./collection/BinarySearch.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---