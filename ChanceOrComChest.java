public class ChanceOrComChest extends Space{
    private String action;
    private int moneyChange;
    private int moneyFromOtherPlayers;
    private int destination;
    private int spaceMove;
    private boolean advanceToNeartest;
    private propertyType type;

    public ChanceOrComChest() {}

    public ChanceOrComChest(String cardType, String action) {
        super(cardType);
        this.action = cardType;
        this.moneyChange = 0;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = 0;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(String cardType, String action, int moneyChange, int spaceMove) {
        super(cardType);
        this.action = action;
        this.moneyChange = moneyChange;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = spaceMove;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(String cardType, boolean advanceToNeartest, propertyType type, String action) {
        super(cardType);
        this.advanceToNeartest = advanceToNeartest;
        this.type = type;
        this.action = action;
        this.moneyChange = 0;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = 0;
    }

    public ChanceOrComChest(String cardType, String action, int moneyChange, int moneyFromOtherPlayers, int destination) {
        super(cardType);
        this.action = action;
        this.moneyChange = moneyChange;
        this.moneyFromOtherPlayers = moneyFromOtherPlayers;
        this.destination = destination;
        this.spaceMove = 0;
        this.advanceToNeartest = false;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getMoneyChange() {
        return this.moneyChange;
    }

    public void setMoneyChange(int moneyChange) {
        this.moneyChange = moneyChange;
    }

    public int getMoneyFromOtherPlayers() {
        return this.moneyFromOtherPlayers;
    }

    public void setMoneyFromOtherPlayers(int moneyFromOtherPlayers) {
        this.moneyFromOtherPlayers = moneyFromOtherPlayers;
    }

    public int getDestination() {
        return this.destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getSpaceMove() {
        return this.spaceMove;
    }

    public void setSpaceMove(int spaceMove) {
        this.spaceMove = spaceMove;
    }

    public boolean getAdvanceToNeartest() {
        return this.advanceToNeartest;
    }

    public void setAdvanceToNeartest(boolean advanceToNeartest) {
        this.advanceToNeartest = advanceToNeartest;
    }

    public propertyType getType() {
        return this.type;
    }

    public void setPropertyType(propertyType type) {
        this.type = type;
    }
}