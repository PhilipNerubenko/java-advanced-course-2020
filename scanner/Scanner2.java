package scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Scanner2 {
  /**
   * Main method to execute file scanning and word processing.
   *
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner sc = null;
    Set<String> set = new TreeSet<>(); // Stores unique words with natural ordering

    try {
      // Create Scanner to read from specified file
      sc = new Scanner(new FileReader("scanner/FileForExample.txt"));

      // Set delimiter to split text by non-word characters
      // This effectively tokenizes the text into words
      sc.useDelimiter("\\W");

      // Process all words in the file
      while (sc.hasNext()) {
        String word = sc.next();
        if (!word.isEmpty()) { // Skip empty strings from leading/trailing delimiters
          set.add(word); // TreeSet automatically handles uniqueness and sorting
        }
      }

      // Display results - unique words in alphabetical order
      System.out.println("Unique words in alphabetical order:");
      for (String word : set) {
        System.out.println(word);
      }

    } catch (FileNotFoundException e) {
      System.err.println("Error: File not found!");
      e.printStackTrace();
    } finally {
      // Ensure scanner is closed to release system resources
      if (sc != null) {
        sc.close();
      }
    }
  }
}