import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int space;
    private boolean inJail;
    private ArrayList<Property> property;

    public Player() {
        property = new ArrayList<Property>();
    }

    public Player(String name) {
        this.name = name;
        property = new ArrayList<Property>();
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
        this.money = money;
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
}