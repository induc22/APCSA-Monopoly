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
    private colorGroup color;
    private int houseHotelCost;


    public Property() {}

    public Property(int boardSpace, String name, int price, int rent, propertyType type, colorGroup color, int houseHotelCost) {
        super("property");
        this.name = name;
        this.rent = rent;
        this.price = price;
        numHouses = 0;
        numHotels = 0;
        isOwned = false;
        this.type = type;
        if(type.toString().equals(propertyType.residential.toString())) {
            this.color = color;
            this.houseHotelCost = houseHotelCost;
        }
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

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
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

    public colorGroup getColor() {
        return this.color;
    }

    public void setColor(colorGroup color) {
        this.color = color;
    }

    public int getHouseHotelCost() {
        return this.houseHotelCost;
    }

    public void setHouseHotelCost(int houseHotelCost) {
        this.houseHotelCost = houseHotelCost;
    }

    public void displayStats() {
        System.out.println("Price: " + price);
        System.out.println("Rent (no houses): " + rent);
        if(type.toString().equals(propertyType.residential.toString())) {
            System.out.println("Color Group: " + color);
        }
    }

    public void run(Game game) {
        if(!isOwned) {
            int choice;
            System.out.println("Would you like to purchase " + name + "?");
            displayStats();
            System.out.println("Press 1 to purchase or any other key to not purchase.");
            choice = game.user.nextInt();
            if (choice == 1) {
                game.getCurrentPlayer().updateProperty(this, game);
                System.out.println("You purchased " + name + "!");
            }
        } else {
            if(type.toString().equals(propertyType.utility.toString())) {
                rent = game.getDiceRoll()*game.getCurrentPlayer().diceRollMultiplier();
            }
            if(!owner.equals(game.getCurrentPlayer())) {
                System.out.println(owner.getName() + " owns this property. Time to pay rent: " + rent);
                System.out.println("Press any key to pay");
                game.user.nextLine();
                System.out.println("Paying...");
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                game.getCurrentPlayer().incrementMoney(-rent);
                owner.incrementMoney(rent);
            } else {
                System.out.println("You own this property!");
                game.getCurrentPlayer().sellHouseOrHotel(this, game);
            }
        }
    } 
}