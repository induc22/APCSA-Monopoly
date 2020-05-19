public class Property extends Space {
    private String name;
    private int rent;
    private int price;
    private int numHouses;
    private int numHotels;
    private boolean isOwned;

    public Property() {}

    public Property(String name, int rent, int price) {
        this.name = name;
        this.rent = rent;
        this.price = price;
        numHouses = 0;
        numHotels = 0;
        isOwned = false;
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
}