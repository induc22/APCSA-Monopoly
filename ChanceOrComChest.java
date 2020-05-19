public class ChanceOrComChest extends Space{
    private String name;
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

    public ChanceOrComChest(String name) {
        this.name = name;
        this.moneyChange = 0;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = 0;
        this.hhPay = false;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(String name, int moneyChange, int spaceMove) {
        this.name = name;
        this.moneyChange = moneyChange;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = spaceMove;
        this.hhPay = false;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(String name, boolean hhPay, int housePay, int hotelPay) {
        this.name = name;
        this.moneyChange = 0;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.hhPay = hhPay;
        this.housePay = housePay;
        this.hotelPay = hotelPay;
        this.advanceToNeartest = false;
    }

    public ChanceOrComChest(boolean advanceToNeartest, propertyType type, String name) {
        this.advanceToNeartest = advanceToNeartest;
        this.type = type;
        this.name = name;
        this.moneyChange = 0;
        this.moneyFromOtherPlayers = 0;
        this.destination = -1;
        this.spaceMove = 0;
        this.hhPay = false;
    }

    public ChanceOrComChest(String name, int moneyChange, int moneyFromOtherPlayers, int destination) {
        this.name = name;
        this.moneyChange = moneyChange;
        this.moneyFromOtherPlayers = moneyFromOtherPlayers;
        this.destination = destination;
        this.spaceMove = 0;
        this.hhPay = false;
        this.advanceToNeartest = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
}