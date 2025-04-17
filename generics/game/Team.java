package generics.game;

import java.util.*;

/**
* Class Team is a parameterized class that represents a team of participants.
* @param <T> the type of the participants in the team, which must extend Participant.
*/
public class Team <T extends Participant> {
   private String name;
   private List<T> participants = new ArrayList<>();

   /**
    * Constructor for Team.
    * @param name the name of the team.
    */
   public Team(String name) {
       this.name = name;
   }

   /**
    * Adds a participant to the team.
    * @param participant the participant to be added to the team.
    */
   public void addParticipant(T participant) {
       participants.add(participant);
       System.out.println("Team " + name + " added participant: " + participant.getName());
   }

   /**
    * Simulates a game between this team and another team.
    * @param otherTeam the other team to play with.
    */
   public void playWith(Team<T> otherTeam) {
      String winnerName;
      Random random = new Random();
      int winner = random.nextInt(2);
        if (winner == 0) {
             winnerName = this.name;
        } else {
             winnerName = otherTeam.name;
        }
        System.out.println("Team " + this.name + " played with team " + otherTeam.name + ". Winner: " + winnerName);
   }
}

