package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
  /**
   * Main method to execute all regex pattern demonstrations.
   *
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    /**
     * 1. Pattern: "ABC"
     * Matches exact sequence "ABC" in the string
     */
    String s1 = "ABCD ABCE ABCFABCGABCH";
    Pattern pattern1 = Pattern.compile("ABC");

    /**
     * 2. Pattern: "[ABC]"
     * Matches any single character A, B, or C
     */
    String s2 = "OPABMNCD";
    Pattern pattern2 = Pattern.compile("[ABC]");

    /**
     * 3. Pattern: "AB[C-F]OP"
     * Matches AB followed by a character between C-F, then OP
     */
    String s3 = "ABDOP";
    Pattern pattern3 = Pattern.compile("AB[C-F]OP");

    /**
     * 4. Pattern: "abc[e-g4-7]"
     * Matches 'abc' followed by e-g or 4-7
     */
    String s4 = "abcd abce abc5abcg6abch";
    Pattern pattern4 = Pattern.compile("abc[e-g4-7]");

    /**
     * 5. Pattern: "abc[^e-g4-7]"
     * Matches 'abc' followed by any character NOT e-g or 4-7
     */
    String s5 = "abcd abce abc5abcg6abch";
    Pattern pattern5 = Pattern.compile("abc[^e-g4-7]");

    /**
     * 6. Pattern: "abc(e|5)"
     * Matches 'abc' followed by either 'e' or '5'
     */
    String s6 = "abcd abce abc5abcg6abch";
    Pattern pattern6 = Pattern.compile("abc(e|5)");

    /**
     * 7. Pattern: "abc."
     * Matches 'abc' followed by any single character
     */
    String s7 = "abcd abce abc5abcg6abch";
    Pattern pattern7 = Pattern.compile("abc.");

    /**
     * 8. Pattern: "^abc."
     * Matches 'abc' at the beginning of the string followed by any character
     */
    String s8 = "abcd abce abc5abcg6abch";
    Pattern pattern8 = Pattern.compile("^abc.");

    /**
     * 9. Pattern: "ch$"
     * Matches 'ch' at the end of the string
     */
    String s9 = "abcd abce abc5abcg6abch";
    Pattern pattern9 = Pattern.compile("ch$");

    /**
     * 10. Pattern: "\\d"
     * Matches any digit character
     */
    String s10 = "abcd abce abc5abcg6abch";
    Pattern pattern10 = Pattern.compile("\\d");

    /**
     * 11. Pattern: "\\D"
     * Matches any non-digit character
     */
    String s11 = "abcd abce abc5abcg6abch";
    Pattern pattern11 = Pattern.compile("\\D");

    /**
     * 12. Pattern: "\\w"
     * Matches any word character ([A-Za-z0-9_])
     */
    String s12 = "abcd abce abc5abcg6abch";
    Pattern pattern12 = Pattern.compile("\\w");

    /**
     * 13. Pattern: "\\w+"
     * Matches one or more word characters
     */
    String s13 = "abcd abce abc5abcg6abch";
    Pattern pattern13 = Pattern.compile("\\w+");

    /**
     * 14. Pattern: "\\W+"
     * Matches one or more non-word characters
     */
    String s14 = "abcd!?abce=== ++abc5abcg6abch";
    Pattern pattern14 = Pattern.compile("\\W+");

    /**
     * 15. Pattern: "\\w{4}"
     * Matches exactly 4 word characters
     */
    String s15 = "abcd abce abc5abcg6abch";
    Pattern pattern15 = Pattern.compile("\\w{4}");

    /**
     * 16. Pattern: "\\w\\s+\\w"
     * Matches two words separated by whitespace
     */
    String s16 = "abcd     abce          abc5abcg6abch";
    Pattern pattern16 = Pattern.compile("\\w\\s+\\w"); // [\t\n\r\f]

    /**
     * 17. Pattern: "\\D{2,6}\\S"
     * Matches 2-6 non-digits followed by a non-whitespace
     */
    String s17 = "abcd abce3 abcfa78bcg6a!!!!!!!!!!";
    Pattern pattern17 = Pattern.compile("\\D{2,6}\\S");

    /**
     * 18. Pattern: "(ab){2,3}"
     * Matches 2-3 occurrences of "ab"
     */
    String s18 = "abcababda";
    Pattern pattern18 = Pattern.compile("(ab){2,3}");

    /**
     * 19. Pattern: "D(AB){2,}"
     * Matches D followed by 2 or more "AB" sequences
     */
    String s19 = "DABCDABABADBABABA";
    Pattern pattern19 = Pattern.compile("D(AB){2,}");

    /**
     * 20. Pattern: "D(AB)?"
     * Matches D followed by 0 or 1 "AB" sequences
     */
    String s20 = "DABCDABABADBABABA";
    Pattern pattern20 = Pattern.compile("D(AB)?");

    /**
     * 21. Pattern: "D(AB)*"
     * Matches D followed by 0 or more "AB" sequences
     */
    String s21 = "DABCDABABADBABABA";
    Pattern pattern21 = Pattern.compile("D(AB)*");

    /**
     * 22. Pattern: "\\Adabc"
     * Matches "dabc" at the absolute start of input
     */
    String s22 = "dabcDABABADBABABA";
    Pattern pattern22 = Pattern.compile("\\Adabc");

    /**
     * 23. Pattern: "BABA\\z"
     * Matches "BABA" at the end of input
     */
    String s23 = "DABCDABABADBABABA";
    Pattern pattern23 = Pattern.compile("BABA\\z");

    /**
     * 24. Pattern: "[ABCD][EFGH3-8]"
     * Matches any A,B,C,D followed by E,F,G,H,3-8
     */
    String s24 = "ABCDEBABADBABABA";
    Pattern pattern24 = Pattern.compile("[ABCD][EFGH3-8]");

    // Execute and display results for each pattern
    printMatches(pattern1, s1);
    printMatches(pattern2, s2);
    printMatches(pattern3, s3);
    printMatches(pattern4, s4);
    printMatches(pattern5, s5);
    printMatches(pattern6, s6);
    printMatches(pattern7, s7);
    printMatches(pattern8, s8);
    printMatches(pattern9, s9);
    printMatches(pattern10, s10);
    printMatches(pattern11, s11);
    printMatches(pattern12, s12);
    printMatches(pattern13, s13);
    printMatches(pattern14, s14);
    printMatches(pattern15, s15);
    printMatches(pattern16, s16);
    printMatches(pattern17, s17);
    printMatches(pattern18, s18);
    printMatches(pattern19, s19);
    printMatches(pattern20, s20);
    printMatches(pattern21, s21);
    printMatches(pattern22, s22);
    printMatches(pattern23, s23);
    printMatches(pattern24, s24);
  }

  /**
   * Helper method to find and print matches for a pattern in a string
   *
   * @param pattern The regex pattern to use
   * @param input The string to search
   */
  private static void printMatches(Pattern pattern, String input) {
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      System.out.println("Pattern: " + pattern.pattern() + " | Position: " + matcher.start()
          + " | Match: " + matcher.group());
    }
    System.out.println("--------------------------------------------------");
  }
}