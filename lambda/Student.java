package lambda;

public class Student {
  /**
   * Name of the student.
   */
  private String name;

  /**
   * Sex of the student.
   */
  private char sex;

  /**
   * Age of the student.
   */
  private int age;

  /**
   * Course of the student.
   */
  private int course;

  /**
   * Grade of the student.
   */
  private double grade;

  /**
   * Constructor for the Student class.
   * @param name Name of the student.
   * @param sex Sex of the student.
   * @param age Age of the student.
   * @param course Course of the student.
   * @param grade Grade of the student.
   */
  public Student(String name, char sex, int age, int course, double grade) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.course = course;
    this.grade = grade;
  }

  /**
   * Returns the name of the student.
   * @return Name of the student.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the student.
   * @param name Name of the student.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the sex of the student.
   * @return Sex of the student.
   */
  public char getSex() {
    return sex;
  }

  /**
   * Sets the sex of the student.
   * @param sex Sex of the student.
   */
  public void setSex(char sex) {
    this.sex = sex;
  }

  /**
   * Returns the age of the student.
   * @return Age of the student.
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age of the student.
   * @param age Age of the student.
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Returns the course of the student.
   * @return Course of the student.
   */
  public int getCourse() {
    return course;
  }

  /**
   * Sets the course of the student.
   * @param course Course of the student.
   */
  public void setCourse(int course) {
    this.course = course;
  }

  /**
   * Returns the grade of the student.
   * @return Grade of the student.
   */
  public double getGrade() {
    return grade;
  }

  /**
   * Sets the grade of the student.
   * @param grade Grade of the student.
   */
  public void setGrade(double grade) {
    this.grade = grade;
  }

  /**
   * Returns a string representation of the student.
   * @return String representation of the student.
   */
  @Override
  public String toString() {
    return "Student [name=" + name + ", sex=" + sex + ", age=" + age + ", course=" + course
        + ", grade=" + grade + "]";
  }
}
