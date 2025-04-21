# Java Advanced Course 2020

## Contents

1. [Lesson 1: Comparable and Comparator Interfaces](#lesson-1-comparable-and-comparator-interfaces)
2. [Lesson 2: Java Generics](#lesson-2-java-generics)
3. [Lesson 3: Java Collections Framework](#lesson-3-java-collections-framework)
4. [Lesson 4: Nested Classes in Java](#lesson-4-nested-classes-in-java)

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

### Big O Notation for Collections

The efficiency of collection operations is expressed using Big O notation, including best and worst-case scenarios:

| Notation | Name | Description |
|----------|------|-------------|
| O(1) | Constant | Time is independent of collection size |
| O(log n) | Logarithmic | Time grows logarithmically with size |
| O(n) | Linear | Time grows linearly with size |
| O(n²) | Quadratic | Time grows quadratically with size |

#### Common Operations Complexity (Best and Worst Case)

##### ArrayList

| Operation | Best Case | Worst Case | Notes |
|-----------|-----------|------------|--------|
| Add | O(1) | O(n) | Amortized O(1) when appending; resizing causes O(n) |
| Remove | O(1) | O(n) | O(1) when removing the last element; O(n) otherwise |
| Search | O(1) | O(n) | O(1) if index is known; O(n) for value-based searches |
| Access | O(1) | O(1) | Direct index access |

##### LinkedList

| Operation | Best Case | Worst Case | Notes |
|-----------|-----------|------------|--------|
| Add | O(1) | O(n) | O(1) at head/tail; O(n) for arbitrary positions |
| Remove | O(1) | O(n) | O(1) at head/tail; O(n) for arbitrary positions |
| Search | O(1) | O(n) | O(1) if head/tail; O(n) otherwise |
| Access | O(1) | O(n) | O(1) for head/tail; O(n) for sequential access |

##### HashSet

| Operation | Best Case | Worst Case | Notes |
|-----------|-----------|------------|--------|
| Add | O(1) | O(n) | Collisions may degrade to O(n) (or O(log n) in Java 8+ with trees) |
| Remove | O(1) | O(n) | Worst case due to collisions |
| Search | O(1) | O(n) | Worst case due to collisions |
| Access | N/A | N/A | No direct element access |

##### TreeSet

| Operation | Best Case | Worst Case | Notes |
|-----------|-----------|------------|--------|
| Add | O(log n) | O(log n) | Self-balancing tree (e.g., Red-Black Tree) |
| Remove | O(log n) | O(log n) | Consistent logarithmic complexity |
| Search | O(log n) | O(log n) | Balanced structure ensures efficiency |
| Access | O(log n) | O(log n) | Accessed via iterators or methods |

##### HashMap

| Operation | Best Case | Worst Case | Notes |
|-----------|-----------|------------|--------|
| Add | O(1) | O(n) | Collisions may degrade to O(n) (or O(log n) in Java 8+ with trees) |
| Remove | O(1) | O(n) | Worst case due to collisions |
| Search | O(1) | O(n) | Worst case due to collisions |
| Access | O(1) | O(n) | Direct bucket access; collisions affect performance |

##### TreeMap

| Operation | Best Case | Worst Case | Notes |
|-----------|-----------|------------|--------|
| Add | O(log n) | O(log n) | Self-balancing tree structure |
| Remove | O(log n) | O(log n) | Consistent logarithmic complexity |
| Search | O(log n) | O(log n) | Key-based searches |
| Access | O(log n) | O(log n) | Accessed via key lookups |

#### Key Notes:

**ArrayList:**

- Add/Remove at the end: Amortized O(1) (resize operations are rare)
- Worst-case removal (e.g., first element) requires shifting all elements

**LinkedList:**

- Arbitrary insertion/deletion is O(n) due to traversal, but O(1) at head/tail

**HashSet/HashMap:**

- Assumes a good hash function. In Java 8+, collisions use tree nodes (O(log n) worst case)

**TreeSet/TreeMap:**

- Always balanced (e.g., Red-Black Trees in Java), ensuring stable O(log n) performance

### Collection and Map Hierarchy Overview

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
    ├── SortedSet<E>
    │   └── NavigableSet<E>
    │       └── TreeSet<E>
    
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

## Lesson 4: Nested Classes in Java

This lesson covers:

- Static nested classes
- Inner (non-static nested) classes
- Local inner classes
- Anonymous inner classes
- Differences between nested class types

### Types of Nested Classes Overview

| Type | Access Level | Class Access | Instance Access | Example Use Case |
|------|--------------|--------------|-----------------|------------------|
| Static Nested | Can access only static members | Yes | No | Helper classes, static utilities |
| Inner Class | Can access all members | Yes | Yes | Event handlers, UI components |
| Local Inner | Can access all members + final locals | Yes | Yes | One-time implementations |
| Anonymous | Can access all members + final locals | No | Yes | Event listeners, callbacks |

### Implementation Examples

#### 1. Static Nested Class Example

```java
public class Car {
    private static int staticField;
    
    public static class Engine {
        private int horsePower;
        
        public Engine(int horsePower) {
            System.out.println(staticField); // Can access static members
            this.horsePower = horsePower;
        }
    }
}

// Usage
Car.Engine engine = new Car.Engine(150);
```

#### 2. Inner Class Example

```java
public class Car {
    private int doorCount;
    
    public class Engine {
        private int horsePower;
        
        public Engine(int horsePower) {
            System.out.println(doorCount); // Can access all members
            this.horsePower = horsePower;
        }
    }
}

// Usage
Car car = new Car();
Car.Engine engine = car.new Engine(120);
```

#### 3. Local Inner Class Example

```java
public class Math {
    public void getResult(final int dividend, final int divisor) {
        class Division {
            public int getQuotient() {
                return dividend / divisor;
            }
            
            public int getRemainder() {
                return dividend % divisor;
            }
        }
        
        Division division = new Division();
        System.out.println("Quotient: " + division.getQuotient());
    }
}
```

#### 4. Anonymous Inner Class Example

```java
public class AnonymousClass {
    public static void main(String[] args) {
        Math2 summation = new Math2() {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };
        
        System.out.println("Sum: " + summation.doOperation(10, 20));
    }
}
```

### Key Characteristics

| Feature | Static Nested | Inner Class | Local Inner | Anonymous Inner |
|---------|--------------|-------------|-------------|-----------------|
| Access to enclosing members | Static only | All | All + local vars | All + local vars |
| Can have static members | Yes | No | No | No |
| Can access local variables | No | No | Yes (final/effectively final) | Yes (final/effectively final) |
| Can be instantiated without enclosing instance | Yes | No | N/A | N/A |

### Common Use Cases

1. **Static Nested Classes:**
   - Grouping utility classes
   - Implementing helper functionality
   - Encapsulating related static methods

2. **Inner Classes:**
   - UI event handling
   - Maintaining object state
   - Implementing data structure nodes

3. **Local Inner Classes:**
   - Complex operations in methods
   - One-time use implementations
   - Encapsulating method-specific logic

4. **Anonymous Inner Classes:**
   - Event listeners
   - Callback implementations
   - Quick interface implementations

### Best Practices

1. Use static nested classes when:
   - The nested class doesn't need access to instance members
   - You want to group related utility classes

2. Use inner classes when:
   - The class needs access to private members of outer class
   - There's a clear relationship between classes

3. Use local inner classes when:
   - The class is only needed in one method
   - You need access to local variables

4. Use anonymous inner classes when:
   - You need a one-time implementation
   - The class is very simple (few methods)

The lesson code is available in these files:

Static nested class examples:

- [Car.java](./nested_classes/static_nested_class/Car.java)

Inner class examples:

- [Car.java](./nested_classes/inner_class/Car.java)

Local inner class examples:

- [LocalInner1.java](./nested_classes/local_inner_class/LocalInner1.java)
- [LocalInner2.java](./nested_classes/local_inner_class/LocalInner2.java)

Anonymous class examples:

- [AnonymousClass.java](./nested_classes/anonymous_class/AnonymousClass.java)

Basic example:

- [Test.java](./nested_classes/Test.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 5: Lambda Expressions in Java

This lesson covers:

- Lambda syntax and functional interfaces
- Built-in functional interfaces
- Method references
- Consumer, Supplier, Function interfaces
- Predicate and its variations
- Stream API basics with lambdas

### Lambda Expression Overview

| Concept | Description | Example |
|---------|-------------|---------|
| Lambda Syntax | `(parameters) -> expression` | `(a, b) -> a + b` |
| Functional Interface | Interface with single abstract method | `@FunctionalInterface` |
| Method Reference | Shorthand for simple lambdas | `String::length` |

### Basic Lambda Syntax Examples

```java
// Simple lambda with one parameter
StringProcessor processor = (str) -> str.length();

// Lambda with multiple parameters
Math2 operation = (a, b) -> a + b;

// Lambda with block of code
Math2 complexOperation = (a, b) -> {
    System.out.println("Processing...");
    return a + b;
};
```

### Built-in Functional Interfaces

#### Consumer Interface

```java
// Consumer example
Consumer<Car> carModifier = car -> {
    car.color = "Red";
    car.engine = 3.0;
};

// Usage
changeCar(car, carModifier);
```

#### Supplier Interface

```java
// Supplier example
Supplier<Car> carSupplier = () -> new Car("BMW", "Black", 2.4);

// Usage
ArrayList<Car> cars = createThreeCars(carSupplier);
```

#### Function Interface

```java
// Function example
Function<String, Integer> lengthFunction = str -> str.length();

// Usage
Integer length = lengthFunction.apply("hello");
```

#### Predicate Interface

```java
// Predicate example
Predicate<String> lengthPredicate = s -> s.length() > 5;
Predicate<String> shortPredicate = s -> s.length() < 3;

// Combining predicates
list.removeIf(lengthPredicate.or(shortPredicate));
```

### ForEach with Lambda

```java
List<String> list = List.of("hello", "world", "java");

// Using lambda
list.forEach(item -> System.out.println(item));

// Using method reference
list.forEach(System.out::println);
```

### Student Filter Example

```java
// Using lambda for custom filtering
void testStudents(ArrayList<Student> students, Predicate<Student> predicate) {
    for (Student student : students) {
        if (predicate.test(student)) {
            System.out.println(student);
        }
    }
}

// Usage
studentInfo.testStudents(students, s -> s.getGrade() > 8.0);
```

### Key Features of Lambda Expressions

1. **Concise Syntax:**
   - No need for method name
   - Type inference for parameters
   - Single expression can omit braces and return

2. **Access to Variables:**
   - Can access final or effectively final local variables
   - Can access instance and static variables
   - Can't modify local variables

3. **Functional Interface Compatibility:**
   - Must be used with functional interfaces
   - Interface must have exactly one abstract method
   - Can have multiple default methods

### Common Built-in Functional Interfaces

| Interface | Method | Description | Example Use Case |
|-----------|--------|-------------|-----------------|
| Consumer<T> | accept(T) | Accepts input, returns nothing | Modifying objects |
| Supplier<T> | get() | No input, returns result | Creating objects |
| Function<T,R> | apply(T) | Transforms T to R | String to Integer |
| Predicate<T> | test(T) | Returns boolean | Filtering collections |

### Best Practices

1. Use lambda expressions when:
   - Working with collections
   - Implementing event handlers
   - Writing callback functions
   - Creating thread tasks

2. Prefer method references when:
   - The lambda just calls one method
   - The method already exists
   - The code is more readable

3. Choose appropriate functional interfaces:
   - Consumer for side effects
   - Supplier for lazy initialization
   - Function for transformations
   - Predicate for filtering

The lesson code is available in these files:

Lambda basics:

- [LambdaStringLengthExample.java](./lambda/LambdaStringLengthExample.java)

Functional interfaces:

- [ConsumerDemo.java](./lambda/ConsumerDemo.java)
- [SupplierDemo.java](./lambda/SupplierDemo.java)
- [FunctionDemo.java](./lambda/FunctionDemo.java)

Collection operations:

- [ForEachDemo.java](./lambda/ForEachDemo.java)
- [RemoveIf.java](./lambda/RemoveIf.java)

Student example:

- [Student.java](./lambda/Student.java)
- [StudentInfo.java](./lambda/StudentInfo.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---