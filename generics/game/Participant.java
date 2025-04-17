package generics.game;

/**
* Abstract class Participant represents a participant in a team.
*/
public abstract class Participant {
   private String name;
   private int age;

   /**
    * Constructor for Participant.
    * @param name the name of the participant.
    * @param age the age of the participant.
    */
   public Participant(String name, int age) {
       this.name = name;
       this.age = age;
   }
   
   /**
    * Retrieves the name of the participant.
    * @return the name of the participant.
    */
   public String getName() {
       return name;
   }
   
   /**
    * Retrieves the age of the participant.
    * @return the age of the participant.
    */
   public int getAge() {
       return age;
   }
   
}

