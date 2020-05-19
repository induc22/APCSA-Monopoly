import java.util.Scanner;

public class Game {
    private int numPlayers;
    private Player[] players;
    private Space[] board;
    Scanner user = new Scanner(System.in);

    public Game() {
        setup();
    }

    public void setup() {
        System.out.println("Welcome to Simplified Monopoly!");
        
        // set up players and add money
        System.out.println("How many players do you have?");
        numPlayers = user.nextInt();
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++ ) {
            System.out.println("Player " + (i + 1) + ", what is your name?");
            String name = user.nextLine();
            players[i] = new Player(name);
            players[i].setMoney(1500);
        }

        //set up board
        //board = {new Space("Go"), new Property("Mediterannean")} TODO: you are hereeeeeeee

    }

    public int getNumPlayers() {
        return this.numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Space[] getBoard() {
        return this.board;
    }

    public void setBoard(Space[] board) {
        this.board = board;
    }

}