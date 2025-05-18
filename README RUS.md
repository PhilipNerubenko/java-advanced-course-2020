# Продвинутый курс Java 2020

## Содержание

1. [Урок 1: Интерфейсы Comparable и Comparator](#урок-1-интерфейсы-comparable-и-comparator)
2. [Урок 2: Дженерики в Java](#урок-2-дженерики-в-java)
3. [Урок 3: Java Collections Framework](#урок-3-java-collections-framework)
4. [Урок 4: Вложенные классы в Java](#урок-4-вложенные-классы-в-java)
5. [Урок 5: Лямбда-выражения в Java](#урок-5-лямбда-выражения-в-java)
6. [Урок 6: Java Stream API](#урок-6-java-stream-api)
7. [Урок 7: Многопоточность в Java](#урок-7-многопоточность-в-java)
8. [Урок 8: Работа с файлами в Java](#урок-8-работа-с-файлами-в-java)
9. [Урок 9: Регулярные выражения в Java](#урок-9-регулярные-выражения-в-java)
10. [Урок 10: Перечисления в Java](#урок-10-перечисления-в-java)
11. [Урок 11: Класс Scanner в Java](#урок-11-класс-scanner-в-java)
12. [Урок 12: Java Reflection API](#урок-12-java-reflection-api)
13. [Урок 13: Аннотации в Java](#урок-13-аннотации-в-java)

## Урок 1: Интерфейсы Comparable и Comparator

Этот урок охватывает:

- Интерфейс `Comparable` для естественного упорядочивания
- Интерфейс `Comparator` для пользовательского упорядочивания
- Различные способы реализации логики сравнения
- Сортировка коллекций с использованием обоих интерфейсов

### Обзор интерфейсов

| Интерфейс   | Метод          | Назначение                    | Пример использования        |
|-------------|----------------|-------------------------------|---------------------------|
| Comparable  | `compareTo()`  | Естественное упорядочивание   | Сортировка по ID сотрудника |
| Comparator  | `compare()`    | Пользовательские критерии     | Сортировка по имени или зарплате |

### Примеры реализации

#### 1. Использование Comparable

```java
class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee other) {
        return this.id - other.id;
    }
}
```

#### 2. Использование Comparator

```java
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salary - emp2.salary;
    }
}
```

### Методы сортировки

```java
// Использование Comparable (естественное упорядочивание)
Collections.sort(employees);

// Использование Comparator (пользовательское упорядочивание)
Collections.sort(employees, new SalaryComparator());
```

Код урока доступен в следующих файлах:

- [StringSortExample.java](./comparation/StringSortExample.java)
- [ComparableEmployeeExample.java](./comparation/ComparableEmployeeExample.java)
- [EmployeeSort.java](./comparation/EmployeeSort.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 2: Дженерики в Java

Этот урок охватывает:

- Обобщённые классы и интерфейсы
- Параметры типов и их ограничения
- Wildcards в обобщённых типах
- Концепцию стирания типов
- Практические примеры с Командами и Участниками

### Обзор дженериков

| Концепция | Описание | Пример использования |
|-----------|----------|---------------------|
| Параметр типа | Заполнитель обобщённого типа | `class Box<T>` |
| Ограниченный тип | Ограничение обобщённых типов | `<T extends Number>` |
| Wildcard | Неизвестный обобщённый тип | `List<?>` |

### Примеры реализации

#### 1. Обобщённый класс

```java
class Team<T extends Participant> {
    private List<T> participants = new ArrayList<>();
    
    public void addParticipant(T participant) {
        participants.add(participant);
    }
}
```

#### 2. Использование Wildcard

```java
public static double sum(ArrayList<? extends Number> list) {
    double sum = 0;
    for (Number n : list) {
        sum += n.doubleValue();
    }
    return sum;
}
```

### Обобщённые методы

```java
public static <T> T getSecondElement(ArrayList<T> list) {
    return list.get(1);
}
```

Код урока доступен в следующих файлах:

Базовые примеры дженериков:

- [ParameterizedClass.java](./generics/ParameterizedClass.java)
- [ParameterizedClass2.java](./generics/ParameterizedClass2.java)
- [ParameterizedMethod.java](./generics/ParameterizedMethod.java)
- [GenericsBoundingExample.java](./generics/GenericsBoundingExample.java)
- [WildcardExample.java](./generics/WildcardExample.java)
- [TypeErasure.java](./generics/TypeErasure.java)

Реализация командной игры:

- [Team.java](./generics/game/Team.java)
- [Participant.java](./generics/game/Participant.java)
- [Employee.java](./generics/game/Employee.java)
- [Student.java](./generics/game/Student.java)
- [Schoolar.java](./generics/game/Schoolar.java)
- [Test.java](./generics/game/Test.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 3: Java Collections Framework

Этот урок охватывает:

- ArrayList и его методы
- Реализация LinkedList
- Классы Vector и Stack
- Iterator и ListIterator
- Интерфейсы Queue и Deque
- Реализации интерфейса Set
- Реализации интерфейса Map

### Нотация Big O для коллекций

Эффективность операций с коллекциями выражается с помощью нотации Big O, включая лучший и худший случаи:

| Нотация | Название | Описание |
|----------|------|-------------|
| O(1) | Константная | Время не зависит от размера коллекции |
| O(log n) | Логарифмическая | Время растет логарифмически с размером |
| O(n) | Линейная | Время растет линейно с размером |
| O(n²) | Квадратичная | Время растет квадратично с размером |

#### Сложность основных операций (лучший и худший случай)

##### ArrayList

| Операция | Лучший случай | Худший случай | Примечания |
|-----------|-----------|------------|--------|
| Добавление | O(1) | O(n) | Амортизированная O(1) при добавлении в конец; изменение размера вызывает O(n) |
| Удаление | O(1) | O(n) | O(1) при удалении последнего элемента; O(n) в других случаях |
| Поиск | O(1) | O(n) | O(1) если известен индекс; O(n) для поиска по значению |
| Доступ | O(1) | O(1) | Прямой доступ по индексу |

##### LinkedList

| Операция | Лучший случай | Худший случай | Примечания |
|-----------|-----------|------------|--------|
| Добавление | O(1) | O(n) | O(1) в начало/конец; O(n) для произвольных позиций |
| Удаление | O(1) | O(n) | O(1) в начале/конце; O(n) для произвольных позиций |
| Поиск | O(1) | O(n) | O(1) для начала/конца; O(n) в остальных случаях |
| Доступ | O(1) | O(n) | O(1) для начала/конца; O(n) для последовательного доступа |

##### HashSet

| Операция | Лучший случай | Худший случай | Примечания |
|-----------|-----------|------------|--------|
| Добавление | O(1) | O(n) | Коллизии могут ухудшить до O(n) (или O(log n) в Java 8+ с деревьями) |
| Удаление | O(1) | O(n) | Худший случай из-за коллизий |
| Поиск | O(1) | O(n) | Худший случай из-за коллизий |
| Доступ | N/A | N/A | Нет прямого доступа к элементам |

##### TreeSet

| Операция | Лучший случай | Худший случай | Примечания |
|-----------|-----------|------------|--------|
| Добавление | O(log n) | O(log n) | Самобалансирующееся дерево (например, красно-черное) |
| Удаление | O(log n) | O(log n) | Постоянная логарифмическая сложность |
| Поиск | O(log n) | O(log n) | Сбалансированная структура обеспечивает эффективность |
| Доступ | O(log n) | O(log n) | Доступ через итераторы или методы |

##### HashMap

| Операция | Лучший случай | Худший случай | Примечания |
|-----------|-----------|------------|--------|
| Добавление | O(1) | O(n) | Коллизии могут ухудшить до O(n) (или O(log n) в Java 8+ с деревьями) |
| Удаление | O(1) | O(n) | Худший случай из-за коллизий |
| Поиск | O(1) | O(n) | Худший случай из-за коллизий |
| Доступ | O(1) | O(n) | Прямой доступ к корзинам; коллизии влияют на производительность |

##### TreeMap

| Операция | Лучший случай | Худший случай | Примечания |
|-----------|-----------|------------|--------|
| Добавление | O(log n) | O(log n) | Самобалансирующаяся древовидная структура |
| Удаление | O(log n) | O(log n) | Постоянная логарифмическая сложность |
| Поиск | O(log n) | O(log n) | Поиск по ключу |
| Доступ | O(log n) | O(log n) | Доступ через поиск по ключу |

#### Важные замечания:

**ArrayList:**

- Добавление/удаление в конце: Амортизированная O(1) (операции изменения размера редки)
- Худший случай удаления (например, первого элемента) требует сдвига всех элементов

**LinkedList:**

- Произвольная вставка/удаление O(n) из-за обхода, но O(1) в начале/конце

**HashSet/HashMap:**

- Предполагает хорошую хеш-функцию. В Java 8+ коллизии используют древовидные узлы (худший случай O(log n))

**TreeSet/TreeMap:**

- Всегда сбалансированы (например, красно-черные деревья в Java), обеспечивая стабильную производительность O(log n)

### Иерархия коллекций и отображений

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

### Примеры реализации интерфейса List

#### Операции ArrayList

```java
ArrayList<String> list = new ArrayList<>();
list.add("Яблоко");        // Добавление элементов
list.add(1, "Апельсин");   // Добавление по индексу
list.remove("Яблоко");     // Удаление элемента
list.get(0);              // Доступ к элементу
list.set(0, "Банан");     // Замена элемента
list.indexOf("Банан");    // Поиск индекса элемента
```

#### LinkedList vs ArrayList

| Операция | ArrayList | LinkedList |
|--------------|-----------|------------|
| Добавление/удаление в конце | O(1) | O(1) |
| Добавление/удаление в середине | O(n) | O(1) |
| Получение/установка | O(1) | O(n) |
| Использование памяти | Меньше | Больше |

### Реализации интерфейса Queue

#### Пример PriorityQueue

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();
queue.offer(5);        // Добавление элементов
queue.offer(1);
queue.poll();          // Удаление элемента с наивысшим приоритетом
queue.peek();          // Просмотр элемента с наивысшим приоритетом
```

### Реализации интерфейса Set

| Реализация | Порядок | Null-элементы | Дубликаты | Производительность |
|----------------|-------|---------------|------------|-------------|
| HashSet | Нет | Один null | Нет | O(1) |
| LinkedHashSet | Вставки | Один null | Нет | O(1) |
| TreeSet | Естественный | Нет null | Нет | O(log n) |

### Реализации интерфейса Map

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Один", 1);            // Добавление записей
map.get("Один");              // Получение значений
map.remove("Один");           // Удаление записей
map.containsKey("Один");      // Проверка наличия ключа
map.containsValue(1);         // Проверка наличия значения
```

### Обзор важных методов

| Тип коллекции | Ключевые методы |
|----------------|-------------|
| List | add(), remove(), get(), set(), indexOf() |
| Queue | offer(), poll(), peek() |
| Set | add(), remove(), contains() |
| Map | put(), get(), remove(), containsKey() |

### Шаблоны итерации

```java
// Использование Iterator
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
}

// Использование ListIterator (двунаправленный)
ListIterator<String> listIterator = list.listIterator();
while (listIterator.hasNext()) {
    listIterator.next();
    listIterator.previous();
}
```

### Бинарный поиск и сортировка

```java
Collections.sort(list);                    // Естественный порядок
Collections.sort(list, comparator);        // Пользовательский порядок
int index = Collections.binarySearch(list, key);  // Бинарный поиск
```

Код урока доступен в следующих файлах:

Примеры ArrayList:

- [ArrayListEx1.java](./collection/ArrayListEx1.java)
- [ArrayListMethods1.java](./collection/ArrayListMethods1.java)
- [ArrayListMethods2.java](./collection/ArrayListMethods2.java)
- [ArrayListMethods3.java](./collection/ArrayListMethods3.java)
- [ArrayListMethods4.java](./collection/ArrayListMethods4.java)
- [ArrayListMethods5.java](./collection/ArrayListMethods5.java)

LinkedList и итерация:

- [LinkedListEx1.java](./collection/LinkedListEx1.java)
- [IteratorExample.java](./collection/IteratorExample.java)
- [ListIteratorExample.java](./collection/ListIteratorExample.java)

Vector и Stack:

- [VectorExample.java](./collection/VectorExample.java)
- [StackExample.java](./collection/StackExample.java)
- [StackExample2.java](./collection/StackExample2.java)

Реализации Queue:

- [LinkedListExample.java](./collection/queue_interface/LinkedListExample.java)
- [PriorityQueueExample1.java](./collection/queue_interface/PriorityQueueExample1.java)
- [PriorityQueueExample2.java](./collection/queue_interface/PriorityQueueExample2.java)
- [ArrayDequeExample.java](./collection/queue_interface/ArrayDequeExample.java)

Реализации Set:

- [HashSetExample.java](./collection/set_interface/HashSetExample.java)
- [HashSetExample2.java](./collection/set_interface/HashSetExample2.java)
- [LinkedHashSetExample.java](./collection/set_interface/LinkedHashSetExample.java)
- [TreeSetExample.java](./collection/set_interface/TreeSetExample.java)
- [TreeSetExample2.java](./collection/set_interface/TreeSetExample2.java)

Реализации Map:

- [HashMapEx1.java](./collection/map_interface/HashMapEx1.java)
- [HashCodeEx1.java](./collection/map_interface/HashCodeEx1.java)
- [LinkedHashMapExample.java](./collection/map_interface/LinkedHashMapExample.java)
- [TreeMapExample.java](./collection/map_interface/TreeMapExample.java)
- [HashTableExample.java](./collection/map_interface/HashTableExample.java)

Утилиты:

- [BinarySearch.java](./collection/BinarySearch.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 4: Вложенные классы в Java

Этот урок охватывает:

- Статические вложенные классы
- Внутренние (нестатические вложенные) классы
- Локальные внутренние классы
- Анонимные внутренние классы
- Различия между типами вложенных классов

### Обзор типов вложенных классов

| Тип | Уровень доступа | Доступ к классу | Доступ к экземпляру | Пример использования |
|------|--------------|--------------|-----------------|------------------|
| Статический вложенный | Может обращаться только к статическим членам | Да | Нет | Вспомогательные классы, статические утилиты |
| Внутренний класс | Может обращаться ко всем членам | Да | Да | Обработчики событий, компоненты UI |
| Локальный внутренний | Может обращаться ко всем членам + final локальным | Да | Да | Одноразовые реализации |
| Анонимный | Может обращаться ко всем членам + final локальным | Нет | Да | Слушатели событий, обратные вызовы |

### Примеры реализации

#### 1. Пример статического вложенного класса

```java
public class Car {
    private static int staticField;
    
    public static class Engine {
        private int horsePower;
        
        public Engine(int horsePower) {
            System.out.println(staticField); // Может обращаться к статическим членам
            this.horsePower = horsePower;
        }
    }
}

// Использование
Car.Engine engine = new Car.Engine(150);
```

#### 2. Пример внутреннего класса

```java
public class Car {
    private int doorCount;
    
    public class Engine {
        private int horsePower;
        
        public Engine(int horsePower) {
            System.out.println(doorCount); // Может обращаться ко всем членам
            this.horsePower = horsePower;
        }
    }
}

// Использование
Car car = new Car();
Car.Engine engine = car.new Engine(120);
```

#### 3. Пример локального внутреннего класса

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
        System.out.println("Частное: " + division.getQuotient());
    }
}
```

#### 4. Пример анонимного внутреннего класса

```java
public class AnonymousClass {
    public static void main(String[] args) {
        Math2 summation = new Math2() {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };
        
        System.out.println("Сумма: " + summation.doOperation(10, 20));
    }
}
```

### Ключевые характеристики

| Особенность | Статический вложенный | Внутренний класс | Локальный внутренний | Анонимный внутренний |
|---------|--------------|-------------|-------------|-----------------|
| Доступ к внешним членам | Только статические | Все | Все + локальные переменные | Все + локальные переменные |
| Может иметь статические члены | Да | Нет | Нет | Нет |
| Может обращаться к локальным переменным | Нет | Нет | Да (final/эффективно final) | Да (final/эффективно final) |
| Может быть создан без экземпляра внешнего класса | Да | Нет | Н/П | Н/П |

### Типичные случаи использования

1. **Статические вложенные классы:**
   - Группировка служебных классов
   - Реализация вспомогательной функциональности
   - Инкапсуляция связанных статических методов

2. **Внутренние классы:**
   - Обработка событий UI
   - Поддержание состояния объекта
   - Реализация узлов структуры данных

3. **Локальные внутренние классы:**
   - Сложные операции в методах
   - Одноразовые реализации
   - Инкапсуляция логики, специфичной для метода

4. **Анонимные внутренние классы:**
   - Слушатели событий
   - Реализации обратных вызовов
   - Быстрые реализации интерфейсов

### Лучшие практики

1. Используйте статические вложенные классы когда:
   - Вложенному классу не нужен доступ к членам экземпляра
   - Вы хотите сгруппировать связанные служебные классы

2. Используйте внутренние классы когда:
   - Классу нужен доступ к приватным членам внешнего класса
   - Существует четкая связь между классами

3. Используйте локальные внутренние классы когда:
   - Класс нужен только в одном методе
   - Нужен доступ к локальным переменным

4. Используйте анонимные внутренние классы когда:
   - Нужна одноразовая реализация
   - Класс очень простой (мало методов)

Код урока доступен в следующих файлах:

Примеры статических вложенных классов:

- [Car.java](./nested_classes/static_nested_class/Car.java)

Примеры внутренних классов:

- [Car.java](./nested_classes/inner_class/Car.java)

Примеры локальных внутренних классов:

- [LocalInner1.java](./nested_classes/local_inner_class/LocalInner1.java)
- [LocalInner2.java](./nested_classes/local_inner_class/LocalInner2.java)

Примеры анонимных классов:

- [AnonymousClass.java](./nested_classes/anonymous_class/AnonymousClass.java)

Базовый пример:

- [Test.java](./nested_classes/Test.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 5: Лямбда-выражения в Java

Этот урок охватывает:

- Синтаксис лямбда-выражений и функциональные интерфейсы
- Встроенные функциональные интерфейсы
- Ссылки на методы
- Интерфейсы Consumer, Supplier, Function
- Predicate и его вариации 
- Основы Stream API с лямбда-выражениями

### Обзор лямбда-выражений

| Концепция | Описание | Пример |
|-----------|----------|--------|
| Синтаксис лямбды | `(параметры) -> выражение` | `(a, b) -> a + b` |
| Функциональный интерфейс | Интерфейс с одним абстрактным методом | `@FunctionalInterface` |
| Ссылка на метод | Сокращенная форма для простых лямбд | `String::length` |

### Примеры базового синтаксиса лямбда-выражений

```java
// Простая лямбда с одним параметром
StringProcessor processor = (str) -> str.length();

// Лямбда с несколькими параметрами
Math2 operation = (a, b) -> a + b;

// Лямбда с блоком кода
Math2 complexOperation = (a, b) -> {
    System.out.println("Обработка...");
    return a + b;
};
```

### Встроенные функциональные интерфейсы

#### Интерфейс Consumer

```java
// Пример Consumer
Consumer<Car> carModifier = car -> {
    car.color = "Красный";
    car.engine = 3.0;
};

// Использование
changeCar(car, carModifier);
```

#### Интерфейс Supplier

```java
// Пример Supplier
Supplier<Car> carSupplier = () -> new Car("BMW", "Черный", 2.4);

// Использование
ArrayList<Car> cars = createThreeCars(carSupplier);
```

#### Интерфейс Function

```java
// Пример Function
Function<String, Integer> lengthFunction = str -> str.length();

// Использование
Integer length = lengthFunction.apply("привет");
```

#### Интерфейс Predicate

```java
// Пример Predicate
Predicate<String> lengthPredicate = s -> s.length() > 5;
Predicate<String> shortPredicate = s -> s.length() < 3;

// Комбинирование предикатов
list.removeIf(lengthPredicate.or(shortPredicate));
```

### ForEach с лямбда-выражением

```java
List<String> list = List.of("привет", "мир", "java");

// Использование лямбды
list.forEach(item -> System.out.println(item));

// Использование ссылки на метод
list.forEach(System.out::println);
```

### Пример фильтрации студентов

```java
// Использование лямбды для пользовательской фильтрации
void testStudents(ArrayList<Student> students, Predicate<Student> predicate) {
    for (Student student : students) {
        if (predicate.test(student)) {
            System.out.println(student);
        }
    }
}

// Использование
studentInfo.testStudents(students, s -> s.getGrade() > 8.0);
```

### Ключевые особенности лямбда-выражений

1. **Лаконичный синтаксис:**
   - Не требуется имя метода
   - Вывод типов для параметров
   - Одиночное выражение может опускать фигурные скобки и return

2. **Доступ к переменным:**
   - Может обращаться к final или эффективно final локальным переменным
   - Может обращаться к переменным экземпляра и статическим переменным
   - Не может изменять локальные переменные

3. **Совместимость с функциональными интерфейсами:**
   - Должны использоваться с функциональными интерфейсами
   - Интерфейс должен иметь ровно один абстрактный метод
   - Может иметь несколько методов по умолчанию

### Общие встроенные функциональные интерфейсы

| Интерфейс | Метод | Описание | Пример использования |
|-----------|-------|----------|---------------------|
| Consumer<T> | accept(T) | Принимает вход, ничего не возвращает | Модификация объектов |
| Supplier<T> | get() | Без входа, возвращает результат | Создание объектов |
| Function<T,R> | apply(T) | Преобразует T в R | String в Integer |
| Predicate<T> | test(T) | Возвращает boolean | Фильтрация коллекций |

### Лучшие практики

1. Используйте лямбда-выражения когда:
   - Работаете с коллекциями
   - Реализуете обработчики событий
   - Пишете функции обратного вызова
   - Создаете задачи для потоков

2. Предпочитайте ссылки на методы когда:
   - Лямбда просто вызывает один метод
   - Метод уже существует
   - Код становится более читаемым

3. Выбирайте подходящие функциональные интерфейсы:
   - Consumer для побочных эффектов
   - Supplier для отложенной инициализации
   - Function для преобразований
   - Predicate для фильтрации

Код урока доступен в следующих файлах:

Основы лямбда-выражений:

- [LambdaStringLengthExample.java](./lambda/LambdaStringLengthExample.java)

Функциональные интерфейсы:

- [ConsumerDemo.java](./lambda/ConsumerDemo.java)
- [SupplierDemo.java](./lambda/SupplierDemo.java)
- [FunctionDemo.java](./lambda/FunctionDemo.java)

Операции с коллекциями:

- [ForEachDemo.java](./lambda/ForEachDemo.java)
- [RemoveIf.java](./lambda/RemoveIf.java)

Пример со студентами:

- [Student.java](./lambda/Student.java)
- [StudentInfo.java](./lambda/StudentInfo.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 6: Java Stream API

Этот урок охватывает:

- Создание и операции со стримами
- Преобразования map и flatMap
- Фильтрация и сортировка
- Терминальные операции и коллекторы
- Параллельные стримы
- Операции с числовыми стримами

### Обзор Stream API

| Концепция | Описание | Пример |
|-----------|----------|--------|
| Stream | Последовательность элементов | `List.stream()` |
| Промежуточные операции | Возвращают новый стрим | `map(), filter()` |
| Терминальные операции | Производят результат | `collect(), reduce()` |
| Параллельная обработка | Многопоточное выполнение | `parallelStream()` |

### Создание стримов и базовые операции

#### Создание стримов

```java
// Из коллекции
List<String> list = List.of("Java", "Python", "C++");
Stream<String> stream1 = list.stream();

// Из массива
int[] array = {1, 2, 3, 4, 5};
IntStream stream2 = Arrays.stream(array);

// Использование Stream.of()
Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
```

### Операции map

```java
// Простое отображение
List<Integer> lengthList = list.stream()
    .map(String::length)
    .collect(Collectors.toList());

// Сложное отображение с условиями
array = Arrays.stream(array)
    .map(element -> {
        if (element % 3 == 0) {
            element = element / 3;
        }
        return element;
    }).toArray();
```

### Операции flatMap

```java
// Выравнивание вложенных коллекций
List<Faculty> faculties = // ...
faculties.stream()
    .flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
    .forEach(student -> System.out.println(student.getName()));
```

### Фильтрация и сортировка

```java
students.stream()
    .filter(element -> element.getAge() > 20)
    .sorted((x, y) -> x.getName().compareTo(y.getName()))
    .forEach(System.out::println);
```

### Числовые операции

```java
// Вычисление суммы
int sum = students.stream()
    .mapToInt(Student::getCourse)
    .sum();

// Вычисление среднего
double average = students.stream()
    .mapToInt(Student::getCourse)
    .average()
    .getAsDouble();

// Минимум и максимум
StudentFilter min = students.stream()
    .min((x, y) -> x.getAge() - y.getAge())
    .get();
```

### Коллекторы

```java
// Группировка
Map<Integer, List<StudentFilter>> courseMap = students.stream()
    .collect(Collectors.groupingBy(StudentFilter::getCourse));

// Разделение
Map<Boolean, List<StudentFilter>> gradeMap = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getAvgGrade() > 3.5));
```

### Цепочки методов

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

### Параллельные стримы

```java
// Параллельная обработка
double sum = numbers.parallelStream()
    .reduce((a, b) -> a + b)
    .get();

// Последовательная обработка (когда порядок важен)
double division = numbers.stream()
    .reduce((a, b) -> a / b)
    .get();
```

### Обзор операций со стримами

#### Промежуточные операции

| Операция | Описание | Пример |
|----------|----------|--------|
| map() | Преобразование элементов | `stream.map(String::length)` |
| filter() | Фильтрация элементов | `stream.filter(n -> n > 0)` |
| sorted() | Сортировка элементов | `stream.sorted()` |
| distinct() | Удаление дубликатов | `stream.distinct()` |
| limit() | Ограничение размера стрима | `stream.limit(5)` |
| skip() | Пропуск элементов | `stream.skip(2)` |

#### Терминальные операции

| Операция | Описание | Пример |
|----------|----------|--------|
| collect() | Сбор результатов | `stream.collect(toList())` |
| forEach() | Обработка элементов | `stream.forEach(System.out::println)` |
| reduce() | Сведение к единому значению | `stream.reduce(0, Integer::sum)` |
| count() | Подсчет элементов | `stream.count()` |
| min()/max() | Поиск мин/макс | `stream.min(Comparator.naturalOrder())` |
| findFirst() | Поиск первого элемента | `stream.findFirst()` |

### Лучшие практики

1. Используйте стримы когда:
   - Обрабатываете коллекции данных
   - Выполняете несколько операций последовательно
   - Нужна параллельная обработка

2. Избегайте стримов когда:
   - Изменяете состояние во время обработки
   - Используете break/continue/return
   - Нужна отладка в императивном стиле

3. Соображения производительности:
   - Параллельные стримы для больших наборов данных
   - Учитывайте стоимость операций
   - Будьте осторожны с операциями, зависящими от состояния

Код урока доступен в следующих файлах:

Базовые операции со стримами:

- [`StreamMapDemo.java`](./stream/StreamMapDemo.java)
- [`StreamOperationsDemo.java`](./stream/StreamOperationsDemo.java)
- [`StreamMethodChainingDemo.java`](./stream/StreamMethodChainingDemo.java)

Продвинутые операции:

- [`StreamFlatMapDemo.java`](./stream/StreamFlatMapDemo.java)
- [`StreamReduceDemo.java`](./stream/StreamReduceDemo.java)
- [`StreamCollectorsDemo.java`](./stream/StreamCollectorsDemo.java)

Операции с массивами и числами:

- [`ArrayStreamDemo.java`](./stream/ArrayStreamDemo.java)
- [`StreamNumericOperationsDemo.java`](./stream/StreamNumericOperationsDemo.java)

Обработка студентов:

- [`StudentStreamDemo.java`](./stream/StudentStreamDemo.java)

Параллельная обработка:

- [`ParallelStreamDemo.java`](./stream/ParallelStreamDemo.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 7: Многопоточность в Java

Этот урок охватывает:

- Создание потоков и их жизненный цикл
- Механизмы синхронизации
- Координация потоков
- Пулы потоков и исполнители
- Потокобезопасные коллекции
- Продвинутые концепции многопоточности

### Обзор создания потоков и жизненного цикла

| Метод создания | Описание | Случай использования |
|----------------|----------|-----------|
| Наследование Thread | Прямое наследование | Простые задачи потока |
| Реализация Runnable | Реализация интерфейса | Более гибкий подход, допускает другое наследование |
| Анонимные классы | Одноразовые определения потока | Быстрое создание потока |
| Лямбда-выражения | Современный синтаксис | Лаконичное создание потока |

### Состояния потока

```java
// NEW -> RUNNABLE -> RUNNING -> TERMINATED
Thread thread = new Thread(new WorkerTask());  // NEW
System.out.println(thread.getState());        // NEW
thread.start();                               // RUNNABLE
thread.join();                                // WAITING/TIMED_WAITING
// Поток завершается                         // TERMINATED
```

#### Переходы состояний потока

| Состояние | Описание | Вызывается |
|-----------|----------|------------|
| NEW | Поток создан, но не запущен | new Thread() |
| RUNNABLE | Поток выполняется или готов к выполнению | start() |
| BLOCKED | Ожидает блокировки монитора | Вход в synchronized блок/метод |
| WAITING | Бесконечное ожидание другого потока | wait(), join() |
| TIMED_WAITING | Ожидание в течение указанного времени | sleep(), wait(timeout), join(timeout) |
| TERMINATED | Поток завершил выполнение | Метод run() завершился |

### Базовые примеры потоков

#### 1. Наследование Thread

```java
class CountUpThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

// Использование
CountUpThread thread = new CountUpThread();
thread.start();
```

#### 2. Реализация Runnable

```java
class CounterRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

// Использование
Thread thread = new Thread(new CounterRunnable());
thread.start();
```

### Синхронизация потоков

#### 1. Синхронизированные методы

```java
public class Counter {
    private static int count = 0;
    
    public static synchronized void increment() {
        count++;
    }
}
```

#### 2. Синхронизированные блоки

```java
// Использование this как замка
synchronized(this) {
    // Критическая секция
}

// Использование блокировки класса
synchronized(ClassName.class) {
    // Критическая секция
}

// Использование пользовательского объекта блокировки
private final Object lock = new Object();
synchronized(lock) {
    // Критическая секция
}
```

### Взаимодействие потоков

#### Шаблон Wait/Notify

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

### Типы пулов потоков

| Тип | Описание | Случай использования |
|------|-------------|----------|
| Fixed | Фиксированное число потоков | Стабильная, предсказуемая нагрузка |
| Cached | Создаёт потоки по необходимости | Переменное число коротких задач |
| Scheduled | Может планировать будущие/периодические задачи | Отложенное/периодическое выполнение |
| Single | Пул с одним потоком | Последовательная обработка задач |

```java
// Фиксированный пул потоков
ExecutorService fixedPool = Executors.newFixedThreadPool(5);

// Кэшированный пул потоков
ExecutorService cachedPool = Executors.newCachedThreadPool();

// Планируемый пул потоков
ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);

// Пример использования
scheduledPool.scheduleAtFixedRate(task, 3, 2, TimeUnit.SECONDS);
```

### Инструменты координации потоков

#### CountDownLatch

```java
CountDownLatch latch = new CountDownLatch(3);

// Ожидающий поток
latch.await(); // Ждёт, пока счётчик не достигнет нуля

// Рабочие потоки
latch.countDown(); // Уменьшает счётчик
```

#### Semaphore

```java
Semaphore semaphore = new Semaphore(2); // 2 разрешения

// Получение разрешения
semaphore.acquire();
try {
    // Критическая секция
} finally {
    semaphore.release(); // Освобождение разрешения
}
```

#### ReentrantLock

```java
private Lock lock = new ReentrantLock();

public void someMethod() {
    lock.lock();
    try {
        // Критическая секция
    } finally {
        lock.unlock();
    }
}
```

### Потокобезопасные коллекции

| Коллекция | Описание | Ключевые особенности |
|------------|-------------|--------------|
| ConcurrentHashMap | Потокобезопасная карта | Сегментная блокировка, без null |
| CopyOnWriteArrayList | Потокобезопасный список | Копирование при модификации |
| ArrayBlockingQueue | Ограниченная блокирующая очередь | FIFO, ограниченный размер |
| ConcurrentLinkedQueue | Неограниченная очередь | Неблокирующий алгоритм |

```java
// Пример ConcurrentHashMap
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
map.put(1, "Один");
map.putIfAbsent(2, "Два");

// Пример CopyOnWriteArrayList
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
list.add("Элемент");
Iterator<String> iterator = list.iterator(); // Снимок итератора
```

### Продвинутые концепции

#### Volatile переменные

```java
public class VolatileExample {
    private volatile boolean flag = false;
    
    public void setFlag() {
        flag = true; // Видимо всем потокам
    }
    
    public boolean isFlag() {
        return flag;
    }
}
```

#### Атомарные переменные

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

### Лучшие практики

1. Создание потоков
   - Предпочитайте ExecutorService вместо ручного создания потоков
   - Используйте пулы потоков для множества схожих задач
   - Учитывайте управление жизненным циклом потоков

2. Синхронизация
   - Используйте synchronized экономно
   - Предпочитайте потокобезопасные коллекции synchronized блокам
   - Держите synchronized блоки маленькими

3. Потокобезопасность
   - Делайте классы неизменяемыми, когда возможно
   - Используйте потокобезопасные коллекции
   - Избегайте разделения изменяемого состояния

4. Управление ресурсами
   - Всегда правильно закрывайте ExecutorService
   - Освобождайте блокировки в блоках finally
   - Очищайте ресурсы потоков

5. Производительность
   - Балансируйте размер пула потоков
   - Избегайте конкуренции потоков
   - Используйте подходящие типы коллекций

Код урока доступен в следующих файлах:

Создание потоков:

- [`ThreadExtensionExample.java`](./multithreading/ThreadExtensionExample.java)
- [`RunnableImplementationExample.java`](./multithreading/RunnableImplementationExample.java)
- [`AnonymousThreadExample.java`](./multithreading/AnonymousThreadExample.java)

Состояния и управление потоками:

- [`ThreadStateExample.java`](./multithreading/ThreadStateExample.java)
- [`ThreadAttributesExample.java`](./multithreading/ThreadAttributesExample.java)
- [`ThreadSleepExample.java`](./multithreading/ThreadSleepExample.java)
- [`ThreadJoinExample.java`](./multithreading/ThreadJoinExample.java)
- [`InterruptionExample.java`](./multithreading/InterruptionExample.java)
- [`DaemonExample.java`](./multithreading/DaemonExample.java)

Синхронизация:

- [`SynchronizedMethodExample.java`](./multithreading/SynchronizedMethodExample.java)
- [`ThisLockExample.java`](./multithreading/ThisLockExample.java)
- [`ClassLockExample.java`](./multithreading/ClassLockExample.java)
- [`SharedLockExample.java`](./multithreading/SharedLockExample.java)
- [`DataRaceExample.java`](./multithreading/DataRaceExample.java)
- [`DeadLockExample.java`](./multithreading/DeadLockExample.java)

Координация потоков:

- [`WaitNotifyExample.java`](./multithreading/WaitNotifyExample.java)
- [`CountDownLatchExample.java`](./multithreading/CountDownLatchExample.java)
- [`SemaphoreExample.java`](./multithreading/SemaphoreExample.java)
- [`ExchangerExample.java`](./multithreading/ExchangerExample.java)
- [`LockExample.java`](./multithreading/LockExample.java)
- [`ATMQueueExample.java`](./multithreading/ATMQueueExample.java)

Пулы потоков:

- [`ThreadPoolExample1.java`](./multithreading/ThreadPoolExample1.java)
- [`ThreadPoolExample2.java`](./multithreading/ThreadPoolExample2.java)
- [`CallableFactorial.java`](./multithreading/CallableFactorial.java)
- [`RunnableFactorial.java`](./multithreading/RunnableFactorial.java)
- [`SumNumbersCallable.java`](./multithreading/SumNumbersCallable.java)

Потокобезопасные коллекции:

- [`ConcurrentHashMapExample.java`](./multithreading/thread_safe/ConcurrentHashMapExample.java)
- [`CopyOnWriteArrayListExample.java`](./multithreading/thread_safe/CopyOnWriteArrayListExample.java)
- [`ArrayBlockingQueueExample.java`](./multithreading/thread_safe/ArrayBlockingQueueExample.java)
- [`ArrayBlockingQueueExample2.java`](./multithreading/thread_safe/ArrayBlockingQueueExample2.java)
- [`SynchronizedCollectionExample.java`](./multithreading/thread_safe/SynchronizedCollectionExample.java)
- [`SynchronizedCollectionExample2.java`](./multithreading/thread_safe/SynchronizedCollectionExample2.java)

Атомарные операции:

- [`AtomicIntegerExample.java`](./multithreading/AtomicIntegerExample.java)
- [`VolatileVisibilityExample.java`](./multithreading/VolatileVisibilityExample.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 8: Работа с файлами в Java

Этот урок охватывает:

- Операции с файловой системой
- Потоки ввода/вывода
- Символьные потоки (Readers/Writers)
- Файлы с произвольным доступом
- API NIO.2 (Paths, Files, Channels)
- Обход файлов и каталогов
- Сериализация

### Обзор файловых операций

| Тип операции | Устаревший (java.io.File) | Современный (java.nio.Path) |
|---------------|----------------------|----------------------|
| Создание | `file.createNewFile()` | `Files.createFile(path)` |
| Удаление | `file.delete()` | `Files.delete(path)` |
| Проверка существования | `file.exists()` | `Files.exists(path)` |
| Получение свойств | `file.length()` | `Files.size(path)` |

### Методы доступа к файлам

#### 1. Базовые операции с файлами

```java
// Использование класса File
File file = new File("FileForExample.txt");
System.out.println("Существует: " + file.exists());
System.out.println("Размер: " + file.length());
System.out.println("Это каталог: " + file.isDirectory());

// Использование Path/Files
Path path = Paths.get("FileForExample.txt");
System.out.println("Существует: " + Files.exists(path));
System.out.println("Размер: " + Files.size(path));
System.out.println("Это каталог: " + Files.isDirectory(path));
```

### Обзор типов потоков

| Тип потока | Бинарные данные | Символьные данные | Пример использования |
|-------------|-------------|----------------|------------------|
| InputStream/OutputStream | Да | Нет | Изображения, бинарные данные |
| Reader/Writer | Нет | Да | Текстовые файлы |
| RandomAccessFile | Да | Да | Операции типа базы данных |
| Channel/Buffer | Да | Да | Высокопроизводительный ввод/вывод |

### Операции с текстовыми файлами

#### 1. Чтение текста (FileReader)

```java
try (FileReader reader = new FileReader("FileForExample.txt")) {
    int character;
    while ((character = reader.read()) != -1) {
        System.out.print((char) character);
    }
}
```

#### 2. Запись текста (FileWriter)

```java
try (FileWriter writer = new FileWriter("FileForExample.txt", true)) {
    String text = "Привет, мир!\n";
    writer.write(text);
}
```

#### 3. Буферизированные операции

```java
// Буферизированное чтение
try (BufferedReader reader = new BufferedReader(
        new FileReader("FileForExample.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}

// Буферизированная запись
try (BufferedWriter writer = new BufferedWriter(
        new FileWriter("FileForExample.txt"))) {
    writer.write("Привет");
    writer.newLine();
    writer.write("Мир");
}
```

### Операции с бинарными файлами

#### 1. Базовые операции с потоками

```java
// Чтение байтов
try (FileInputStream fis = new FileInputStream("ImageForExample.png")) {
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = fis.read(buffer)) != -1) {
        // Обработка байтов
    }
}

// Запись байтов
try (FileOutputStream fos = new FileOutputStream("output.png")) {
    byte[] data = // ... ваши бинарные данные
    fos.write(data);
}
```

#### 2. Потоки данных для примитивов

```java
// Запись примитивных типов
try (DataOutputStream dos = new DataOutputStream(
        new FileOutputStream("data.bin"))) {
    dos.writeInt(123);
    dos.writeDouble(3.14);
    dos.writeUTF("Привет");
}

// Чтение примитивных типов
try (DataInputStream dis = new DataInputStream(
        new FileInputStream("data.bin"))) {
    int number = dis.readInt();
    double decimal = dis.readDouble();
    String text = dis.readUTF();
}
```

### Файлы с произвольным доступом

```java
try (RandomAccessFile raf = 
        new RandomAccessFile("FileForExample.txt", "rw")) {
    // Чтение с определённой позиции
    raf.seek(100);
    byte[] bytes = new byte[50];
    raf.read(bytes);
    
    // Запись в определённую позицию
    raf.seek(raf.length()); // Переход в конец
    raf.write("Новые данные".getBytes());
}
```

### Современные операции NIO.2

#### 1. Операции с путями

```java
Path path = Paths.get("work_with_files/test.txt");
System.out.println("Имя файла: " + path.getFileName());
System.out.println("Родитель: " + path.getParent());
System.out.println("Корень: " + path.getRoot());
System.out.println("Абсолютный путь: " + path.toAbsolutePath());
```

#### 2. Класс утилит Files

```java
// Операции с файлами
Files.createFile(path);
Files.delete(path);
Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
Files.move(source, target);

// Чтение/Запись
List<String> lines = Files.readAllLines(path);
Files.write(path, lines);

// Атрибуты
System.out.println("Размер: " + Files.size(path));
System.out.println("Последнее изменение: " + 
    Files.getAttribute(path, "basic:lastModifiedTime"));
```

#### 3. Операции с каталогами

```java
// Создание структуры каталогов
Files.createDirectories(Paths.get("nested/dirs"));

// Список содержимого каталога
try (DirectoryStream<Path> stream = 
        Files.newDirectoryStream(Paths.get("."))) {
    for (Path entry : stream) {
        System.out.println(entry.getFileName());
    }
}
```

### Операции с деревом файлов

#### 1. Обход дерева файлов

```java
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, 
            BasicFileAttributes attrs) {
        System.out.println("Посещение файла: " + file);
        return FileVisitResult.CONTINUE;
    }
}

Files.walkFileTree(Paths.get("."), new MyFileVisitor());
```

#### 2. Копирование дерева каталогов

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

### Операции с каналами и буферами

```java
try (FileChannel channel = FileChannel.open(path, 
        StandardOpenOption.READ, StandardOpenOption.WRITE)) {
    // Чтение
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    channel.read(buffer);
    buffer.flip();
    
    // Запись
    buffer.clear();
    buffer.put("Привет".getBytes());
    buffer.flip();
    channel.write(buffer);
}
```

### Лучшие практики

1. Управление ресурсами:
   - Всегда используйте try-with-resources
   - Закрывайте ресурсы в блоке finally, если не используете try-with-resources
   - Используйте буферизированные операции для лучшей производительности

2. Обработка ошибок:
   - Обрабатывайте сначала специфичные исключения
   - Учитывайте права доступа к файловой системе
   - Проверяйте существование файлов перед операциями

3. Производительность:
   - Используйте буферизированные потоки для текстовых файлов
   - Используйте каналы для больших файлов
   - Используйте подходящие размеры буферов

4. Кодировки символов:
   - Явно указывайте кодировку символов
   - Используйте константы StandardCharsets
   - Учитывайте специфичные для платформы окончания строк

Код урока доступен в следующих файлах:

Базовые операции с файлами:

- [`FileExample.java`](./work_with_files/FileExample.java)
- [`PathAndFilesExample1.java`](./work_with_files/PathAndFilesExample1.java)
- [`PathAndFilesExample2.java`](./work_with_files/PathAndFilesExample2.java)
- [`PathAndFilesExample3.java`](./work_with_files/PathAndFilesExample3.java)

Операции с текстовыми файлами:

- [`TextFileReaderExample.java`](./work_with_files/TextFileReaderExample.java)
- [`TextFileWriterExample.java`](./work_with_files/TextFileWriterExample.java)
- [`FileCopyExample.java`](./work_with_files/FileCopyExample.java)

Операции с бинарными файлами:

- [`BinaryDataIOExample.java`](./work_with_files/BinaryDataIOExample.java)
- [`ImageFileCopyExample.java`](./work_with_files/ImageFileCopyExample.java)

Произвольный доступ:

- [`RandomAccessFileExample.java`](./work_with_files/RandomAccessFileExample.java)

Операции с каналами/буферами:

- [`ChannelBufferExample1.java`](./work_with_files/ChannelBufferExample1.java)
- [`ChannelBufferExample2.java`](./work_with_files/ChannelBufferExample2.java)

Операции с деревом файлов:

- [`FileTree.java`](./work_with_files/FileTree.java)
- [`CopyFileTree.java`](./work_with_files/CopyFileTree.java)
- [`DeleteFileTree.java`](./work_with_files/DeleteFileTree.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 9: Регулярные выражения в Java

Этот урок охватывает:

- Синтаксис регулярных выражений
- Классы Pattern и Matcher
- Распространенные шаблоны регулярных выражений
- Сопоставление шаблонов и группы
- Операции со строками с использованием регулярных выражений

### Обзор регулярных выражений

| Компонент | Описание | Пример | Совпадения |
|-----------|----------|---------|------------|
| Литерал | Точное совпадение текста | `"привет"` | "привет" |
| Символьный класс | Набор символов | `[аеиоу]` | Любая гласная |
| Предопределенный класс | Общие шаблоны | `\d`, `\w`, `\s` | Цифры, символы слов, пробелы |
| Квантификаторы | Повторение | `*`, `+`, `?`, `{n}` | Ноль/более, один/более, необязательный, ровно n |

### Примеры базовых шаблонов

```java
// Простой шаблон слова
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher("Привет Мир");

// Шаблон номера телефона
Pattern phonePattern = Pattern.compile("\\+\\d{9}");

// Шаблон email
Pattern emailPattern = Pattern.compile("\\w+@\\w+\\.(ru|com)");
```

### Распространенные шаблоны регулярных выражений

#### 1. Символьные классы

```java
// Один символ из набора
"[АБВ]"           // Соответствует А, Б или В
"[А-Я]"          // Соответствует А через Я
"[^АБВ]"         // Соответствует любому символу кроме А, Б или В
```

#### 2. Предопределенные классы

```java
"\\d"            // Любая цифра [0-9]
"\\D"            // Любой символ кроме цифры
"\\w"            // Символ слова [a-zA-Z0-9_]
"\\W"            // Не символ слова
"\\s"            // Пробельный символ
"\\S"            // Не пробельный символ
```

#### 3. Квантификаторы

```java
pattern = "\\w+"         // Один или более символов слова
pattern = "\\w*"         // Ноль или более символов слова
pattern = "\\w?"         // Ноль или один символ слова
pattern = "\\w{2,4}"     // От 2 до 4 символов слова
pattern = "\\w{2,}"      // 2 или более символов слова
```

### Операции с сопоставлением шаблонов

#### 1. Базовое сопоставление

```java
String text = "Привет, мой друг!";
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
    System.out.println("Найдено: " + matcher.group());
}
```

#### 2. Извлечение групп

```java
Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})");
Matcher matcher = pattern.matcher("1234567891234567");

if (matcher.matches()) {
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Группа " + i + ": " + matcher.group(i));
    }
}
```

### Строковые операции с регулярными выражениями

#### 1. Замена строк

```java
String text = "Привет,    мой    друг!";

// Замена множественных пробелов одним
text = text.replaceAll("\\s+", " ");

// Замена слов, начинающихся с 'м'
text = text.replaceAll("\\bм\\w+", "444");
```

#### 2. Разделение строк

```java
String text = "Привет, мой друг!";
String[] words = text.split("\\W+");
// Результат: ["Привет", "мой", "друг"]
```

### Флаги шаблонов

```java
// Регистронезависимое сопоставление
Pattern pattern = Pattern.compile("привет", Pattern.CASE_INSENSITIVE);

// Многострочный режим
Pattern pattern2 = Pattern.compile("^привет", Pattern.MULTILINE);
```

### Распространенные случаи использования

#### 1. Проверка email

```java
public static boolean isValidEmail(String email) {
    return email.matches("\\w+@\\w+\\.(com|ru)");
}
```

#### 2. Формат номера телефона

```java
public static boolean isValidPhone(String phone) {
    return phone.matches("\\+\\d{9}");
}
```

#### 3. Извлечение данных

```java
Pattern pattern = Pattern.compile(
    "(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
Matcher matcher = pattern.matcher("1234567891234567");
```

### Лучшие практики

1. Компиляция шаблонов:
   - Компилируйте шаблоны один раз и переиспользуйте
   - Используйте подходящие флаги при необходимости
   - Рассмотрите использование пула шаблонов для часто используемых

2. Производительность:
   - Избегайте чрезмерного обратного отслеживания
   - Используйте не захватывающие группы (?:) когда захват не нужен
   - Используйте StringBuilder для множественных замен

3. Сопровождаемость:
   - Документируйте сложные шаблоны
   - Разбивайте сложные шаблоны на меньшие части
   - Используйте именованные группы для ясности

4. Валидация:
   - Используйте привязки (^ и $) для полного совпадения строки
   - Учитывайте ограничения длины ввода
   - Обрабатывайте null-входы

Код урока доступен в следующих файлах:

Базовые примеры регулярных выражений:

- [`Regex1.java`](./regex/Regex1.java) - Базовое сопоставление шаблонов
- [`Regex2.java`](./regex/Regex2.java) - Общие шаблоны регулярных выражений
- [`Regex3.java`](./regex/Regex3.java) - Операции со строками
- [`Regex4.java`](./regex/Regex4.java) - Извлечение групп

Примеры форматирования:

- [`PrintfExample.java`](./regex/PrintfExample.java)

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 10: Перечисления в Java

Этот урок охватывает:

- Основы и синтаксис перечислений
- Методы и поля в перечислениях
- Конструкторы и инициализация
- Оператор switch с перечислениями

### Обзор перечислений

На основе [`Enum1.java`](./enums/Enum1.java), вот ключевые концепции:

#### Базовое объявление перечисления

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

#### Перечисление с полями и методами

```java
enum WeekDays {
    MONDAY("грустное"),
    TUESDAY("грустное"),
    WEDNESDAY("так себе"),
    THURSDAY("так себе"),
    FRIDAY,
    SATURDAY("отличное"),
    SUNDAY("хорошее");

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

### Работа с перечислениями

#### 1. Создание и использование значений перечисления

```java
// Прямой доступ к значению перечисления
WeekDays day = WeekDays.MONDAY;

// Создание из строки
WeekDays w4 = WeekDays.valueOf("MONDAY");

// Получение всех значений перечисления
WeekDays[] arrDays = WeekDays.values();
```

#### 2. Сравнение перечислений

```java
WeekDays w1 = WeekDays.FRIDAY;
WeekDays w2 = WeekDays.FRIDAY;
WeekDays w3 = WeekDays.MONDAY;

// Использование оператора ==
System.out.println(w1 == w3);  // false
System.out.println(w1 == w2);  // true

// Примечание: Нельзя сравнивать перечисления разных типов с помощью ==
// System.out.println(WeekDays.FRIDAY == WeekDays2.FRIDAY); // Ошибка компиляции
```

#### 3. Использование перечислений в классах

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
                System.out.println("Рабочий день");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Выходной");
                break;
        }
        System.out.println("Настроение в этот день: " + weekDay.getMood());
    }
}
```

### Ключевые особенности перечислений

1. **Постоянные значения:**
   - Фиксированный набор констант
   - Типобезопасное перечисление
   - Нельзя создавать новые экземпляры во время выполнения

2. **Встроенные методы:**
   - `values()` - возвращает массив всех констант перечисления
   - `valueOf(String)` - преобразует строку в константу перечисления
   - `name()` - возвращает имя константы перечисления
   - `ordinal()` - возвращает позицию в объявлении перечисления

3. **Дополнительные возможности:**
   - Могут иметь поля и методы
   - Могут иметь конструкторы (только private)
   - Могут реализовывать интерфейсы
   - Могут переопределять методы

### Лучшие практики

1. **Соглашения об именовании:**
   - Используйте ПРОПИСНЫЕ буквы для констант перечисления
   - Используйте единственное число для имени типа перечисления
   - Используйте описательные имена для констант

2. **Рекомендации по проектированию:**
   - Сохраняйте перечисления простыми и целенаправленными
   - Используйте поля для хранения связанных данных
   - Делайте поля final, когда возможно
   - Рассмотрите реализацию методов для поведения

3. **Рекомендации по использованию:**
   - Используйте перечисления вместо целочисленных констант
   - Используйте оператор switch для логики на основе перечислений
   - Рассмотрите использование EnumSet/EnumMap для коллекций
   - Документируйте назначение перечисления и констант

4. **Соображения производительности:**
   - Перечисления инстанцируются только один раз
   - Эффективны по памяти для фиксированного набора констант
   - Быстрое сравнение на равенство с помощью ==
   - Эффективны в операторах switch

### Распространенные случаи использования

1. **День недели:**

   ```java
   WeekDays today = WeekDays.MONDAY;
   ```

2. **Статус/Состояние:**

   ```java
   enum Status {
       ACTIVE, INACTIVE, PENDING
   }
   ```

3. **Параметры конфигурации:**

   ```java
   enum ConfigOption {
       DEBUG, RELEASE, TEST
   }
   ```

4. **Шаблон команды:**

   ```java
   enum Command {
       SAVE, LOAD, EXIT
   }
   ```

Код урока доступен в следующих файлах:

Базовые примеры перечислений:

- [`Enum1.java`](./enums/Enum1.java) - Полная реализация перечисления с полями и методами

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 11: Класс Scanner в Java

Этот урок охватывает:

- Основы класса Scanner
- Различные источники ввода
- Чтение различных типов данных
- Использование разделителей
- Операции сканирования файлов

### Обзор Scanner

| Функция | Описание | Пример использования |
|---------|----------|---------------------|
| Источники ввода | Консоль, Файл, Строка | Пользовательский ввод, Разбор файлов, Разбиение строк |
| Типы данных | примитивы, String | Чтение чисел, текста |
| Разделители | Пользовательские шаблоны | Разделение слов, разбор CSV |
| Управление буфером | Автозакрываемый | Очистка ресурсов |

### Базовое использование Scanner

#### 1. Ввод с консоли

```java
Scanner sc = new Scanner(System.in);

// Чтение разных типов данных
System.out.println("Введите 2 целых числа");
int x = sc.nextInt();     // Чтение целого числа
int y = sc.nextInt();     // Чтение другого целого числа

System.out.println("Введите 2 строки");
String s1 = sc.next();    // Чтение слова
String s2 = sc.next();    // Чтение следующего слова

System.out.println("Введите число с плавающей точкой");
double z = sc.nextDouble(); // Чтение числа с плавающей точкой
```

#### 2. Строковый источник

```java
Scanner sc = new Scanner("Привет мой друг!\n" +
                        "Как твои дела?\n" +
                        "Что нового?");

// Чтение построчно
while (sc.hasNextLine()) {
    System.out.println(sc.nextLine());
}
```

### Файловые операции со Scanner

```java
try (Scanner sc = new Scanner(
        new FileReader("scanner/FileForExample.txt"))) {
    
    // Установка пользовательского разделителя для разбиения слов
    sc.useDelimiter("\\W");
    
    // Хранение уникальных слов в отсортированном множестве
    Set<String> uniqueWords = new TreeSet<>();
    
    while (sc.hasNext()) {
        String word = sc.next();
        if (!word.isEmpty()) {
            uniqueWords.add(word);
        }
    }
    
    // Отображение уникальных слов
    for (String word : uniqueWords) {
        System.out.println(word);
    }
}
```

### Обзор методов Scanner

| Метод | Описание | Возвращаемый тип |
|-------|----------|------------------|
| next() | Чтение следующего токена | String |
| nextLine() | Чтение всей строки | String |
| nextInt() | Чтение целого числа | int |
| nextDouble() | Чтение десятичного числа | double |
| hasNext() | Проверка наличия токена | boolean |
| hasNextLine() | Проверка наличия строки | boolean |
| useDelimiter() | Установка разделителя | Scanner |

### Лучшие практики

1. **Управление ресурсами:**
   - Используйте try-with-resources
   - Всегда закрывайте Scanner после использования
   - Не закрывайте System.in

2. **Проверка ввода:**
   - Проверяйте hasNext() перед чтением
   - Обрабатывайте InputMismatchException
   - Проверяйте диапазоны чисел

3. **Использование разделителей:**
   - Выбирайте подходящие разделители
   - Учитывайте обработку пробелов
   - Помните об экранировании regex символов

4. **Производительность:**
   - Используйте BufferedReader для больших файлов
   - Сбрасывайте Scanner при необходимости
   - Очищайте буфер после чтения

### Распространенные случаи использования

#### 1. Консольное меню

```java
Scanner scanner = new Scanner(System.in);
System.out.println("Выберите опцию (1-3):");
System.out.println("1. Старт");
System.out.println("2. Настройки");
System.out.println("3. Выход");

int choice = scanner.nextInt();
switch (choice) {
    case 1: /* Логика старта */ break;
    case 2: /* Логика настроек */ break;
    case 3: /* Логика выхода */ break;
    default: System.out.println("Неверная опция");
}
```

#### 2. Обработка CSV файлов

```java
Scanner scanner = new Scanner(new File("data.csv"));
scanner.useDelimiter(",");
while (scanner.hasNext()) {
    String field = scanner.next();
    // Обработка поля CSV
}
```

#### 3. Подсчет частоты слов

```java
Scanner scanner = new Scanner(new File("text.txt"));
Map<String, Integer> wordCount = new HashMap<>();
scanner.useDelimiter("\\W+");

while (scanner.hasNext()) {
    String word = scanner.next().toLowerCase();
    wordCount.merge(word, 1, Integer::sum);
}
```

### Обработка ошибок

```java
Scanner scanner = new Scanner(System.in);
int number;

try {
    System.out.print("Введите число: ");
    number = scanner.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Неверный ввод. Пожалуйста, введите число.");
    scanner.next(); // Очистка неверного ввода
}
```

Код урока доступен в следующих файлах:

Консольный и строковый ввод:

- [`Scanner1.java`](./scanner/Scanner1.java) - Базовое использование Scanner с консолью и строками

Обработка файлов:

- [`Scanner2.java`](./scanner/Scanner2.java) - Чтение файлов и обработка слов
- [`FileForExample.txt`](./scanner/FileForExample.txt) - Пример текстового файла для обработки

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 12: Java Reflection API

Этот урок охватывает:

- Основы объекта Class и рефлексии
- Доступ к полям и методам
- Манипуляции с конструкторами
- Динамический вызов методов
- Рефлексия с аннотациями
- Соображения производительности

### Обзор рефлексии

| Функция | Описание | Пример использования |
|---------|----------|---------------------|
| Объекты Class | Метаданные класса | Разработка фреймворков |
| Доступ к членам | Доступ к полям, методам | Инструменты тестирования |
| Динамический вызов | Вызов методов во время выполнения | Системы плагинов |
| Доступ к конструкторам | Создание объектов | Внедрение зависимостей |

### Получение объектов Class

```java
// Три способа получения объекта Class
Class<?> class1 = Class.forName("reflection_example.Employee");
Class<?> class2 = Employee.class;
Class<?> class3 = employee.getClass();

// Получение информации о классе
System.out.println("Имя класса: " + class1.getName());
System.out.println("Простое имя: " + class1.getSimpleName());
System.out.println("Пакет: " + class1.getPackage());
```

### Работа с полями

```java
// Получение полей
Field[] fields = employeeClass.getDeclaredFields();
for (Field field : fields) {
    System.out.println("Поле: " + field.getName());
    System.out.println("Тип: " + field.getType());
    System.out.println("Модификаторы: " + Modifier.toString(field.getModifiers()));
}

// Доступ к приватному полю
Field salaryField = employeeClass.getDeclaredField("salary");
salaryField.setAccessible(true);
salaryField.setDouble(employee, 5000.0);
```

### Манипуляции с методами

```java
// Получение методов
Method[] methods = employeeClass.getDeclaredMethods();
for (Method method : methods) {
    System.out.println("Метод: " + method.getName());
    System.out.println("Возвращаемый тип: " + method.getReturnType());
    System.out.println("Типы параметров: " + Arrays.toString(method.getParameterTypes()));
}

// Вызов приватного метода
Method changeDepartment = employeeClass.getDeclaredMethod("changeDepartment", String.class);
changeDepartment.setAccessible(true);
changeDepartment.invoke(employee, "IT");
```

### Доступ к конструкторам

```java
// Получение конструкторов
Constructor<?>[] constructors = employeeClass.getDeclaredConstructors();
for (Constructor<?> constructor : constructors) {
    System.out.println("Конструктор: " + constructor);
    System.out.println("Параметры: " + Arrays.toString(constructor.getParameterTypes()));
}

// Создание объекта с помощью конструктора
Constructor<Employee> constructor = Employee.class.getConstructor(
    int.class, String.class, String.class);
Employee employee = constructor.newInstance(1, "Иван", "IT");
```

### Пример динамического вызова методов

```java
public class Calculator {
    void sum(int a, int b) {
        System.out.println("Сумма: " + (a + b));
    }
    
    void mul(int a, int b) {
        System.out.println("Умножение: " + (a * b));
    }
}

// Динамический вызов
Calculator calculator = new Calculator();
Class<?> calculatorClass = calculator.getClass();
Method method = calculatorClass.getMethod("sum", int.class, int.class);
method.invoke(calculator, 5, 10);
```

### Чтение параметров методов из файла

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

### Лучшие практики

1. **Соображения производительности:**
   - Кэшируйте объекты Class и Method
   - Используйте рефлексию экономно
   - Учитывайте последствия для безопасности

2. **Безопасность:**
   - Осторожно используйте setAccessible(true)
   - Учитывайте ограничения менеджера безопасности
   - Проверяйте входные параметры

3. **Обработка ошибок:**
   - Обрабатывайте специфичные для рефлексии исключения
   - Проверяйте существование методов/полей
   - Проверяйте типы параметров

4. **Проектирование:**
   - Предпочитайте решения времени компиляции, когда возможно
   - Документируйте использование рефлексии
   - Рассматривайте альтернативы (интерфейсы, фабрики)

### Распространенные случаи использования

#### 1. Разработка фреймворков

```java
// Внедрение зависимостей в стиле Spring
@Autowired
private UserService userService;

// Поиск аннотированных полей
for (Field field : class1.getDeclaredFields()) {
    if (field.isAnnotationPresent(Autowired.class)) {
        // Выполнение внедрения
    }
}
```

#### 2. Инструменты тестирования

```java
// Запуск тестов в стиле JUnit
for (Method method : testClass.getDeclaredMethods()) {
    if (method.isAnnotationPresent(Test.class)) {
        method.invoke(testInstance);
    }
}
```

#### 3. Системы плагинов

```java
// Загрузка класса плагина
Class<?> pluginClass = Class.forName(pluginClassName);
Plugin plugin = (Plugin) pluginClass.getDeclaredConstructor().newInstance();
plugin.execute();
```

Код урока доступен в следующих файлах:

Базовые примеры рефлексии:
- [`Example1.java`](./reflection_example/Example1.java) - Базовые операции рефлексии
- [`Example2.java`](./reflection_example/Example2.java) - Рефлексия методов
- [`Example3.java`](./reflection_example/Example3.java) - Рефлексия конструкторов

Пример калькулятора:
- [`Calculator.java`](./reflection_example/Calculator.java) - Динамический вызов методов
- [`FileForCalculator.txt`](./reflection_example/FileForCalculator.txt) - Входные параметры

Пример сотрудника:
- [`Employee.java`](./reflection_example/Employee.java) - Целевой класс для рефлексии

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>

---

## Урок 13: Аннотации в Java

Этот урок охватывает:

- Основы и синтаксис аннотаций
- Встроенные аннотации
- Пользовательские аннотации
- Политики сохранения аннотаций
- Обработка аннотаций
- Случаи использования аннотаций

### Обзор аннотаций

| Функция | Описание | Пример использования |
|---------|----------|---------------------|
| Встроенные аннотации | Предоставляемые Java | `@Override`, `@Deprecated` |
| Пользовательские аннотации | Определяемые пользователем | `@MyAnnotation`, `@SmartPhone` |
| Мета-аннотации | Аннотации для аннотаций | `@Target`, `@Retention` |
| Политики сохранения | Время жизни аннотации | SOURCE, CLASS, RUNTIME |

### Примеры базовых аннотаций

#### 1. Встроенные аннотации

```java
class Parent {
    @Deprecated
    void showInfo() {
        System.out.println("Это класс Parent. Имя = " + name);
    }
}

class Child extends Parent {
    @Override
    void showInfo() {
        System.out.println("Это класс Child. Имя = " + name);
    }
}
```

#### 2. Определение пользовательской аннотации

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // Без параметров
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String os() default "Android";
    int yearOfCompanyCreation() default 2010;
}
```

### Использование аннотаций

#### 1. Базовое использование

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

#### 2. Аннотации с параметрами

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

### Обработка аннотаций

#### 1. Чтение аннотаций во время выполнения

```java
// Получение объекта Class
Class xiaomiClass = Class.forName("annotation_examples.Xiaomi");

// Получение аннотации
Annotation annotation = xiaomiClass.getAnnotation(SmartPhone.class);
SmartPhone smartphone = (SmartPhone) annotation;

// Чтение параметров аннотации
System.out.println("ОС: " + smartphone.os());
System.out.println("Год: " + smartphone.yearOfCompanyCreation());
```

#### 2. Обработка нескольких классов

```java
public static void processPhoneInfo(Class<?> phoneClass) {
    if (phoneClass.isAnnotationPresent(SmartPhone.class)) {
        SmartPhone annotation = phoneClass.getAnnotation(SmartPhone.class);
        System.out.println("Информация о телефоне:");
        System.out.println("ОС: " + annotation.os());
        System.out.println("Год: " + annotation.yearOfCompanyCreation());
    }
}
```

### Мета-аннотации

| Аннотация | Назначение | Пример |
|-----------|------------|--------|
| @Target | Где можно использовать аннотацию | `@Target(ElementType.METHOD)` |
| @Retention | Как долго сохраняется аннотация | `@Retention(RetentionPolicy.RUNTIME)` |
| @Documented | Включение в JavaDoc | `@Documented` |
| @Inherited | Наследование от суперкласса | `@Inherited` |

### Политики сохранения

```java
// Только исходный код - отбрасывается компилятором
@Retention(RetentionPolicy.SOURCE)

// Записывается в файл класса, но не загружается JVM
@Retention(RetentionPolicy.CLASS)

// Записывается и доступна во время выполнения
@Retention(RetentionPolicy.RUNTIME)
```

### Типы целей

```java
@Target может указывать несколько мест:
- ElementType.TYPE (классы)
- ElementType.FIELD
- ElementType.METHOD
- ElementType.PARAMETER
- ElementType.CONSTRUCTOR
- ElementType.LOCAL_VARIABLE
- ElementType.ANNOTATION_TYPE
- ElementType.PACKAGE
```

### Лучшие практики

1. **Проектирование аннотаций:**
   - Делайте аннотации целенаправленными и простыми
   - Используйте значимые значения по умолчанию
   - Документируйте назначение и использование
   - Тщательно выбирайте политику сохранения

2. **Рекомендации по использованию:**
   - Не злоупотребляйте аннотациями
   - Проверяйте параметры аннотаций
   - Корректно обрабатывайте отсутствующие аннотации
   - Учитывайте влияние на производительность

3. **Обработка:**
   - Кэшируйте поиск аннотаций
   - Обрабатывайте исключения при рефлексии
   - Используйте типобезопасный доступ к аннотациям
   - Рассмотрите обработку во время компиляции

4. **Документация:**
   - Документируйте требования аннотаций
   - Предоставляйте примеры использования
   - Объясняйте сохранение и наследование
   - Документируйте поведение при обработке

### Распространенные случаи использования

1. **Конфигурация:**

   ```java
   @Configuration(path = "config.properties")
   public class AppConfig {
       // Реализация конфигурации
   }
   ```

2. **Валидация:**

   ```java
   public class User {
       @NotNull
       @Size(min = 2, max = 30)
       private String username;
   }
   ```

3. **Внедрение зависимостей:**

   ```java
   public class UserService {
       @Autowired
       private UserRepository repository;
   }
   ```

4. **Тестирование:**

   ```java
   @Test
   @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
   public void testOperation() {
       // Реализация теста
   }
   ```

Код урока доступен в следующих файлах:

Базовые примеры аннотаций:

- [`Employee.java`](./annotation_examples/Employee.java) - Использование пользовательских аннотаций
- [`Test1.java`](./annotation_examples/Test1.java) - Встроенные аннотации
- [`Test2.java`](./annotation_examples/Test2.java) - Обработка аннотаций

<div align="right">
    <b><a href="#содержание">↥ К содержанию</a></b>
</div>
