import java.util.ArrayList;

public class Board { //REQ: abstraction - pulling big ideas out: a board is an object and a big idea of Monopolyso I made a class
    private Space[] board; //REQ: 1D array
    private ArrayList<ChanceOrComChest> comChest;
    private ArrayList<ChanceOrComChest> chance;

    public Board() {
        comChest = new ArrayList<ChanceOrComChest>(); //REQ: 1D ArrayList
        chance = new ArrayList<ChanceOrComChest>();
    }

    public void fillComChest() {
        comChest.add(new ChanceOrComChest("Community Chest", "Go to jail!",0,0,BoardMap.Spaces.JAIL)); //REQ: classes, objects
        comChest.add(new ChanceOrComChest("Community Chest", "Bank error in your favor, collect $200", 200,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Income tax refund, collect $20", 20,0));
        comChest.add(new ChanceOrComChest("Community Chest", "You inherit $100", 100,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Pay hospital $100", -100,0));
        comChest.add(new ChanceOrComChest("Community Chest", "From sale of stock you get $45", 45,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Xmas fund matures, collect $100", 100,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Get out of jail free card (now added to your property)"));
        comChest.add(new ChanceOrComChest("Community Chest", "Collect $50 from every player", 0, -50,-1));
        comChest.add(new ChanceOrComChest("Community Chest", "Advance to go, collect $200", 200,0,BoardMap.Spaces.GO));
        comChest.add(new ChanceOrComChest("Community Chest", "You have won second prize in a beauty contest, collect $10", 10,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Pay school tax of $150", -150,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Receive for services $25", 25,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Doctor's fee, pay $50", -50,0));
        comChest.add(new ChanceOrComChest("Community Chest", "Life insurance matures, collect $100", 100,0));
    }

    public void fillChance() {
        chance.add(new ChanceOrComChest("Chance", "Go to jail!",0,0,BoardMap.Spaces.JAIL)); 
        chance.add(new ChanceOrComChest("Chance", "Go back 3 spaces",0,-3));
        chance.add(new ChanceOrComChest("Chance", "Advance to Illinois Ave.",0,0,BoardMap.Spaces.ILLINOIS_AVE));
        chance.add(new ChanceOrComChest("Chance", "Advance to boardwalk",0,0,BoardMap.Spaces.BOARDWALK));
        chance.add(new ChanceOrComChest("Chance", "Pay poor tax of $15",-15,0));
        chance.add(new ChanceOrComChest("Chance", "Your building and loan matures, collect $150", 150, 0));
        chance.add(new ChanceOrComChest("Chance", "Advance to St. Charles Place",0,0,BoardMap.Spaces.ST_CHARLES_PLACE));
        chance.add(new ChanceOrComChest("Chance", "Elected chairman of the board, pay each player $50",0,50,-1));
        chance.add(new ChanceOrComChest("Chance", "Take a ride on the Reading Railroad (Advance to Reading RR)",0,0,BoardMap.Spaces.READING_RR));
        chance.add(new ChanceOrComChest("Chance", "Advance to Go, collect $200",200,0));
        chance.add(new ChanceOrComChest("Chance", "Get out of jail free card (now added to your property)"));
        chance.add(new ChanceOrComChest("Chance", "Bank pays you dividend of $50", 50, 0));
        chance.add(new ChanceOrComChest("Chance", true, propertyType.railroad, "Advance to neartest railroad"));
         chance.add(new ChanceOrComChest("Chance", true, propertyType.utility, "Advance to neartest utility"));
    }

    public Space[] getBoard() {
        return this.board;
    }

    public void setBoard(Space[] board) {
        this.board = board;
    }

    public ArrayList<ChanceOrComChest> getComChest() {
        return this.comChest;
    }

    public void setComChest(ArrayList<ChanceOrComChest> comChest) {
        this.comChest = comChest;
    }

    public ArrayList<ChanceOrComChest> getChance() {
        return this.chance;
    }

    public void setChance(ArrayList<ChanceOrComChest> chance) {
        this.chance = chance;
    }
}