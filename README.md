# Java Advanced Course 2020

## Contents

1. [Lesson 1: Comparable and Comparator Interfaces](#lesson-1-comparable-and-comparator-interfaces)
2. [Lesson 2: Java Generics](#lesson-2-java-generics)
3. [Lesson 3: Java Collections Framework](#lesson-3-java-collections-framework)
4. [Lesson 4: Nested Classes in Java](#lesson-4-nested-classes-in-java)
5. [Lesson 5: Lambda Expressions in Java](#lesson-5-lambda-expressions-in-java)
6. [Lesson 6: Java Stream API](#lesson-6-java-stream-api)
7. [Lesson 7: Java Multithreading](#lesson-7-java-multithreading)
8. [Lesson 8: Working with Files in Java](#lesson-8-working-with-files-in-java)
9. [Lesson 9: Regular Expressions in Java](#lesson-9-regular-expressions-in-java)
10. [Lesson 10: Enums in Java](#lesson-10-enums-in-java)
11. [Lesson 11: Scanner Class in Java](#lesson-11-scanner-class-in-java)
12. [Lesson 12: Java Reflection API](#lesson-12-java-reflection-api)
13. [Lesson 13: Java Annotations](#lesson-13-java-annotations)

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

## Lesson 6: Java Stream API

This lesson covers:

- Stream creation and operations
- Map and flatMap transformations
- Filtering and sorting
- Terminal operations and collectors
- Parallel streams
- Numeric stream operations

### Stream API Overview

| Concept | Description | Example |
|---------|-------------|---------|
| Stream | Sequence of elements | `List.stream()` |
| Intermediate Operations | Return new stream | `map(), filter()` |
| Terminal Operations | Produce result | `collect(), reduce()` |
| Parallel Processing | Multi-thread execution | `parallelStream()` |

### Stream Creation and Basic Operations

#### Creating Streams

```java
// From Collection
List<String> list = List.of("Java", "Python", "C++");
Stream<String> stream1 = list.stream();

// From Array
int[] array = {1, 2, 3, 4, 5};
IntStream stream2 = Arrays.stream(array);

// Using Stream.of()
Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
```

### Map Operations

```java
// Simple mapping
List<Integer> lengthList = list.stream()
    .map(String::length)
    .collect(Collectors.toList());

// Complex mapping with conditions
array = Arrays.stream(array)
    .map(element -> {
        if (element % 3 == 0) {
            element = element / 3;
        }
        return element;
    }).toArray();
```

### FlatMap Operations

```java
// Flattening nested collections
List<Faculty> faculties = // ...
faculties.stream()
    .flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
    .forEach(student -> System.out.println(student.getName()));
```

### Filtering and Sorting

```java
students.stream()
    .filter(element -> element.getAge() > 20)
    .sorted((x, y) -> x.getName().compareTo(y.getName()))
    .forEach(System.out::println);
```

### Numeric Operations

```java
// Sum calculation
int sum = students.stream()
    .mapToInt(Student::getCourse)
    .sum();

// Average calculation
double average = students.stream()
    .mapToInt(Student::getCourse)
    .average()
    .getAsDouble();

// Min and Max
StudentFilter min = students.stream()
    .min((x, y) -> x.getAge() - y.getAge())
    .get();
```

### Collectors

```java
// Grouping
Map<Integer, List<StudentFilter>> courseMap = students.stream()
    .collect(Collectors.groupingBy(StudentFilter::getCourse));

// Partitioning
Map<Boolean, List<StudentFilter>> gradeMap = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getAvgGrade() > 3.5));
```

### Method Chaining

```java
int result = Arrays.stream(arr)
    .filter(e -> e % 2 == 1)
    .map(e -> {
        if (e % 3 == 0) {e = e / 3;}
        return e;
    })
    .reduce((a, e) -> a + e)
    .getAsInt();
```

### Parallel Streams

```java
// Parallel processing
double sum = numbers.parallelStream()
    .reduce((a, b) -> a + b)
    .get();

// Sequential processing (when order matters)
double division = numbers.stream()
    .reduce((a, b) -> a / b)
    .get();
```

### Stream Operations Overview

#### Intermediate Operations

| Operation | Description | Example |
|-----------|-------------|---------|
| map() | Transform elements | `stream.map(String::length)` |
| filter() | Filter elements | `stream.filter(n -> n > 0)` |
| sorted() | Sort elements | `stream.sorted()` |
| distinct() | Remove duplicates | `stream.distinct()` |
| limit() | Limit stream size | `stream.limit(5)` |
| skip() | Skip elements | `stream.skip(2)` |

#### Terminal Operations

| Operation | Description | Example |
|-----------|-------------|---------|
| collect() | Collect results | `stream.collect(toList())` |
| forEach() | Process elements | `stream.forEach(System.out::println)` |
| reduce() | Reduce to single value | `stream.reduce(0, Integer::sum)` |
| count() | Count elements | `stream.count()` |
| min()/max() | Find min/max | `stream.min(Comparator.naturalOrder())` |
| findFirst() | Find first element | `stream.findFirst()` |

### Best Practices

1. Use Streams when:
   - Processing collections of data
   - Performing multiple operations in sequence
   - Need for parallel processing

2. Avoid Streams when:
   - Mutating state during processing
   - Using break/continue/return
   - Need for imperative debugging

3. Performance considerations:
   - Parallel streams for large datasets
   - Consider operation costs
   - Be careful with stateful operations

The lesson code is available in these files:

Basic Stream operations:

- [`StreamMapDemo.java`](./stream/StreamMapDemo.java)
- [`StreamOperationsDemo.java`](./stream/StreamOperationsDemo.java)
- [`StreamMethodChainingDemo.java`](./stream/StreamMethodChainingDemo.java)

Advanced operations:

- [`StreamFlatMapDemo.java`](./stream/StreamFlatMapDemo.java)
- [`StreamReduceDemo.java`](./stream/StreamReduceDemo.java)
- [`StreamCollectorsDemo.java`](./stream/StreamCollectorsDemo.java)

Array and Numeric operations:

- [`ArrayStreamDemo.java`](./stream/ArrayStreamDemo.java)
- [`StreamNumericOperationsDemo.java`](./stream/StreamNumericOperationsDemo.java)

Student processing:

- [`StudentStreamDemo.java`](./stream/StudentStreamDemo.java)

Parallel processing:

- [`ParallelStreamDemo.java`](./stream/ParallelStreamDemo.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 7: Java Multithreading

This lesson covers:

- Thread creation and lifecycle
- Synchronization mechanisms
- Thread coordination
- Thread pools and executors
- Thread-safe collections
- Advanced concurrency concepts

### Thread Creation and Lifecycle Overview

| Creation Method | Description | Use Case |
|----------------|-------------|-----------|
| Extending Thread | Direct inheritance | Simple thread tasks |
| Implementing Runnable | Interface implementation | More flexible, allows other inheritance |
| Anonymous classes | One-time thread definitions | Quick thread creation |
| Lambda expressions | Modern syntax | Concise thread creation |

### Thread States

```java
// NEW -> RUNNABLE -> RUNNING -> TERMINATED
Thread thread = new Thread(new WorkerTask());  // NEW
System.out.println(thread.getState());        // NEW
thread.start();                               // RUNNABLE
thread.join();                                // WAITING/TIMED_WAITING
// Thread finishes                            // TERMINATED
```

#### Thread State Transitions

| State | Description | Triggered By |
|-------|-------------|-------------|
| NEW | Thread created but not started | new Thread() |
| RUNNABLE | Thread executing or ready to execute | start() |
| BLOCKED | Waiting for monitor lock | Entering synchronized block/method |
| WAITING | Waiting indefinitely for another thread | wait(), join() |
| TIMED_WAITING | Waiting for specified time | sleep(), wait(timeout), join(timeout) |
| TERMINATED | Thread completed execution | run() method finished |

### Basic Thread Examples

#### 1. Extending Thread

```java
class CountUpThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

// Usage
CountUpThread thread = new CountUpThread();
thread.start();
```

#### 2. Implementing Runnable

```java
class CounterRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

// Usage
Thread thread = new Thread(new CounterRunnable());
thread.start();
```

### Thread Synchronization

#### 1. Synchronized Methods

```java
public class Counter {
    private static int count = 0;
    
    public static synchronized void increment() {
        count++;
    }
}
```

#### 2. Synchronized Blocks

```java
// Using this as lock
synchronized(this) {
    // Critical section
}

// Using class lock
synchronized(ClassName.class) {
    // Critical section
}

// Using custom lock object
private final Object lock = new Object();
synchronized(lock) {
    // Critical section
}
```

### Thread Communication

#### Wait/Notify Pattern

```java
class Market {
    private int breadCount = 0;
    private final Object lock = new Object();

    public void getBread() {
        synchronized (lock) {
            while (breadCount < 1) {
                lock.wait();
            }
            breadCount--;
            lock.notify();
        }
    }

    public void putBread() {
        synchronized (lock) {
            while (breadCount >= 5) {
                lock.wait();
            }
            breadCount++;
            lock.notify();
        }
    }
}
```

### Thread Pool Types

| Type | Description | Use Case |
|------|-------------|----------|
| Fixed | Fixed number of threads | Stable, predictable workload |
| Cached | Creates threads as needed | Variable number of short tasks |
| Scheduled | Can schedule future/periodic tasks | Delayed/periodic execution |
| Single | Single thread executor | Sequential task processing |

```java
// Fixed thread pool
ExecutorService fixedPool = Executors.newFixedThreadPool(5);

// Cached thread pool
ExecutorService cachedPool = Executors.newCachedThreadPool();

// Scheduled thread pool
ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);

// Usage example
scheduledPool.scheduleAtFixedRate(task, 3, 2, TimeUnit.SECONDS);
```

### Thread Coordination Tools

#### CountDownLatch

```java
CountDownLatch latch = new CountDownLatch(3);

// Waiting thread
latch.await(); // Wait for count to reach zero

// Working threads
latch.countDown(); // Decrease count
```

#### Semaphore

```java
Semaphore semaphore = new Semaphore(2); // 2 permits

// Acquire permit
semaphore.acquire();
try {
    // Critical section
} finally {
    semaphore.release(); // Release permit
}
```

#### ReentrantLock

```java
private Lock lock = new ReentrantLock();

public void someMethod() {
    lock.lock();
    try {
        // Critical section
    } finally {
        lock.unlock();
    }
}
```

### Thread-Safe Collections

| Collection | Description | Key Features |
|------------|-------------|--------------|
| ConcurrentHashMap | Thread-safe map | Segment locking, null-free |
| CopyOnWriteArrayList | Thread-safe list | Copy on modification |
| ArrayBlockingQueue | Bounded blocking queue | FIFO, size-bounded |
| ConcurrentLinkedQueue | Unbounded queue | Non-blocking algorithm |

```java
// ConcurrentHashMap example
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
map.put(1, "One");
map.putIfAbsent(2, "Two");

// CopyOnWriteArrayList example
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
list.add("Item");
Iterator<String> iterator = list.iterator(); // Snapshot iterator
```

### Advanced Concepts

#### Volatile Variables

```java
public class VolatileExample {
    private volatile boolean flag = false;
    
    public void setFlag() {
        flag = true; // Visible to all threads
    }
    
    public boolean isFlag() {
        return flag;
    }
}
```

#### Atomic Variables

```java
public class AtomicCounter {
    private AtomicInteger counter = new AtomicInteger(0);
    
    public void increment() {
        counter.incrementAndGet();
    }
    
    public int get() {
        return counter.get();
    }
}
```

### Best Practices

1. Thread Creation
   - Prefer ExecutorService over manual thread creation
   - Use thread pools for multiple similar tasks
   - Consider thread lifecycle management

2. Synchronization
   - Use synchronized sparingly
   - Prefer concurrent collections over synchronized blocks
   - Keep synchronized blocks small

3. Thread Safety
   - Make classes immutable when possible
   - Use thread-safe collections
   - Avoid sharing mutable state

4. Resource Management
   - Always close ExecutorService properly
   - Release locks in finally blocks
   - Clean up thread resources

5. Performance
   - Balance thread pool size
   - Avoid thread contention
   - Use appropriate collection types

The lesson code is available in these files:

Thread Creation:

- [`ThreadExtensionExample.java`](./multithreading/ThreadExtensionExample.java)
- [`RunnableImplementationExample.java`](./multithreading/RunnableImplementationExample.java)
- [`AnonymousThreadExample.java`](./multithreading/AnonymousThreadExample.java)

Thread States and Management:

- [`ThreadStateExample.java`](./multithreading/ThreadStateExample.java)
- [`ThreadAttributesExample.java`](./multithreading/ThreadAttributesExample.java)
- [`ThreadSleepExample.java`](./multithreading/ThreadSleepExample.java)
- [`ThreadJoinExample.java`](./multithreading/ThreadJoinExample.java)
- [`InterruptionExample.java`](./multithreading/InterruptionExample.java)
- [`DaemonExample.java`](./multithreading/DaemonExample.java)

Synchronization:

- [`SynchronizedMethodExample.java`](./multithreading/SynchronizedMethodExample.java)
- [`ThisLockExample.java`](./multithreading/ThisLockExample.java)
- [`ClassLockExample.java`](./multithreading/ClassLockExample.java)
- [`SharedLockExample.java`](./multithreading/SharedLockExample.java)
- [`DataRaceExample.java`](./multithreading/DataRaceExample.java)
- [`DeadLockExample.java`](./multithreading/DeadLockExample.java)

Thread Coordination:

- [`WaitNotifyExample.java`](./multithreading/WaitNotifyExample.java)
- [`CountDownLatchExample.java`](./multithreading/CountDownLatchExample.java)
- [`SemaphoreExample.java`](./multithreading/SemaphoreExample.java)
- [`ExchangerExample.java`](./multithreading/ExchangerExample.java)
- [`LockExample.java`](./multithreading/LockExample.java)
- [`ATMQueueExample.java`](./multithreading/ATMQueueExample.java)

Thread Pools:

- [`ThreadPoolExample1.java`](./multithreading/ThreadPoolExample1.java)
- [`ThreadPoolExample2.java`](./multithreading/ThreadPoolExample2.java)
- [`CallableFactorial.java`](./multithreading/CallableFactorial.java)
- [`RunnableFactorial.java`](./multithreading/RunnableFactorial.java)
- [`SumNumbersCallable.java`](./multithreading/SumNumbersCallable.java)

Thread-Safe Collections:

- [`ConcurrentHashMapExample.java`](./multithreading/thread_safe/ConcurrentHashMapExample.java)
- [`CopyOnWriteArrayListExample.java`](./multithreading/thread_safe/CopyOnWriteArrayListExample.java)
- [`ArrayBlockingQueueExample.java`](./multithreading/thread_safe/ArrayBlockingQueueExample.java)
- [`ArrayBlockingQueueExample2.java`](./multithreading/thread_safe/ArrayBlockingQueueExample2.java)
- [`SynchronizedCollectionExample.java`](./multithreading/thread_safe/SynchronizedCollectionExample.java)
- [`SynchronizedCollectionExample2.java`](./multithreading/thread_safe/SynchronizedCollectionExample2.java)

Atomic Operations:

- [`AtomicIntegerExample.java`](./multithreading/AtomicIntegerExample.java)
- [`VolatileVisibilityExample.java`](./multithreading/VolatileVisibilityExample.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 8: Working with Files in Java

This lesson covers:

- File system operations
- Input/Output streams
- Character streams (Readers/Writers)
- Random access files
- NIO.2 API (Paths, Files, Channels)
- File visitors and walking file trees
- Serialization

### File Operations Overview

| Operation Type | Legacy (java.io.File) | Modern (java.nio.Path) |
|---------------|----------------------|----------------------|
| Create | `file.createNewFile()` | `Files.createFile(path)` |
| Delete | `file.delete()` | `Files.delete(path)` |
| Check Existence | `file.exists()` | `Files.exists(path)` |
| Get Properties | `file.length()` | `Files.size(path)` |

### File Access Methods

#### 1. Basic File Operations

```java
// Using File class
File file = new File("FileForExample.txt");
System.out.println("Exists: " + file.exists());
System.out.println("Length: " + file.length());
System.out.println("Is Directory: " + file.isDirectory());

// Using Path/Files
Path path = Paths.get("FileForExample.txt");
System.out.println("Exists: " + Files.exists(path));
System.out.println("Size: " + Files.size(path));
System.out.println("Is Directory: " + Files.isDirectory(path));
```

### Stream Types Overview

| Stream Type | Binary Data | Character Data | Example Use Case |
|-------------|-------------|----------------|------------------|
| InputStream/OutputStream | Yes | No | Image files, binary data |
| Reader/Writer | No | Yes | Text files, character data |
| RandomAccessFile | Yes | Yes | Database-like operations |
| Channel/Buffer | Yes | Yes | High-performance I/O |

### Text File Operations

#### 1. Reading Text (FileReader)

```java
try (FileReader reader = new FileReader("FileForExample.txt")) {
    int character;
    while ((character = reader.read()) != -1) {
        System.out.print((char) character);
    }
}
```

#### 2. Writing Text (FileWriter)

```java
try (FileWriter writer = new FileWriter("FileForExample.txt", true)) {
    String text = "Hello, World!\n";
    writer.write(text);
}
```

#### 3. Buffered Operations

```java
// Buffered Reading
try (BufferedReader reader = new BufferedReader(
        new FileReader("FileForExample.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}

// Buffered Writing
try (BufferedWriter writer = new BufferedWriter(
        new FileWriter("FileForExample.txt"))) {
    writer.write("Hello");
    writer.newLine();
    writer.write("World");
}
```

### Binary File Operations

#### 1. Basic Stream Operations

```java
// Reading bytes
try (FileInputStream fis = new FileInputStream("ImageForExample.png")) {
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = fis.read(buffer)) != -1) {
        // Process bytes
    }
}

// Writing bytes
try (FileOutputStream fos = new FileOutputStream("output.png")) {
    byte[] data = // ... your binary data
    fos.write(data);
}
```

#### 2. Data Streams for Primitives

```java
// Writing primitive types
try (DataOutputStream dos = new DataOutputStream(
        new FileOutputStream("data.bin"))) {
    dos.writeInt(123);
    dos.writeDouble(3.14);
    dos.writeUTF("Hello");
}

// Reading primitive types
try (DataInputStream dis = new DataInputStream(
        new FileInputStream("data.bin"))) {
    int number = dis.readInt();
    double decimal = dis.readDouble();
    String text = dis.readUTF();
}
```

### Random Access Files

```java
try (RandomAccessFile raf = 
        new RandomAccessFile("FileForExample.txt", "rw")) {
    // Read from specific position
    raf.seek(100);
    byte[] bytes = new byte[50];
    raf.read(bytes);
    
    // Write at specific position
    raf.seek(raf.length()); // Go to end
    raf.write("New Data".getBytes());
}
```

### Modern NIO.2 Operations

#### 1. Path Operations

```java
Path path = Paths.get("work_with_files/test.txt");
System.out.println("File name: " + path.getFileName());
System.out.println("Parent: " + path.getParent());
System.out.println("Root: " + path.getRoot());
System.out.println("Absolute: " + path.toAbsolutePath());
```

#### 2. Files Utility Class

```java
// File operations
Files.createFile(path);
Files.delete(path);
Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
Files.move(source, target);

// Reading/Writing
List<String> lines = Files.readAllLines(path);
Files.write(path, lines);

// Attributes
System.out.println("Size: " + Files.size(path));
System.out.println("Last Modified: " + 
    Files.getAttribute(path, "basic:lastModifiedTime"));
```

#### 3. Directory Operations

```java
// Create directory structure
Files.createDirectories(Paths.get("nested/dirs"));

// List directory contents
try (DirectoryStream<Path> stream = 
        Files.newDirectoryStream(Paths.get("."))) {
    for (Path entry : stream) {
        System.out.println(entry.getFileName());
    }
}
```

### File Tree Operations

#### 1. Walking File Tree

```java
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, 
            BasicFileAttributes attrs) {
        System.out.println("Visiting file: " + file);
        return FileVisitResult.CONTINUE;
    }
}

Files.walkFileTree(Paths.get("."), new MyFileVisitor());
```

#### 2. Copying Directory Tree

```java
class CopyFileVisitor extends SimpleFileVisitor<Path> {
    private final Path source;
    private final Path target;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, 
            BasicFileAttributes attrs) throws IOException {
        Path targetDir = target.resolve(source.relativize(dir));
        Files.copy(dir, targetDir, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, 
            BasicFileAttributes attrs) throws IOException {
        Files.copy(file, 
            target.resolve(source.relativize(file)), 
            StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}
```

### Channel and Buffer Operations

```java
try (FileChannel channel = FileChannel.open(path, 
        StandardOpenOption.READ, StandardOpenOption.WRITE)) {
    // Reading
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    channel.read(buffer);
    buffer.flip();
    
    // Writing
    buffer.clear();
    buffer.put("Hello".getBytes());
    buffer.flip();
    channel.write(buffer);
}
```

### Best Practices

1. Resource Management:
   - Always use try-with-resources
   - Close resources in finally blocks if not using try-with-resources
   - Use buffered operations for better performance

2. Error Handling:
   - Handle specific exceptions first
   - Consider file system permissions
   - Check file existence before operations

3. Performance:
   - Use buffered streams for text files
   - Use channels for large files
   - Use appropriate buffer sizes

4. Character Encoding:
   - Specify character encoding explicitly
   - Use StandardCharsets constants
   - Consider platform-specific line endings

The lesson code is available in these files:

Basic File Operations:

- [`FileExample.java`](./work_with_files/FileExample.java)
- [`PathAndFilesExample1.java`](./work_with_files/PathAndFilesExample1.java)
- [`PathAndFilesExample2.java`](./work_with_files/PathAndFilesExample2.java)
- [`PathAndFilesExample3.java`](./work_with_files/PathAndFilesExample3.java)

Text File Operations:

- [`TextFileReaderExample.java`](./work_with_files/TextFileReaderExample.java)
- [`TextFileWriterExample.java`](./work_with_files/TextFileWriterExample.java)
- [`FileCopyExample.java`](./work_with_files/FileCopyExample.java)

Binary File Operations:

- [`BinaryDataIOExample.java`](./work_with_files/BinaryDataIOExample.java)
- [`ImageFileCopyExample.java`](./work_with_files/ImageFileCopyExample.java)

Random Access:

- [`RandomAccessFileExample.java`](./work_with_files/RandomAccessFileExample.java)

Channel/Buffer Operations:

- [`ChannelBufferExample1.java`](./work_with_files/ChannelBufferExample1.java)
- [`ChannelBufferExample2.java`](./work_with_files/ChannelBufferExample2.java)

File Tree Operations:

- [`FileTree.java`](./work_with_files/FileTree.java)
- [`CopyFileTree.java`](./work_with_files/CopyFileTree.java)
- [`DeleteFileTree.java`](./work_with_files/DeleteFileTree.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 9: Regular Expressions in Java

This lesson covers:

- Regular expression syntax
- Pattern and Matcher classes
- Common regex patterns
- Pattern matching and groups
- String operations with regex

### Regular Expression Overview

| Component | Description | Example | Matches |
|-----------|-------------|---------|---------|
| Literal | Exact text match | `"hello"` | "hello" |
| Character Class | Set of characters | `[aeiou]` | Any vowel |
| Predefined Class | Common patterns | `\d`, `\w`, `\s` | Digits, word chars, whitespace |
| Quantifiers | Repetition | `*`, `+`, `?`, `{n}` | Zero/more, one/more, optional, exactly n |

### Basic Pattern Examples

```java
// Simple word pattern
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher("Hello World");

// Phone number pattern
Pattern phonePattern = Pattern.compile("\\+\\d{9}");

// Email pattern
Pattern emailPattern = Pattern.compile("\\w+@\\w+\\.(ru|com)");
```

### Common Regex Patterns

#### 1. Character Classes

```java
// Single character from set
"[ABC]"           // Matches A, B, or C
"[A-F]"          // Matches A through F
"[^ABC]"         // Matches any character except A, B, or C
```

#### 2. Predefined Classes

```java
"\\d"            // Any digit [0-9]
"\\D"            // Any non-digit
"\\w"            // Word character [a-zA-Z0-9_]
"\\W"            // Non-word character
"\\s"            // Whitespace
"\\S"            // Non-whitespace
```

#### 3. Quantifiers

```java
pattern = "\\w+"         // One or more word chars
pattern = "\\w*"         // Zero or more word chars
pattern = "\\w?"         // Zero or one word char
pattern = "\\w{2,4}"     // 2 to 4 word chars
pattern = "\\w{2,}"      // 2 or more word chars
```

### Pattern Matching Operations

#### 1. Basic Matching

```java
String text = "Hello, my friend!";
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
    System.out.println("Found: " + matcher.group());
}
```

#### 2. Group Extraction

```java
Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})");
Matcher matcher = pattern.matcher("1234567891234567");

if (matcher.matches()) {
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}
```

### String Operations with Regex

#### 1. String Replacement

```java
String text = "Hello,    my    friend!";

// Replace multiple spaces with single space
text = text.replaceAll("\\s+", " ");

// Replace words starting with 'm'
text = text.replaceAll("\\bm\\w+", "444");
```

#### 2. String Splitting

```java
String text = "Hello, my friend!";
String[] words = text.split("\\W+");
// Result: ["Hello", "my", "friend"]
```

### Pattern Flags

```java
// Case-insensitive matching
Pattern pattern = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);

// Multiline mode
Pattern pattern2 = Pattern.compile("^hello", Pattern.MULTILINE);
```

### Common Use Cases

#### 1. Email Validation

```java
public static boolean isValidEmail(String email) {
    return email.matches("\\w+@\\w+\\.(com|ru)");
}
```

#### 2. Phone Number Format

```java
public static boolean isValidPhone(String phone) {
    return phone.matches("\\+\\d{9}");
}
```

#### 3. Data Extraction

```java
Pattern pattern = Pattern.compile(
    "(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
Matcher matcher = pattern.matcher("1234567891234567");
```

### Best Practices

1. Pattern Compilation:
   - Compile patterns once and reuse
   - Use appropriate flags when needed
   - Consider using pattern pools for frequently used patterns

2. Performance:
   - Avoid excessive backtracking
   - Use non-capturing groups (?:) when group capture isn't needed
   - Use StringBuilder for multiple replacements

3. Maintainability:
   - Document complex patterns
   - Break down complex patterns into smaller parts
   - Use named groups for clarity

4. Validation:
   - Use anchors (^ and $) for full string matching
   - Consider input length limits
   - Handle null inputs

The lesson code is available in these files:

Basic regex examples:

- [`Regex1.java`](./regex/Regex1.java) - Basic pattern matching
- [`Regex2.java`](./regex/Regex2.java) - Common regex patterns
- [`Regex3.java`](./regex/Regex3.java) - String operations
- [`Regex4.java`](./regex/Regex4.java) - Group extraction

Formatting examples:

- [`PrintfExample.java`](./regex/PrintfExample.java)

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 10: Enums in Java

This lesson covers:

- Enum basics and syntax
- Methods and fields in enums
- Constructors and initialization
- Switch statements with enums

### Enum Overview

Based on [`Enum1.java`](./enums/Enum1.java), here are the key concepts:

#### Basic Enum Declaration

```java
enum WeekDays2 {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

#### Enum with Fields and Methods

```java
enum WeekDays {
    MONDAY("sad"),
    TUESDAY("sad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY,
    SATURDAY("great"),
    SUNDAY("good");

    private String mood;

    private WeekDays(String mood) {
        this.mood = mood;
    }

    private WeekDays() {}

    public String getMood() {
        return mood;
    }
}
```

### Working with Enums

#### 1. Creating and Using Enum Values

```java
// Direct enum value access
WeekDays day = WeekDays.MONDAY;

// Creating from String
WeekDays w4 = WeekDays.valueOf("MONDAY");

// Getting all enum values
WeekDays[] arrDays = WeekDays.values();
```

#### 2. Enum Equality Comparison

```java
WeekDays w1 = WeekDays.FRIDAY;
WeekDays w2 = WeekDays.FRIDAY;
WeekDays w3 = WeekDays.MONDAY;

// Using == operator
System.out.println(w1 == w3);  // false
System.out.println(w1 == w2);  // true

// Note: Cannot compare enums of different types with ==
// System.out.println(WeekDays.FRIDAY == WeekDays2.FRIDAY); // Compile error
```

#### 3. Using Enums in Classes

```java
class Today {
    WeekDays weekDay;

    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    void daysInfo() {
        switch (weekDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Work day");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend");
                break;
        }
        System.out.println("Mood on this day: " + weekDay.getMood());
    }
}
```

### Key Features of Enums

1. **Constant Values:**
   - Fixed set of constants
   - Type-safe enumeration
   - Cannot create new instances at runtime

2. **Built-in Methods:**
   - `values()` - returns array of all enum constants
   - `valueOf(String)` - converts string to enum constant
   - `name()` - returns the name of the enum constant
   - `ordinal()` - returns the position in enum declaration

3. **Additional Features:**
   - Can have fields and methods
   - Can have constructors (private only)
   - Can implement interfaces
   - Can override methods

### Best Practices

1. **Naming Conventions:**
   - Use UPPERCASE for enum constants
   - Use singular form for enum type name
   - Use descriptive names for constants

2. **Design Guidelines:**
   - Keep enums simple and focused
   - Use fields to store associated data
   - Make fields final when possible
   - Consider implementing methods for behavior

3. **Usage Recommendations:**
   - Use enums instead of integer constants
   - Use switch statements for enum-based logic
   - Consider using EnumSet/EnumMap for collections
   - Document enum purpose and constants

4. **Performance Considerations:**
   - Enums are instantiated only once
   - Memory efficient for fixed set of constants
   - Fast equality comparison with ==
   - Efficient in switch statements

### Common Use Cases

1. **Day of Week:**

   ```java
   WeekDays today = WeekDays.MONDAY;
   ```

2. **Status/State:**

   ```java
   enum Status {
       ACTIVE, INACTIVE, PENDING
   }
   ```

3. **Configuration Options:**

   ```java
   enum ConfigOption {
       DEBUG, RELEASE, TEST
   }
   ```

4. **Command Pattern:**

   ```java
   enum Command {
       SAVE, LOAD, EXIT
   }
   ```

The lesson code is available in these files:

Basic enum examples:

- [`Enum1.java`](./enums/Enum1.java) - Complete enum implementation with fields and methods

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 11: Scanner Class in Java

This lesson covers:

- Scanner class fundamentals
- Different input sources
- Reading various data types
- Delimiter usage
- File scanning operations

### Scanner Overview

| Feature | Description | Example Use Case |
|---------|-------------|------------------|
| Input Sources | Console, File, String | User input, File parsing, String tokenization |
| Data Types | primitives, String | Reading numbers, text |
| Delimiters | Custom patterns | Word splitting, CSV parsing |
| Buffer Management | Auto-closeable | Resource cleanup |

### Basic Scanner Usage

#### 1. Console Input

```java
Scanner sc = new Scanner(System.in);

// Reading different data types
System.out.println("Input 2 Integer");
int x = sc.nextInt();     // Read integer
int y = sc.nextInt();     // Read another integer

System.out.println("Input 2 String");
String s1 = sc.next();    // Read word
String s2 = sc.next();    // Read next word

System.out.println("Input Double");
double z = sc.nextDouble(); // Read double number
```

#### 2. String Source

```java
Scanner sc = new Scanner("Hello my friend!\n" +
                        "How are you doing?\n" +
                        "What's good?");

// Reading line by line
while (sc.hasNextLine()) {
    System.out.println(sc.nextLine());
}
```

### File Operations with Scanner

```java
try (Scanner sc = new Scanner(
        new FileReader("scanner/FileForExample.txt"))) {
    
    // Set custom delimiter for word splitting
    sc.useDelimiter("\\W");
    
    // Store unique words in sorted set
    Set<String> uniqueWords = new TreeSet<>();
    
    while (sc.hasNext()) {
        String word = sc.next();
        if (!word.isEmpty()) {
            uniqueWords.add(word);
        }
    }
    
    // Display unique words
    for (String word : uniqueWords) {
        System.out.println(word);
    }
}
```

### Scanner Methods Overview

| Method | Description | Return Type |
|--------|-------------|-------------|
| next() | Read next token | String |
| nextLine() | Read entire line | String |
| nextInt() | Read integer | int |
| nextDouble() | Read decimal | double |
| hasNext() | Check for token | boolean |
| hasNextLine() | Check for line | boolean |
| useDelimiter() | Set delimiter | Scanner |

### Best Practices

1. **Resource Management:**
   - Use try-with-resources
   - Always close Scanner when done
   - Don't close System.in

2. **Input Validation:**
   - Check hasNext() before reading
   - Handle InputMismatchException
   - Validate numeric ranges

3. **Delimiter Usage:**
   - Choose appropriate delimiters
   - Consider whitespace handling
   - Remember to escape regex chars

4. **Performance:**
   - Use BufferedReader for large files
   - Reset Scanner when needed
   - Clear buffer after reading

### Common Use Cases

#### 1. Console Menu

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Select option (1-3):");
System.out.println("1. Start");
System.out.println("2. Settings");
System.out.println("3. Exit");

int choice = scanner.nextInt();
switch (choice) {
    case 1: /* Start logic */ break;
    case 2: /* Settings logic */ break;
    case 3: /* Exit logic */ break;
    default: System.out.println("Invalid option");
}
```

#### 2. CSV File Processing

```java
Scanner scanner = new Scanner(new File("data.csv"));
scanner.useDelimiter(",");
while (scanner.hasNext()) {
    String field = scanner.next();
    // Process CSV field
}
```

#### 3. Word Frequency Counter

```java
Scanner scanner = new Scanner(new File("text.txt"));
Map<String, Integer> wordCount = new HashMap<>();
scanner.useDelimiter("\\W+");

while (scanner.hasNext()) {
    String word = scanner.next().toLowerCase();
    wordCount.merge(word, 1, Integer::sum);
}
```

### Error Handling

```java
Scanner scanner = new Scanner(System.in);
int number;

try {
    System.out.print("Enter a number: ");
    number = scanner.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Invalid input. Please enter a number.");
    scanner.next(); // Clear invalid input
}
```

The lesson code is available in these files:

Console and String Input:

- [`Scanner1.java`](./scanner/Scanner1.java) - Basic Scanner usage with console and string input

File Processing:

- [`Scanner2.java`](./scanner/Scanner2.java) - File reading and word processing
- [`FileForExample.txt`](./scanner/FileForExample.txt) - Sample text file for processing

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 12: Java Reflection API

This lesson covers:

- Class object and reflection basics
- Accessing fields and methods
- Constructor manipulation
- Dynamic method invocation
- Reflection with annotations
- Performance considerations

### Reflection Overview

| Feature | Description | Example Use Case |
|---------|-------------|------------------|
| Class Objects | Class metadata | Framework development |
| Member Access | Fields, methods access | Testing tools |
| Dynamic Invocation | Runtime method calls | Plugin systems |
| Constructor Access | Object creation | Dependency injection |

### Getting Class Objects

```java
// Three ways to get Class object
Class<?> class1 = Class.forName("reflection_example.Employee");
Class<?> class2 = Employee.class;
Class<?> class3 = employee.getClass();

// Getting class information
System.out.println("Class name: " + class1.getName());
System.out.println("Simple name: " + class1.getSimpleName());
System.out.println("Package: " + class1.getPackage());
```

### Working with Fields

```java
// Getting fields
Field[] fields = employeeClass.getDeclaredFields();
for (Field field : fields) {
    System.out.println("Field: " + field.getName());
    System.out.println("Type: " + field.getType());
    System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
}

// Accessing private field
Field salaryField = employeeClass.getDeclaredField("salary");
salaryField.setAccessible(true);
salaryField.setDouble(employee, 5000.0);
```

### Method Manipulation

```java
// Getting methods
Method[] methods = employeeClass.getDeclaredMethods();
for (Method method : methods) {
    System.out.println("Method: " + method.getName());
    System.out.println("Return type: " + method.getReturnType());
    System.out.println("Parameter types: " + Arrays.toString(method.getParameterTypes()));
}

// Invoking private method
Method changeDepartment = employeeClass.getDeclaredMethod("changeDepartment", String.class);
changeDepartment.setAccessible(true);
changeDepartment.invoke(employee, "IT");
```

### Constructor Access

```java
// Getting constructors
Constructor<?>[] constructors = employeeClass.getDeclaredConstructors();
for (Constructor<?> constructor : constructors) {
    System.out.println("Constructor: " + constructor);
    System.out.println("Parameters: " + Arrays.toString(constructor.getParameterTypes()));
}

// Creating object using constructor
Constructor<Employee> constructor = Employee.class.getConstructor(
    int.class, String.class, String.class);
Employee employee = constructor.newInstance(1, "John", "IT");
```

### Dynamic Method Invocation Example

```java
public class Calculator {
    void sum(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }
    
    void mul(int a, int b) {
        System.out.println("Multiplication: " + (a * b));
    }
}

// Dynamic invocation
Calculator calculator = new Calculator();
Class<?> calculatorClass = calculator.getClass();
Method method = calculatorClass.getMethod("sum", int.class, int.class);
method.invoke(calculator, 5, 10);
```

### Reading Method Parameters from File

```java
try (BufferedReader reader = new BufferedReader(
        new FileReader("reflection_example/FileForCalculator.txt"))) {
    
    String methodName = reader.readLine();
    String firstArg = reader.readLine();
    String secondArg = reader.readLine();
    
    Calculator calculator = new Calculator();
    Method method = calculator.getClass().getMethod(
        methodName, int.class, int.class);
    
    method.invoke(calculator, 
        Integer.parseInt(firstArg), 
        Integer.parseInt(secondArg));
}
```

### Best Practices

1. **Performance Considerations:**
   - Cache Class objects and Methods
   - Use reflection sparingly
   - Consider security implications

2. **Security:**
   - Use setAccessible(true) carefully
   - Consider security manager restrictions
   - Validate input parameters

3. **Error Handling:**
   - Handle reflection-specific exceptions
   - Validate method/field existence
   - Check parameter types

4. **Design:**
   - Prefer compile-time solutions when possible
   - Document reflection usage
   - Consider alternatives (interfaces, factories)

### Common Use Cases

#### 1. Framework Development

```java
// Spring-like dependency injection
@Autowired
private UserService userService;

// Finding annotated fields
for (Field field : class1.getDeclaredFields()) {
    if (field.isAnnotationPresent(Autowired.class)) {
        // Perform injection
    }
}
```

#### 2. Testing Tools

```java
// JUnit-like test runner
for (Method method : testClass.getDeclaredMethods()) {
    if (method.isAnnotationPresent(Test.class)) {
        method.invoke(testInstance);
    }
}
```

#### 3. Plugin Systems

```java
// Loading plugin class
Class<?> pluginClass = Class.forName(pluginClassName);
Plugin plugin = (Plugin) pluginClass.getDeclaredConstructor().newInstance();
plugin.execute();
```

The lesson code is available in these files:

Basic reflection examples:
- [`Example1.java`](./reflection_example/Example1.java) - Basic reflection operations
- [`Example2.java`](./reflection_example/Example2.java) - Method reflection
- [`Example3.java`](./reflection_example/Example3.java) - Constructor reflection

Calculator example:
- [`Calculator.java`](./reflection_example/Calculator.java) - Dynamic method invocation
- [`FileForCalculator.txt`](./reflection_example/FileForCalculator.txt) - Input parameters

Employee example:
- [`Employee.java`](./reflection_example/Employee.java) - Target class for reflection

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---

## Lesson 13: Java Annotations

This lesson covers:

- Annotation basics and syntax
- Built-in annotations
- Custom annotations
- Annotation retention policies
- Annotation processing
- Annotation use cases

### Annotation Overview

| Feature | Description | Example Use Case |
|---------|-------------|------------------|
| Built-in Annotations | Java provided | `@Override`, `@Deprecated` |
| Custom Annotations | User-defined | `@MyAnnotation`, `@SmartPhone` |
| Meta-Annotations | Annotations for annotations | `@Target`, `@Retention` |
| Retention Policies | Annotation lifetime | SOURCE, CLASS, RUNTIME |

### Basic Annotation Examples

#### 1. Built-in Annotations

```java
class Parent {
    @Deprecated
    void showInfo() {
        System.out.println("It's Parent class. Name = " + name);
    }
}

class Child extends Parent {
    @Override
    void showInfo() {
        System.out.println("It's Child class. Name = " + name);
    }
}
```

#### 2. Custom Annotation Definition

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // No parameters
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String os() default "Android";
    int yearOfCompanyCreation() default 2010;
}
```

### Using Annotations

#### 1. Basic Usage

```java
@MyAnnotation
public class Employee {
    String name;
    double salary;
    
    @MyAnnotation
    public void increaseSalary() {
        salary *= 2;
    }
}
```

#### 2. Annotations with Parameters

```java
@SmartPhone(yearOfCompanyCreation = 2017)
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(os = "IOS")
class Iphone {
    String model;
    double price;
}
```

### Annotation Processing

#### 1. Reading Annotations at Runtime

```java
// Get Class object
Class xiaomiClass = Class.forName("annotation_examples.Xiaomi");

// Get annotation
Annotation annotation = xiaomiClass.getAnnotation(SmartPhone.class);
SmartPhone smartphone = (SmartPhone) annotation;

// Read annotation parameters
System.out.println("OS: " + smartphone.os());
System.out.println("Year: " + smartphone.yearOfCompanyCreation());
```

#### 2. Processing Multiple Classes

```java
public static void processPhoneInfo(Class<?> phoneClass) {
    if (phoneClass.isAnnotationPresent(SmartPhone.class)) {
        SmartPhone annotation = phoneClass.getAnnotation(SmartPhone.class);
        System.out.println("Phone Info:");
        System.out.println("OS: " + annotation.os());
        System.out.println("Year: " + annotation.yearOfCompanyCreation());
    }
}
```

### Meta-Annotations

| Annotation | Purpose | Example |
|------------|---------|---------|
| @Target | Where annotation can be used | `@Target(ElementType.METHOD)` |
| @Retention | How long annotation is kept | `@Retention(RetentionPolicy.RUNTIME)` |
| @Documented | Include in JavaDoc | `@Documented` |
| @Inherited | Inherit from superclass | `@Inherited` |

### Retention Policies

```java
// Source only - discarded by compiler
@Retention(RetentionPolicy.SOURCE)

// Recorded in class file but not loaded by JVM
@Retention(RetentionPolicy.CLASS)

// Recorded and available at runtime
@Retention(RetentionPolicy.RUNTIME)
```

### Target Types

```java
@Target can specify multiple locations:
- ElementType.TYPE (classes)
- ElementType.FIELD
- ElementType.METHOD
- ElementType.PARAMETER
- ElementType.CONSTRUCTOR
- ElementType.LOCAL_VARIABLE
- ElementType.ANNOTATION_TYPE
- ElementType.PACKAGE
```

### Best Practices

1. **Annotation Design:**
   - Keep annotations focused and simple
   - Use meaningful default values
   - Document annotation purpose and usage
   - Consider retention policy carefully

2. **Usage Guidelines:**
   - Don't overuse annotations
   - Validate annotation parameters
   - Handle missing annotations gracefully
   - Consider performance impact

3. **Processing:**
   - Cache annotation lookups
   - Handle exceptions during reflection
   - Use type-safe annotation access
   - Consider compile-time processing

4. **Documentation:**
   - Document annotation requirements
   - Provide usage examples
   - Explain retention and inheritance
   - Document processing behavior

### Common Use Cases

1. **Configuration:**
   ```java
   @Configuration(path = "config.properties")
   public class AppConfig {
       // Configuration implementation
   }
   ```

2. **Validation:**

   ```java
   public class User {
       @NotNull
       @Size(min = 2, max = 30)
       private String username;
   }
   ```

3. **Dependency Injection:**

   ```java
   public class UserService {
       @Autowired
       private UserRepository repository;
   }
   ```

4. **Testing:**

   ```java
   @Test
   @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
   public void testOperation() {
       // Test implementation
   }
   ```

The lesson code is available in these files:

Basic annotation examples:

- [`Employee.java`](./annotation_examples/Employee.java) - Custom annotation usage
- [`Test1.java`](./annotation_examples/Test1.java) - Built-in annotations
- [`Test2.java`](./annotation_examples/Test2.java) - Annotation processing

<div align="right">
    <b><a href="#contents">↥ Back to Contents</a></b>
</div>

---