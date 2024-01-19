package RPSLS;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private int player1Pts;
    private int player2Pts;
    private int numOfPts;

    public Game(Player player1, Player player2, int numOfPts) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Pts = 0;
        this.player2Pts = 0;
        this.numOfPts = numOfPts;
    }

    public void start() {
        while (player1Pts < numOfPts && player2Pts < numOfPts) {
            playRound();
            displayPoints();
        }
        Player winner = (player1Pts == numOfPts)? player1 : player2;
        System.out.println(winner.getName() + " won with " + numOfPts + " points!");
    }

    private void playRound() {
        String player1Gesture = player1.getGesture();
        String player2Gesture = player2.getGesture();
        player1.displayGesture(player1Gesture);
        player2.displayGesture(player2Gesture);
        determineRoundWinner(player1Gesture, player2Gesture);
    }

    private void determineRoundWinner(String player1Gesture, String player2Gesture) {
        int player1GestureIndex = getGestureIndex(player1Gesture);
        int player2GestureIndex = getGestureIndex(player2Gesture);

        int outcome = (5 + player1GestureIndex - player2GestureIndex) % 5;
       
        if (outcome == 0) {
            System.out.println("It's a tie! Choose again.");
        } else if (outcome == 1 || outcome == 3) {
            System.out.println(String.format("%s beats %s. %s wins!", player1Gesture, player2Gesture, player1.getName()));
            player1Pts++;
        } else if (outcome == 2 || outcome == 4) {
            System.out.println(String.format("%s beats %s. %s wins!", player2Gesture, player1Gesture, player2.getName()));
            player2Pts++;
        }

    }

    private static int getGestureIndex(String gesture) {
        String[] gesturesArray = {"rock", "paper", "scissors", "spock", "lizard"};

        for (int i = 0; i < gesturesArray.length; i++) {
            if (gesture.equals(gesturesArray[i])) {
                return i;
            }
        }
        return -1;
    }

    private void displayPoints() {
        System.out.println("Points:");
        System.out.println(player1.getName() + " - " + player1Pts);
        System.out.println(player2.getName() + " - " + player2Pts);
    }
}