package regex;

import java.util.Arrays;

public class Regex3 {
  public static void main(String[] args) {
    String s = "Tvanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, email: vivanov@mail.ru, "
        + "Postcode: AA99, Phone Number: +123456789;\n" + //
        "Petrova Mariya, Ukraine, Klyev, Lomonosov street, 33, Flat 18, email: masha@yandex.ru, "
        + "Postcode: UKR54, Phone Number: +987654321;\n" + //
        "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21, email: chuck@gmail.com, "
        + "Postcode: USA23, Phone Number: +136478952.";
    String s2 = "chuck@gmail.com";

    boolean result = s2.matches("\\w+@\\w+\\.(com|ru)");
    System.out.println(result);

    String[] array = s.split(" ");
    System.out.println(Arrays.toString(array));
  }
}
