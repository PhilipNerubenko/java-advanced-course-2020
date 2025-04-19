package collection;

import java.util.*;

/**
 * Class ListIteratorExample demonstrates the usage of ListIterator in Java.
 */
public class ListIteratorExample {
  public static void main(String[] args) {
    String s = "madam";
    List<Character> list = new ArrayList<>();

    // Convert the string to a list of characters
    for (char c : s.toCharArray()) {
      list.add(c);
    }

    ListIterator<Character> iterator = list.listIterator();
    ListIterator<Character> reverseIterator = list.listIterator(list.size());
    boolean isPalindrome = true;

    // Check if the string is a palindrome
    while (iterator.hasNext() && reverseIterator.hasPrevious()) {
      char forward = iterator.next();
      char backward = reverseIterator.previous();
      if (forward != backward) {
        isPalindrome = false;
        break;
      }
    }
    // Print the result
    if (isPalindrome) {
      System.out.println(s + " is a palindrome.");
    } else {
      System.out.println(s + " is not a palindrome.");
    }
  }
}
