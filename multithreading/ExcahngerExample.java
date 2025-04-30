package multithreading;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExcahngerExample {
  /**
   * The main method of the ExcahngerExample class.
   * It demonstrates the usage of an exchanger in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create an exchanger
    Exchanger<Action> exchanger = new Exchanger<>();

    // Create two lists of actions
    List<Action> actions1 = List.of(Action.ROCK, Action.PAPER, Action.SCISSORS);
    List<Action> actions2 = List.of(Action.PAPER, Action.ROCK, Action.SCISSORS);

    // Create two best friends that use the exchanger
    BestFriend bestFriend1 = new BestFriend("Best Friend 1", actions1, exchanger);
    BestFriend bestFriend2 = new BestFriend("Best Friend 2", actions2, exchanger);

    // Start the best friends
    bestFriend1.start();
    bestFriend2.start();

    // Wait for the best friends to finish
    try {
      bestFriend1.join();
      bestFriend2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print a message indicating the end of the game
    System.out.println("Game over!");
  }
}

enum Action {
  ROCK,
  PAPER,
  SCISSORS;
}

class BestFriend extends Thread {
  /**
   * The name of the best friend.
   */
  private String name;

  /**
   * The list of actions of the best friend.
   */
  private List<Action> actions;

  /**
   * The exchanger used by the best friend.
   */
  private Exchanger<Action> exchanger;

  /**
   * Constructor for the BestFriend class.
   *
   * @param name The name of the best friend
   * @param actions The list of actions of the best friend
   * @param exchanger The exchanger used by the best friend
   */
  public BestFriend(String name, List<Action> actions, Exchanger<Action> exchanger) {
    this.name = name;
    this.actions = actions;
    this.exchanger = exchanger;
  }

  /**
   * Determines the winner of a game based on the actions of the best friend and the opponent.
   *
   * @param action The action of the best friend
   * @param opponentAction The action of the opponent
   */
  private void whoWins(Action action, Action opponentAction) {
    if (action == opponentAction) {
      System.out.println(name + " and opponent chose the same action: " + action);
    } else if ((action == Action.ROCK && opponentAction == Action.SCISSORS)
        || (action == Action.PAPER && opponentAction == Action.ROCK)
        || (action == Action.SCISSORS && opponentAction == Action.PAPER)) {
      System.out.println(name + " wins with " + action + " against " + opponentAction);
    } else {
      System.out.println(name + " loses with " + action + " against " + opponentAction);
    }
  }

  /**
   * Exchanges actions with the opponent and determines the winner of each game.
   */
  @Override
  public void run() {
    Action reply;
    for (Action action : actions) {
      try {
        reply = exchanger.exchange(action);
        whoWins(action, reply);
        sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
