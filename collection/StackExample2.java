package collection;

import java.util.Stack;

/**
 * Class StackExample2 demonstrates the usage of Stack in Java.
 */
public class StackExample2 {
  public static void main(String[] args) {
    /* Stack is a last-in-first-out (LIFO) data structure
     * It allows duplicate elements and is not synchronized
     * Stack is part of the Java Collections Framework
     * Stack is a subclass of Vector
     * Stack is not recommended for new code, use Deque instead
     * Stack is synchronized, but it is not thread-safe
     */
    Stack<String> stack = new Stack<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");

    System.out.println("Stack: " + stack);
    System.out.println("Peek: " + stack.peek()); // View the top element without removing it
    System.out.println("Pop: " + stack.pop()); // Remove and return the top element
    System.out.println("Stack after pop: " + stack);
    System.out.println("Search for 'B': " + stack.search("B")); // Search for an element
    System.out.println(
        "Search for 'E': " + stack.search("E")); // Search for an element not in the stack
    System.out.println("Is stack empty? " + stack.isEmpty()); // Check if the stack is empty
    System.out.println("Size of stack: " + stack.size()); // Get the size of the stack
    // Clear the stack
    stack.clear();
    System.out.println("Stack after clear: " + stack);
  }
}
