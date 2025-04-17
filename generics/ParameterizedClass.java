package generics;

/**
* Class ParameterizedClass demonstrates the usage of a parameterized class.
*/
public class ParameterizedClass {
   public static void main(String[] args) {
       /**
        * Creates an instance of Info with a String parameter.
        */
       Info<String> info1 = new Info<>("Hello");
       System.out.println(info1);
       
       /**
        * Retrieves the value of the Info object.
        */
       String s = info1.getValue();
       System.out.println(s);

       /**
        * Creates an instance of Info with an Integer parameter.
        */
       Info<Integer> info2 = new Info<>(123);
       System.out.println(info2);
       
       /**
        * Retrieves the value of the Info object.
        */
       Integer i = info2.getValue();
       System.out.println(i);
   }
}


/**
* Class Info is a parameterized class that stores a value of type T.
* @param <T> the type of the value stored in the Info object.
*/
class Info<T> {
   // static T value; // Error: Cannot use static type parameter
   private T value;

   /**
    * Constructor for Info.
    * @param value the value to be stored in the Info object.
    */
   public Info(T value) {
       this.value = value;
   }

   @Override
   /**
    * Returns a string representation of the Info object.
    * @return a string representation of the Info object.
    */
   public String toString() {
       return "Info [value=" + value + "]";
   }

   /**
    * Retrieves the value stored in the Info object.
    * @return the value stored in the Info object.
    */
   public T getValue() {
       return value;
   }
   
}
