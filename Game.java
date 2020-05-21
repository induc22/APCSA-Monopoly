import java.util.ArrayList;
import java.util.Scanner;
enum colorGroup {purple, light_blue, pink, orange, red, yellow, green, dark_blue, NA}

public class Game {

    private int numPlayers;
    private Player[] players;
    private Player currentPlayer;
    private Board board;
    private int diceRoll;
    private String exit;
    private boolean doubles;
    private boolean play;

    Scanner user = new Scanner(System.in);

    public Game() {
        setup();
        System.out.println("\nLet's Get Started!\n");
        gamePlay();
        showEndStats();
    }

    public void setup() {
        doubles = true;
        exit = "";
        
        // set up players and add money
        System.out.println("How many players do you have?");
        numPlayers = user.nextInt();
        players = new Player[numPlayers];
        for(int i = 0; i < numPlayers; i++ ) {
            System.out.println("Player " + (i + 1) + ", what is your name?");
            String name = user.next();
            players[i] = new Player(name);
            players[i].setMoney(2000);
            players[i].setSpace(0);
            players[i].setIndex(i);
            System.out.println(players[i].getName() + " now has $2000");
        }

        currentPlayer = players[0]; //REQ: assigning references
        diceRoll = 0;

        board = new Board();
        board.fillChance();
        board.fillComChest();
        board.setBoard(new Space[] {
            new Space("Go"), 
            new Property(BoardMap.Spaces.MEDITERANNEAN_AVE, "Mediterannean Avenue", 60, 2, propertyType.residential, colorGroup.purple), 
            new Space("Community Chest"),
            new Property(BoardMap.Spaces.BALTIC_AVE, "Baltic Avenue", 60, 4, propertyType.residential, colorGroup.purple),
            new Space("Income Tax"),
            new Property(BoardMap.Spaces.READING_RR, "Reading Railroad", 200, 25, propertyType.railroad, colorGroup.NA),
            new Property(BoardMap.Spaces.ORIENTAL_AVE, "Oriental Avenue", 100, 6, propertyType.residential, colorGroup.light_blue),
            new Space("Chance"),
            new Property(BoardMap.Spaces.VERMONT_AVE, "Vermont Avenue", 100, 6, propertyType.residential, colorGroup.light_blue),
            new Property(BoardMap.Spaces.CONNECTICUT_AVE, "Connecticut Avenue", 120, 8, propertyType.residential, colorGroup.light_blue),
            new Space("Jail"),
            new Property(BoardMap.Spaces.ST_CHARLES_PLACE, "St.Charles Place", 140, 10, propertyType.residential, colorGroup.pink),
            new Property(BoardMap.Spaces.ELECTRIC_COMPANY, "Electric Company", 150, diceRoll*4, propertyType.utility, colorGroup.NA),
            new Property(BoardMap.Spaces.STATES_AVE, "States Avenue", 140, 10, propertyType.residential, colorGroup.pink),
            new Property(BoardMap.Spaces.VIRGINIA_AVE, "Virginia Avenue", 160, 12, propertyType.residential, colorGroup.pink),
            new Property(BoardMap.Spaces.PENNSYLVANIA_RR, "Pennsylvania Railroad", 200, 25, propertyType.railroad, colorGroup.NA),
            new Property(BoardMap.Spaces.ST_JAMES_PLACE, "St. James Place", 180, 14, propertyType.residential, colorGroup.pink),
            new Space("Community Chest"),
            new Property(BoardMap.Spaces.TENNESSEE_AVE, "Tennessee Avenue", 180, 14, propertyType.residential, colorGroup.orange),
            new Property(BoardMap.Spaces.NEW_YORK_AVE, "New York Avenue", 200, 16, propertyType.residential, colorGroup.orange),
            new Space("Free Parking"),
            new Property(BoardMap.Spaces.KENTUCKY_AVE, "Kentucky Avenue", 220, 18, propertyType.residential, colorGroup.red),
            new Space("Chance"),
            new Property(BoardMap.Spaces.INDIANA_AVE, "Indiana Avenue", 220, 18, propertyType.residential, colorGroup.red),
            new Property(BoardMap.Spaces.ILLINOIS_AVE,"Illinois Avenue", 240, 20, propertyType.residential, colorGroup.red),
            new Property(BoardMap.Spaces.BN0_RR, "B. & O. Railroad", 200, 25, propertyType.railroad, colorGroup.NA),
            new Property(BoardMap.Spaces.ATLANTIC_AVE,"Atlantic Avenue", 260, 22, propertyType.residential, colorGroup.yellow),
            new Property(BoardMap.Spaces.VENTINOR_AVE,"Ventinor Avenue", 260, 22, propertyType.residential, colorGroup.yellow),
            new Property(BoardMap.Spaces.WATER_WORKS, "Water Works", 150, diceRoll*4, propertyType.utility, colorGroup.NA),
            new Property(BoardMap.Spaces.MARIAN_GARDENS,"Marvin Gardens", 280, 24, propertyType.residential, colorGroup.yellow),
            new Space("Go to jail!"),
            new Property(BoardMap.Spaces.PACIFIC_AVE,"Pacific Avenue", 300, 26, propertyType.residential, colorGroup.green),
            new Property(BoardMap.Spaces.NORTH_CAROLINA_AVE,"North Carolina Avenue", 300, 26, propertyType.residential, colorGroup.green),
            new Space("Community Chest"),
            new Property(BoardMap.Spaces.PENNSYLVANIA_AVE,"Pennsylvania Avenue", 320, 28, propertyType.residential, colorGroup.green),
            new Property(BoardMap.Spaces.SHORT_LINE_RR, "Short Line Railroad", 200, 25, propertyType.railroad, colorGroup.NA),
            new Space("Chance"),
            new Property(BoardMap.Spaces.PARK_PLACE,"Park Place", 350, 35, propertyType.residential, colorGroup.dark_blue),
            new Space("Luxury Tax"),
            new Property(BoardMap.Spaces.BOARDWALK,"Boardwalk", 400, 50, propertyType.residential, colorGroup.dark_blue),
        }); 

    }

    public void gamePlay() {
        while(!exit.equals("y")) { //REQ: loops
            currentPlayer.displayPlayerStats();
            if (currentPlayer.getInJail()) {
                System.out.println("You're in jail!");
                System.out.println("Press: ");
                System.out.println("1 to pay $50 to get out");
                System.out.println("2 to roll dice (need doubles to get out)");
                if(currentPlayer.getGetOutJailFree()) {
                    System.out.println("3 to use your get out of jail free card");
                }
                System.out.println("Press any other key to stay in jail");
                int choice = user.nextInt();
                if(choice == 1) {
                    currentPlayer.incrementMoney(-50);
                    currentPlayer.setInJail(false);
                    System.out.println("You are out of jail!");
                } else if(choice == 2) {
                    rollDice();
                    if(doubles) {
                        currentPlayer.setInJail(false);
                        System.out.println("You are out of jail!");
                    } else {
                        System.out.println("Sorry, you did not roll doubles. You are still in jail.");
                    }
                } else if (choice == 3) {
                    System.out.println("You used your get out of jail free card");
                    System.out.println("You are out of jail!");
                    currentPlayer.setGetOutJailFree(false);
                    currentPlayer.setInJail(false);
                } else {
                    System.out.println("You are still in jail. Your turn is skipped");
                }
            }
            if(!currentPlayer.getInJail()) {
                play = true;
                while(play && !currentPlayer.getInJail()) { //REQ: boolean expressions
                    System.out.println("Press any key to roll the dice");
                    user.next();
                    System.out.println("Rolling...");
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    rollDice();
                    System.out.println("You rolled " + diceRoll);
                    if (doubles) {
                        System.out.println("You rolled doubles! You will play again after this turn");
                    }
                    play = doubles;
                    currentPlayer.spaceMove(diceRoll, this);
                    System.out.println("You landed on " + board.getBoard()[currentPlayer.getSpace()].getName());
                    if(currentPlayer.getSpace() == 10) { //REQ: conditionals
                        System.out.println("\t(just visiting!)");
                    }
                    board.getBoard()[currentPlayer.getSpace()].run(this);
                }
            }
            currentPlayer.displayPlayerStats();
            shiftPlayer();
            System.out.println("Next Player: " + currentPlayer.getName());
            System.out.println("Would you like to end the game?");
            System.out.println("Press y to end OR any other key to continue");
            exit = user.next();
        }   
    }

    public void showEndStats() {
        for(Player player : players) {
            player.displayPlayerStats();
        }
        // print all winners
        ArrayList<String> winners = winners();
        if(winners.size() == 1) {
            System.out.println(winners.get(0) + " has won!");
        } else if (winners.size() == players.length){
            System.out.println("Everyone tied");
        } else if (winners.size() == 0) {
            System.out.println("Everyone is in debt. Nobody wins!");
        } else {
            System.out.print("Winners: " + winners.toString());
        }
    }

    public ArrayList<String> winners() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < players.length; i++) {
            if(players[i].getMoney() < 0) {
                System.out.println(players[i].getName() + " is in debt to the bank (negative bank balance). " + players[i].getName() + " lost!");
            } else {
                nums.add(players[i].getTotalValue());
            } 
        }
        int arrNums[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            arrNums[i] = nums.get(i);
        }
        insertionSort(arrNums);
        ArrayList<String> winners = new ArrayList<String>();
        for(Player player : players) {
           if(arrNums[arrNums.length-1] == player.getTotalValue()) {
                winners.add(player.getName());
           }
        }
        return winners;
    }

    public void insertionSort(int array[]) {  //OPT: array[] is pass by reference
        int n = array.length;  //OPT: insertion sort is a sorting method
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
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

    public void shiftPlayer() {
        if(currentPlayer == players[players.length-1]) {
            currentPlayer = players[0];
        } else {
            currentPlayer = players[currentPlayer.getIndex()+1];
        }
    }

    public void rollDice() {
        int die1 = (int) (Math.random()*6 + 1);
        int die2 = (int) (Math.random()*6 + 1);
        if(die1 == die2) {
            doubles = true;
        } else {
            doubles = false;
        }
        diceRoll = die1 + die2;
    }

}