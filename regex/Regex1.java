package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
  public static void main(String[] args) {
    String s = "Tvanov Vasiliy, Russia, Moscow, Lenin street, 51, Flat 48, email: vivanov@mail.ru, "
        + "Postcode: AA99, Phone Number: +123456789;\n" + //
        "Petrova Mariya, Ukraine, Klyev, Lomonosov street, 33, Flat 18, email: masha@yandex.ru, "
        + "Postcode: UKR54, Phone Number: +987654321;\n" + //
        "Chuck Norris, USA, Hollywood, All stars street, 87, Flat 21, email: chuck@gmail.com, "
        + "Postcode: USA23, Phone Number: +136478952.";
    Pattern pattern = Pattern.compile("\\w+");
    Pattern pattern2 = Pattern.compile("\\b\\d{2}\\b");
    Pattern pattern3 = Pattern.compile("\\+\\d{9}");
    Pattern pattern4 = Pattern.compile("\\w+@\\w+\\.(ru|com)");
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()) {
      System.out.println(matcher.group());
    }

    System.out.println();
    matcher = pattern2.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }

    System.out.println();
    matcher = pattern3.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
    System.out.println();
    matcher = pattern4.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}