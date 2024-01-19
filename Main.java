package RPSLS;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Rock-Paper-Scissors-Lizard-Spock Game!");

        Player player1 = createPlayer(1);
        Player player2 = createPlayer(2);

        Game game = new Game(player1, player2, 2);
        game.start();

    }

    private static Player createPlayer(int playerNumber) {
        System.out.print("Enter Player " + playerNumber + "'s name: ");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);
        return player;
    }
}