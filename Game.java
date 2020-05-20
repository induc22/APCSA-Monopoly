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
        gamePlay();
    }

    public void setup() {
        System.out.println("Welcome to Simplified Monopoly!");
        
        // set up players and add money
        System.out.println("How many players do you have?");
        numPlayers = user.nextInt();
        user.nextLine();
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++ ) {
            System.out.println("Player " + (i + 1) + ", what is your name?");
            String name = user.nextLine();
            players[i] = new Player(name);
            players[i].setMoney(1500);
            players[i].setSpace(0);
            System.out.println(players[i].getName() + " now has $1500");
        }

        currentPlayer = players[0];
        diceRoll = 0;

        board = new Board();
        // TODO: rent calculator method for properties AHHHHHHHHHH
        // TODO: map to BoardMap rent and costs
        board.setBoard(new Space[] {
            new Space("Go"), 
            new Property(BoardMap.Spaces.MEDITERANNEAN_AVE, "Mediterannean Avenue", 60, 2, propertyType.residential), 
            new Space("Community Chest"),
            new Property(BoardMap.Spaces.BALTIC_AVE, "Baltic Avenue", 60, 4, propertyType.residential),
            new Space("Income Tax"),
            new Property(BoardMap.Spaces.READING_RR, "Reading Railroad", 200, currentPlayer.getNumRR()*25, propertyType.railroad),
            new Property(BoardMap.Spaces.ORIENTAL_AVE, "Oriental Avenue", 100, 6, propertyType.residential),
            new Space("Chance"),
            new Property(BoardMap.Spaces.VERMONT_AVE, "Vermont Avenue", 100, 6, propertyType.residential),
            new Property(BoardMap.Spaces.CONNECTICUT_AVE, "Connecticut Avenue", 120, 8, propertyType.residential),
            new Space("Jail"),
            new Property(BoardMap.Spaces.ST_CHARLES_PLACE, "St.Charles Place", 140, 10, propertyType.residential),
            new Property(BoardMap.Spaces.ELECTRIC_COMPANY, "Electric Company", 150, diceRoll*4, propertyType.utility),
            new Property(BoardMap.Spaces.STATES_AVE, "States Avenue", 140, 10, propertyType.residential),
            new Property(BoardMap.Spaces.VIRGINIA_AVE, "Virginia Avenue", 160, 12, propertyType.residential),
            new Property(BoardMap.Spaces.PENNSYLVANIA_RR, "Pennsylvania Railroad", 200, currentPlayer.getNumRR()*25, propertyType.railroad),
            new Property(BoardMap.Spaces.ST_JAMES_PLACE, "St. James Place", 180, 14, propertyType.residential),
            new Space("Community Chest"),
            new Property(BoardMap.Spaces.TENNESSEE_AVE, "Tennessee Avenue", 180, 14, propertyType.residential),
            new Property(BoardMap.Spaces.NEW_YORK_AVE, "New York Avenue", 200, 16, propertyType.residential),
            new Space("Free Parking"),
            new Property(BoardMap.Spaces.KENTUCKY_AVE, "Kentucky Avenue", 220, 18, propertyType.residential),
            new Space("Chance"),
            new Property(BoardMap.Spaces.INDIANA_AVE, "Indiana Avenue", 220, 18, propertyType.residential),
            new Property(BoardMap.Spaces.ILLINOIS_AVE,"Illinois Avenue", 240, 20, propertyType.residential),
            new Property(BoardMap.Spaces.BN0_RR, "b. & O. Railroad", 200, currentPlayer.getNumRR()*25, propertyType.railroad),
            new Property(BoardMap.Spaces.ATLANTIC_AVE,"Atlantic Avenue", 260, 22, propertyType.residential),
            new Property(BoardMap.Spaces.VENTINOR_AVE,"Ventinor Avenue", 260, 22, propertyType.residential),
            new Property(BoardMap.Spaces.MARIAN_GARDENS,"Marvin Gardens", 280, 24, propertyType.residential),
            new Space("Go to jail!"),
            new Property(BoardMap.Spaces.PACIFIC_AVE,"Pacific Avenue", 300, 26, propertyType.residential),
            new Property(BoardMap.Spaces.NORTH_CAROLINA_AVE,"North Carolina Avenue", 300, 26, propertyType.residential),
            new Space("Community Chest"),
            new Property(BoardMap.Spaces.PENNSYLVANIA_AVE,"Pennsylvania Avenue", 320, 28, propertyType.residential),
            new Property(BoardMap.Spaces.SHORT_LINE_RR, "Short Line Railroad", 200, currentPlayer.getNumRR()*25, propertyType.railroad),
            new Space("Chance"),
            new Property(BoardMap.Spaces.PARK_PLACE,"Park Place", 350, 35, propertyType.residential),
            new Space("Luxury Tax"),
            new Property(BoardMap.Spaces.BOARDWALK,"Boardwalk", 400, 50, propertyType.residential),
        }); 

    }

    public void gamePlay() {
        System.out.println("\nLet's Get Started!\n");
        System.out.println("Press any key to roll the dice");
        user.next();
        System.out.println("Rolling...");
        try
        {
        Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
        Thread.currentThread().interrupt();
        }
        diceRoll = (int) (Math.random()*12 + 1);
        System.out.println("You rolled a " + diceRoll);
        currentPlayer.spaceMove(diceRoll, this);
        System.out.println("TESTING: " + currentPlayer.getSpace());
        System.out.println("You landed on " + board.getBoard()[currentPlayer.getSpace()].getName());
        board.getBoard()[currentPlayer.getSpace()].run(this);
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

    public void sellProperty(Property property) {
        System.out.println("I'm selling property!");
    }

}