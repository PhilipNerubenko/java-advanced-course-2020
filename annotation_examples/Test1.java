package annotation_examples;

public class Test1 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create a new Child object with name "Philip".
     */
    Parent p = new Child("Philip");
    /**
     * Print the information of the child.
     */
    p.showInfo();
  }
}

class Parent {
  /**
   * Name of the parent.
   */
  String name;

  /**
   * Constructor for the Parent class.
   * @param name Name of the parent.
   */
  public Parent(String name) {
    this.name = name;
  }

  /**
   * Deprecated method to show the information of the parent.
   */
  @Deprecated
  void showInfo() {
    System.out.println("It's Parent class. Name = " + name);
  }
}

class Child extends Parent {
  /**
   * Constructor for the Child class.
   * @param name Name of the child.
   */
  public Child(String name) {
    super(name);
  }

  /**
   * Overrides the showInfo method of the Parent class to show the information of the child.
   */
  @Override
  void showInfo() {
    System.out.println("It's Child class. Name = " + name);
  }
}
