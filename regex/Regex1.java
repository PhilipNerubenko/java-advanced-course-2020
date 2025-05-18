package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
  /**
   * Main method to execute regex operations.
   *
   * @param args Command line arguments (not used)
   * @throws Exception If regex compilation or matching fails
   */
  public static void main(String[] args) throws Exception {
    /**
     * Sample text containing contact information for three users:
     * - Full name
     * - Country and city
     * - Street address and apartment number
     * - Email address
     * - Postal code
     * - Phone number
     */
    String s = "Tvanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, email: vivanov@mail.ru, "
        + "Postcode: AA99, Phone Number: +123456789;\n" + //
        "Petrova Mariya, Ukraine, Klyev, Lomonosov street, 33, Flat 18, email: masha@yandex.ru, "
        + "Postcode: UKR54, Phone Number: +987654321;\n" + //
        "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21, email: chuck@gmail.com, "
        + "Postcode: USA23, Phone Number: +136478952.";

    /**
     * Regex pattern to extract words (\w+)
     * Matches sequences of letters, digits, and underscores
     */
    Pattern pattern = Pattern.compile("\\w+");

    /**
     * Regex pattern to find two-digit numbers (\b\d{2}\b)
     * \b ensures we match whole numbers only
     */
    Pattern pattern2 = Pattern.compile("\\b\\d{2}\\b");

    /**
     * Regex pattern to identify phone numbers (\+\d{9})
     * Starts with '+' followed by exactly 9 digits
     */
    Pattern pattern3 = Pattern.compile("\\+\\d{9}");

    /**
     * Regex pattern to filter .ru/.com email addresses
     * Format: username@domain.(ru|com)
     */
    Pattern pattern4 = Pattern.compile("\\w+@\\w+\\.(ru|com)");

    /**
     * 1. Extract and print all words from the text
     */
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }

    /**
     * 2. Extract and print two-digit numbers
     */
    System.out.println();
    matcher = pattern2.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }

    /**
     * 3. Extract and print phone numbers
     */
    System.out.println();
    matcher = pattern3.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }

    /**
     * 4. Extract and print .ru/.com email addresses
     */
    System.out.println();
    matcher = pattern4.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}