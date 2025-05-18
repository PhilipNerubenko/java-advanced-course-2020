package regex;

import java.util.regex.*;

public class Regex4 {
  /**
   * Main method to execute regex operations.
   *
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    /**
     * 1. Text sanitization and transformation
     * Original string with irregular spacing and content to be modified
     */
    String s1 = "Hello,         my friend!   How  going to learning    Java";
    System.out.println("Original text: " + s1);

    // Replace "Java" with "SQL"
    s1 = s1.replace("Java", "SQL");

    // Normalize whitespace (replace multiple spaces with single space)
    s1 = s1.replaceAll(" {2,}", " ");

    // Replace words starting with "m" with "444"
    s1 = s1.replaceAll("\\bm\\w+", "444");

    // Replace words starting with "4" with "4"
    s1 = s1.replaceAll("\\b4\\w+", "4");

    System.out.println("Modified text: " + s1);

    /**
     * 2. Data extraction pattern
     * String containing concatenated numeric sequences
     * Pattern groups digits into specific segments:
     * - 4 digits
     * - 4 digits
     * - 4 digits
     * - 4 digits
     * - 2 digits
     * - 2 digits
     * - 3 digits
     */
    String myString = "12345678912345670325987;"
        + "98765432165498750921654;"
        + "85274196345612381122333";

    Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
    Matcher matcher = pattern.matcher(myString);

    /**
     * Extract and display the 7th group (last 3 digits) from each match
     * This could represent specific metadata in a data processing pipeline
     */
    System.out.println("\nExtracted 7th group values:");
    while (matcher.find()) {
      System.out.println(matcher.group(7));
    }

    /**
     * Example of potential formatted replacement (commented out)
     * Would format numbers as: "dd/dd dddd dddd dddd dddd (ddd)"
     */
    // String myNewString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
    // System.out.println(myNewString);
  }
}