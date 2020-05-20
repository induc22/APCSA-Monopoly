public class ChanceOrComChest extends Space{
    private String action;
    private int moneyChange;
    private int moneyFromOtherPlayers;
    private int destination;
    private int spaceMove;
    private int housePay;
    private int hotelPay;
    private boolean hhPay;
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
        this.hhPay = false;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(String cardType, String action, int moneyChange, int spaceMove) {
        super(cardType);
        this.action = action;
        this.moneyChange = moneyChange;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = spaceMove;
        this.hhPay = false;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(String cardType, String action, boolean hhPay, int housePay, int hotelPay) {
        super(cardType);
        this.action = action;
        this.moneyChange = 0;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.hhPay = hhPay;
        this.housePay = housePay;
        this.hotelPay = hotelPay;
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
        this.hhPay = false;
    }

    public ChanceOrComChest(String cardType, String action, int moneyChange, int moneyFromOtherPlayers, int destination) {
        super(cardType);
        this.action = action;
        this.moneyChange = moneyChange;
        this.moneyFromOtherPlayers = moneyFromOtherPlayers;
        this.destination = destination;
        this.spaceMove = 0;
        this.hhPay = false;
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

    public int getHousePay() {
        return this.housePay;
    }

    public void setHousePay(int housePay) {
        this.housePay = housePay;
    }

    public int getHotelPay() {
        return this.hotelPay;
    }

    public void setHotelPay(int hotelPay) {
        this.hotelPay = hotelPay;
    }

    public boolean gethhPay() {
        return this.hhPay;
    }

    public void sethhPay(boolean hhPay) {
        this.hhPay = hhPay;
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