package enums;

import java.util.Arrays;

public class Enum1 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create a new Today object with WeekDays.MONDAY.
     */
    Today today = new Today(WeekDays.MONDAY);
    /**
     * Print the information of the today.
     */
    today.daysInfo();
    System.out.println(today.weekDay);
    /**
     * Create three WeekDays objects.
     */
    WeekDays w1 = WeekDays.FRIDAY;
    WeekDays w2 = WeekDays.FRIDAY;
    WeekDays w3 = WeekDays.MONDAY;
    /**
     * Compare the WeekDays objects.
     */
    System.out.println(w1 == w3);
    System.out.println(w1 == w2);
    // not allowed
    // System.out.println(WeekDays.FRIDAY == WeekDays2.FRIDAY);
    System.out.println(WeekDays.FRIDAY.equals(WeekDays2.FRIDAY));
    /**
     * Get the WeekDays object with the name "MONDAY".
     */
    WeekDays w4 = WeekDays.valueOf("MONDAY");
    System.out.println(w4);
    /**
     * Get an array of all WeekDays objects.
     */
    WeekDays[] arrDays = WeekDays.values();
    System.out.println(Arrays.toString(arrDays));
  }
}

enum WeekDays {
  MONDAY("sad"),
  TUESDAY("sad"),
  WEDNESDAY("so-so"),
  THURSDAY("so-so"),
  FRIDAY,
  SATURDAY("great"),
  SUNDAY("good");

  private String mood;

  private WeekDays(String mood) {
    this.mood = mood;
  }

  private WeekDays() {}

  public String getMood() {
    return mood;
  }
}

enum WeekDays2 {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY;
}

class Today {
  /**
   * WeekDay of the today.
   */
  WeekDays weekDay;

  /**
   * Constructor for the Today class.
   * @param weekDay WeekDay of the today.
   */
  public Today(WeekDays weekDay) {
    this.weekDay = weekDay;
  }

  /**
   * Prints the information of the today.
   */
  void daysInfo() {
    switch (weekDay) {
      case MONDAY:
      case TUESDAY:
      case WEDNESDAY:
      case THURSDAY:
      case FRIDAY:
        System.out.println("Work day");
        break;
      case SATURDAY:
      case SUNDAY:
        System.out.println("Weekend");
        break;
    }
    System.out.println("Mood on this day: " + weekDay.getMood());
  }
}
