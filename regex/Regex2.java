package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
  public static void main(String[] args) {
    String s1 = "ABCD ABCE ABCFABCGABCH";
    Pattern pattern1 = Pattern.compile("ABC");

    String s2 = "OPABMNCD";
    Pattern pattern2 = Pattern.compile("[ABC]");

    String s3 = "ABDOP";
    Pattern pattern3 = Pattern.compile("AB[C-F]OP");

    String s4 = "abcd abce abc5abcg6abch";
    Pattern pattern4 = Pattern.compile("abc[e-g4-7]");

    String s5 = "abcd abce abc5abcg6abch";
    Pattern pattern5 = Pattern.compile("abc[^e-g4-7]");

    String s6 = "abcd abce abc5abcg6abch";
    Pattern pattern6 = Pattern.compile("abc(e|5)");

    String s7 = "abcd abce abc5abcg6abch";
    Pattern pattern7 = Pattern.compile("abc.");

    String s8 = "abcd abce abc5abcg6abch";
    Pattern pattern8 = Pattern.compile("^abc.");

    String s9 = "abcd abce abc5abcg6abch";
    Pattern pattern9 = Pattern.compile("ch$");

    String s10 = "abcd abce abc5abcg6abch";
    Pattern pattern10 = Pattern.compile("\\d");

    String s11 = "abcd abce abc5abcg6abch";
    Pattern pattern11 = Pattern.compile("\\D");

    String s12 = "abcd abce abc5abcg6abch";
    Pattern pattern12 = Pattern.compile("\\w"); // [A-Za-z0-9_]

    String s13 = "abcd abce abc5abcg6abch";
    Pattern pattern13 = Pattern.compile("\\w+");

    String s14 = "abcd!?abce=== ++abc5abcg6abch";
    Pattern pattern14 = Pattern.compile("\\W+");

    String s15 = "abcd abce abc5abcg6abch";
    Pattern pattern15 = Pattern.compile("\\w{4}");

    String s16 = "abcd     abce          abc5abcg6abch";
    Pattern pattern16 = Pattern.compile("\\w\\s+\\w"); // [\t\n\r\f]

    String s17 = "abcd abce3 abcfa78bcg6a!!!!!!!!!!";
    Pattern pattern17 = Pattern.compile("\\D{2,6}\\S");

    String s18 = "abcababda";
    Pattern pattern18 = Pattern.compile("(ab){2,3}");

    String s19 = "DABCDABABADBABABA";
    Pattern pattern19 = Pattern.compile("D(AB){2,}");

    String s20 = "DABCDABABADBABABA";
    Pattern pattern20 = Pattern.compile("D(AB)?");

    String s21 = "DABCDABABADBABABA";
    Pattern pattern21 = Pattern.compile("D(AB)*");

    String s22 = "dabcDABABADBABABA";
    Pattern pattern22 = Pattern.compile("\\Adabc");

    String s23 = "DABCDABABADBABABA";
    Pattern pattern23 = Pattern.compile("BABA\\z");

    String s24 = "ABCDEBABADBABABA";
    Pattern pattern24 = Pattern.compile("[ABCD][EFGH3-8]");

    Matcher mather = pattern1.matcher(s1);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern2.matcher(s2);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern3.matcher(s3);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern4.matcher(s4);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern5.matcher(s5);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern6.matcher(s6);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern7.matcher(s7);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }

    System.out.println();

    mather = pattern8.matcher(s8);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern9.matcher(s9);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern10.matcher(s10);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern11.matcher(s11);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern12.matcher(s12);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern13.matcher(s13);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern14.matcher(s14);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern15.matcher(s15);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern16.matcher(s16);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern17.matcher(s17);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern18.matcher(s18);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern19.matcher(s19);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern20.matcher(s20);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern21.matcher(s21);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern22.matcher(s22);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern23.matcher(s23);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
    System.out.println();

    mather = pattern24.matcher(s24);
    while (mather.find()) {
      System.out.println("Position: " + mather.start() + " " + mather.group());
    }
  }
}
