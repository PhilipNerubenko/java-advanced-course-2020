package regex;

import java.util.Arrays;

public class Regex3 {
  /**
   * Main method to execute regex operations.
   *
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
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
     * Test string for email validation
     */
    String s2 = "chuck@gmail.com";

    /**
     * 1. Email validation pattern
     * Checks if string matches format: username@domain.(com|ru)
     * Returns true for valid format, false otherwise
     */
    boolean result = s2.matches("\\w+@\\w+\\.(com|ru)");
    System.out.println("Email validation result: " + result);

    /**
     * 2. String splitting operation
     * Splits the contact information string by whitespace
     * Creates array of tokens separated by spaces
     */
    String[] array = s.split(" ");
    System.out.println("Split string result: " + Arrays.toString(array));
  }
}