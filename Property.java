public class Property extends Space {
    private String name;
    private int rent;
    private int price;
    private boolean isOwned;
    private Player owner;
    private propertyType type;
    private int boardSpace;
    private colorGroup color;


    public Property() {}

    public Property(int boardSpace, String name, int price, int rent, propertyType type, colorGroup color) {
        super("property");
        this.name = name;
        this.rent = rent;
        this.price = price;
        isOwned = false;
        this.type = type;
        if(type.toString().equals(propertyType.residential.toString())) {
            this.color = color;
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

    @Override
    public String toString() {
        String colorstr = "";
        if(type.toString().equals(propertyType.residential.toString())) {
            colorstr = " of the color " + color.toString();
        }
        return name + " valued at $" + price + colorstr;
    }

    public void displayStats() {
        System.out.println("Price: " + price);
        if(type.toString() == propertyType.utility.toString()) {
            System.out.println("\tNote: rent will be:\n\t\t4 times dice roll if 1 utility owned,\n\t\t10 times dice roll if both utilities owned");
        }
        System.out.println("Rent: " + rent);
        if(type.toString().equals(propertyType.residential.toString())) {
            System.out.println("Color Group: " + color);
        }
    }

    public void run(Game game) {
        if(!isOwned) {
            String choice;
            System.out.println("Would you like to purchase " + name + "?");
            displayStats();
            System.out.println("Press 1 to purchase or any other key to not purchase.");
            choice = game.user.next();
            if (choice.equals("1")) {
                game.getCurrentPlayer().updateProperty(this, game);
                System.out.println("You purchased " + name + "!");
            }
        } else {
            if(type.toString().equals(propertyType.utility.toString())) {
                rent = game.getDiceRoll()*owner.diceRollMultiplier();
            }
            if(!owner.equals(game.getCurrentPlayer())) {
                System.out.println(owner.getName() + " owns this property. Time to pay rent: $" + rent);
                System.out.println("Press any key to pay");
                game.user.next();
                System.out.println("Paying...");
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                game.getCurrentPlayer().incrementMoney(-rent);
                owner.incrementMoney(rent);
            } else {
                System.out.println("You own this property already!");
            }
        }
    } 
}