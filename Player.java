import java.util.ArrayList;

public class Player {
    //REQ: encapsulation - Player encapsulates the below attributes, clients access with getters and setters and other methods
    private int index;
    private String name;
    private int money;
    private int space;
    private boolean inJail;
    private ArrayList<Property> property;
    private boolean getOutJailFree;
    private int totalValue;
    private int numRR;
    private int numUtil;
    //OPT: above: primitives

    public Player() {
        property = new ArrayList<Property>();
        numRR = 0;
        inJail = false;
        getOutJailFree = false;
    }

    public Player(String name) {
        this.name = name;
        property = new ArrayList<Property>();
        numRR = 0;
        inJail = false;
        getOutJailFree = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        int initMoney = this.money;
        this.money = money;
        this.totalValue = this.totalValue + (money - initMoney); //OPT: PEMDAS
    }

    public void incrementMoney(int increment) {
        this.money = this.money + increment;
        this.totalValue = this.totalValue + increment;
    }

    public int getSpace() {
        return this.space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public boolean getInJail() {
        return this.inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public ArrayList<Property> getProperty() {
        return this.property;
    }
    
    public void setProperty(ArrayList<Property> property) {
        this.property = property;
    }

    public boolean getGetOutJailFree() {
        return this.getOutJailFree;
    }

    public void setGetOutJailFree(boolean getOutJailFree) {
        this.getOutJailFree = getOutJailFree;
    }

    public int getTotalValue() {
        return this.totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public void incrementTotalValue(int increment) {
        this.totalValue = this.totalValue + increment;
    }

    public int getNumRR() {
        return this.numRR;
    }

    public void setNumRR(int numRR) {
        this.numRR = numRR;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNumUtil() {
        return this.numUtil;
    }

    public void incrementNumUtil() {
        this.numUtil++;
    }

    public int diceRollMultiplier() {
        if (numUtil == 1) {
            return 4;
        } else if (numUtil == 2) {
            return 10;
        } else {
            return 0;
        }
    }

    public void spaceMove(int spaceMove, Game game) { //OPT: spaceMove is pass by reference
        if(spaceMove < 0) { 
            if(space < Math.abs(spaceMove)) {
                int behindGo = Math.abs(spaceMove) - space;
                space = game.getBoard().getBoard().length - 1 - behindGo; 
            } else {
                space = space - spaceMove;
            }  
        } else {
            if(space + spaceMove > (game.getBoard().getBoard().length-1)) {
                space = spaceMove + space - game.getBoard().getBoard().length; //REQ: math operations on primitives
                incrementMoney(200);
                System.out.println("You passed go! Collecting $200...");
            } else {
                space = space + spaceMove;
            }
        }
    }

    public void advanceToNearest(propertyType type) {
        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<Integer> spaceNums = new ArrayList<Integer>();
        if (type.toString().equals(propertyType.railroad.toString())) {
            int dBNO = BoardMap.Spaces.BN0_RR - space;
            int dReading = BoardMap.Spaces.READING_RR - space;
            int dPenn = BoardMap.Spaces.PENNSYLVANIA_RR - space;
            int dShortLine = BoardMap.Spaces.SHORT_LINE_RR - space;
            spaceNums.add(BoardMap.Spaces.BN0_RR);
            spaceNums.add(BoardMap.Spaces.READING_RR);
            spaceNums.add(BoardMap.Spaces.PENNSYLVANIA_RR);
            spaceNums.add(BoardMap.Spaces.SHORT_LINE_RR);
            distances.add(dBNO); 
            distances.add(dReading);
            distances.add(dPenn);
            distances.add(dShortLine);
        } else if (type.toString().equals(propertyType.utility.toString())) {
            int dWW = BoardMap.Spaces.WATER_WORKS - space;
            int dEC = BoardMap.Spaces.ELECTRIC_COMPANY;
            distances.add(dWW);
            distances.add(dEC);
            spaceNums.add(BoardMap.Spaces.WATER_WORKS);
            spaceNums.add(BoardMap.Spaces.ELECTRIC_COMPANY);
        }
        int shortestDistance = 50;
        for(int i = 0; i < distances.size(); i++) {
            if (distances.get(i) > 0) {
                if (distances.get(i) < shortestDistance){
                    shortestDistance = distances.get(i);
                    space = spaceNums.get(i);
                }
            }
        }
    }

    public void displayPlayerStats() {
        System.out.println("\n\n" + name + "'s stats: ");
        System.out.println("Bank Balance: $" + money);
        if(inJail) {
            System.out.println("You are in jail");
        } else {
            System.out.println("You are not in jail");
        } if(getOutJailFree) {
            System.out.println("You have a get out of jail free card");
        } else {
            System.out.println("You do NOT have a get out of jail free card");
        }
        System.out.println("You own: ");
        for(Property prop : property) {
            System.out.println("\t" + prop.toString());
        }
        System.out.println("Your total value is : $" + totalValue + "\n\n");
    }

    public void updateProperty(Property newProperty, Game game) {
        property.add(newProperty);
        newProperty.setIsOwned(true);
        incrementMoney(-newProperty.getPrice());
        incrementTotalValue(newProperty.getPrice());
            newProperty.setOwner(this);
            if(newProperty.getType().toString().equals(propertyType.railroad.toString())) {
                numRR++;
                newProperty.setRent(25 + (game.getCurrentPlayer().getNumRR())*25);
            } else if(newProperty.getType().toString().equals(propertyType.utility.toString())) {
                numUtil++;
            } 
        //search existing property for color match, update rent, update numRR, add utility variable and update
    }

}