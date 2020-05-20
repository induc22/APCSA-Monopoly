import java.util.Scanner;

public class Game {

    private int numPlayers;
    private Player[] players;
    private Player currentPlayer;
    private Board board;
    private int diceRoll;

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

        board = new Board();
        // TODO: rent calculator method for properties AHHHHHHHHHH
        // TODO: map to BoardMap rent and costs
        board.setBoard(new Space[] {
            new Space("Go"), 
            new Property(BoardMap.Spaces.MEDITERANNEAN_AVE, "Mediterannean Avenue", 60, 2, propertyType.residential), 
            new Space("CC"),
            new Property(BoardMap.Spaces.BALTIC_AVE, "Baltic Avenue", 60, 4, propertyType.residential),
            new Space("Income Tax"),
            new Property(BoardMap.Spaces.READING_RR, "Reading Railroad", 200, currentPlayer.getNumRR()*25, propertyType.railroad),
            new Property(BoardMap.Spaces.ORIENTAL_AVE, "Oriental Avenue", 100, 6, propertyType.residential),
            new Space("CH"),
            new Property(BoardMap.Spaces.VERMONT_AVE, "Vermont Avenue", 100, 6, propertyType.residential),
            new Space("Jail"),
            new Property(BoardMap.Spaces.ST_CHARLES_PLACE, "St.Charles Place", 140, 10, propertyType.residential),
            new Property(BoardMap.Spaces.ELECTRIC_COMPANY, "Electric Company", 150, diceRoll*4, propertyType.utility),
            new Property(BoardMap.Spaces.STATES_AVE, "States Avenue", 140, 10, propertyType.residential),
            new Property(BoardMap.Spaces.VIRGINIA_AVE, "Virginia Avenue", 160, 12, propertyType.residential),
            new Property(BoardMap.Spaces.PENNSYLVANIA_RR, "Pennsylvania Railroad", 200, currentPlayer.getNumRR()*25, propertyType.railroad),
            new Property(BoardMap.Spaces.ST_JAMES_PLACE, "St. James Place", 180, 14, propertyType.residential)
        }); 

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

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getDiceRoll () {
        return this.diceRoll;
    }

    public void setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
    }

}