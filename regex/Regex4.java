package regex;

import java.util.regex.*;

public class Regex4 {
  public static void main(String[] args) {
    String s1 = "Hello,         my friend!   How  going to learning    Java";
    System.out.println(s1);
    s1 = s1.replace("Java", "SQL");
    s1 = s1.replaceAll(" {2,}", " ");
    s1 = s1.replaceAll("\\bm\\w+", "444");
    s1 = s1.replaceAll("\\b4\\w+", "4");
    System.out.println(s1);

    String myString = "12345678912345670325987;"
        + "98765432165498750921654;"
        + "85274196345612381122333";
    Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
    Matcher mather = pattern.matcher(myString);

    // String myNewString = mather.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
    // System.out.println(myNewString);

    while (mather.find()) {
      System.out.println(mather.group(7));
    }
  }
}
