package annotation_examples;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test2 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   * @throws ClassNotFoundException If the class is not found.
   */
  public static void main(String[] args) throws ClassNotFoundException {
    /**
     * Get the Class object for the Xiaomi class.
     */
    Class xiaClass = Class.forName("annotation_examples.Xiaomi");
    /**
     * Get the SmartPhone annotation from the Xiaomi class.
     */
    Annotation annotation1 = xiaClass.getAnnotation(SmartPhone.class);
    /**
     * Cast the annotation to SmartPhone.
     */
    SmartPhone sml = (SmartPhone) annotation1;
    /**
     * Print the information from the SmartPhone annotation.
     */
    System.out.println(
        "Annotation info from Xiaomi class: " + sml.os() + ", " + sml.yearOfCompanyCreation());

    /**
     * Get the Class object for the Iphone class.
     */
    Class iphoneClass = Class.forName("annotation_examples.Iphone");
    /**
     * Get the SmartPhone annotation from the Iphone class.
     */
    Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
    /**
     * Cast the annotation to SmartPhone.
     */
    SmartPhone sm2 = (SmartPhone) annotation2;
    /**
     * Print the information from the SmartPhone annotation.
     */
    System.out.println(
        "Annotation info from Iphone class: " + sm2.os() + ", " + sm2.yearOfCompanyCreation());
  }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
  String os() default "Android";
  int yearOfCompanyCreation() default 2010;
  // Reference type not allowed, example StringBuilder sb
}

@SmartPhone(yearOfCompanyCreation = 2017)
class Xiaomi {
  /**
   * Model of the Xiaomi.
   */
  String model;

  /**
   * Price of the Xiaomi.
   */
  double price;
}

@SmartPhone(os = "IOS")
class Iphone {
  /**
   * Model of the Iphone.
   */
  String model;

  /**
   * Price of the Iphone.
   */
  double price;
}
