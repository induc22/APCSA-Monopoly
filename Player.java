import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int space;
    private boolean inJail;
    private ArrayList<Property> property;
    private boolean getOutJailFree;
    private int totalValue; //TODO: totalValue() method to calculate, place in all methods that increment money or property
    private int numRR; //TODO: numRR() method to calculate number of railroads

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
        this.totalValue = this.totalValue + (money - initMoney);
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

    public void spaceMove(int spaceMove, Game game) {
        if(spaceMove < 0) {
            if(space < Math.abs(spaceMove)) {
                int behindGo = Math.abs(spaceMove) - space;
                space = game.getBoard().getBoard().length - 1 - behindGo;
            } else {
                space = space - spaceMove;
            }  
        } else {
            if(space + spaceMove > game.getBoard().getBoard().length) {
                space = spaceMove + space - game.getBoard().getBoard().length;
            } else {
                space = space + spaceMove;
            }
        }
    }

    public void advanceToNearest(propertyType type) {
        ArrayList<Integer> distances = new ArrayList<Integer>();
        if (type.toString().equals(propertyType.railroad.toString())) {
            int dBNO = BoardMap.Spaces.BN0_RR - space;
            int dReading = BoardMap.Spaces.READING_RR - space;
            int dPenn = BoardMap.Spaces.PENNSYLVANIA_AVE - space;
            int dShortLine = BoardMap.Spaces.SHORT_LINE_RR - space;
            distances.add(dBNO); 
            distances.add(dReading);
            distances.add(dPenn);
            distances.add(dShortLine);          
        } else if (type.toString().equals(propertyType.utility.toString())) {
            int dWW = BoardMap.Spaces.WATER_WORKS - space;
            int dEC = BoardMap.Spaces.ELECTRIC_COMPANY;
            distances.add(dWW);
            distances.add(dEC);
        }
        int i = 0; 
        int longestDistance = 0; 
        for(i = 0; i < distances.size(); i++) {
            if (distances.size() > longestDistance) {
                longestDistance = distances.size();
                space = i;
            }
        }
    }
}