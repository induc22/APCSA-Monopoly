import java.util.ArrayList;
enum propertyType {residential, utility, railroad}

class Space {

    private String name;

    public Space() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(Player player) {

    }

    public ChanceOrComChest comChest(Board board) {
        int randomNum = (int) Math.random()*board.getComChest().size();
        return board.getComChest().get(randomNum);
    }

    public ChanceOrComChest chance(Board board) {
        int randomNum = (int) Math.random()*board.getChance().size();
        return board.getChance().get(randomNum);
    }

}