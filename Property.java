public class Property extends Space {
    private String name;
    private int rent;
    private int price;
    private int numHouses;
    private int numHotels;
    private boolean isOwned;
    private Player owner;
    private propertyType type;
    private int boardSpace;
    private String color;

    public Property() {}

    public Property(int boardSpace, String name, int price, int rent, propertyType type) {
        super("property");
        this.name = name;
        this.rent = rent;
        this.price = price;
        numHouses = 0;
        numHotels = 0;
        isOwned = false;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRent() {
        return this.rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumHouses() {
        return this.numHouses;
    }

    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }

    public void incrementNumHouses() {
        this.numHouses++;
    }

    public int getNumHotels() {
        return this.numHotels;
    }

    public void setNumHotels(int numHotels) {
        this.numHotels = numHotels;
    }

    public void incrementNumHotels() {
        this.numHotels++;
    }

    public boolean getIsOwned() {
        return this.isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public Player getOnwer() {
        return this.owner;
    }

    public void setPlayer(Player owner) {
        this.owner = owner;
    }

    public propertyType getType() {
        return this.type;
    }

    public void setPropertyType(propertyType type) {
        this.type = type;
    }

    public int getBoardSpace() {
        return this.boardSpace;
    }

    public void setBoardSpace(int boardSpace) {
        this.boardSpace = boardSpace;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}