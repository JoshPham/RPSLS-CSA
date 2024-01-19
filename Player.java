package RPSLS;
import java.util.Scanner;

public class Player {
    static Scanner sc = new Scanner(System.in);

    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return playerName;
    }

    public String getGesture() {
        System.out.print(playerName + ", enter your gesture (rock, paper, scissors, lizard, or spock): ");
        String gesture = sc.nextLine().toLowerCase();
        return gesture;
    }

    public void displayGesture(String gesture) {
        System.out.println(playerName + " chose " + gesture);
    }    
}
