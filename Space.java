enum propertyType {residential, utility, railroad}

class Space {

    private String cardType;

    public Space() {}

    public Space(String cardType) {
        this.cardType = cardType;
    }

    public String getName() {
        return this.cardType;
    }

    public void setName(String cardType) {
        this.cardType = cardType;
    }

    public void run(Game game) {
        if (cardType.equals("Go")) {
            game.getCurrentPlayer().incrementMoney(200);
        } else if (cardType.equals("Chance") || cardType.equals("Community Chest")) {
            ChanceOrComChest card = generateCCorCH(game.getBoard(), cardType);
            System.out.println(card.getAction());
            game.getCurrentPlayer().incrementMoney(card.getMoneyChange());
            for(Player player : game.getPlayers()) {
                player.incrementMoney(card.getMoneyFromOtherPlayers());
            }
            game.getCurrentPlayer().incrementMoney(card.getMoneyFromOtherPlayers()*game.getNumPlayers());
            if(card.getDestination() != -1) {
                game.getCurrentPlayer().setSpace(card.getDestination());
            }
            if(card.getAction().equals("Go to jail!")) {
                game.getCurrentPlayer().setInJail(true);
            }
            game.getCurrentPlayer().spaceMove(card.getSpaceMove(), game);
            if (card.getAction().equals("Get out of jail free card (now added to your property)")) {
                game.getCurrentPlayer().setGetOutJailFree(true);
            }
            if (card.getAdvanceToNeartest()) {
                game.getCurrentPlayer().advanceToNearest(card.getType());
                game.getBoard().getBoard()[game.getCurrentPlayer().getSpace()].run(game);
            }
        } else if(cardType.equals("Income Tax")) {
            System.out.println("Press 1 to pay 10% of your total value OR");
            System.out.println("Press 2 to pay 200");
            int choice = game.user.nextInt();
            if (choice == 1) {
                game.getCurrentPlayer().incrementMoney((int) (game.getCurrentPlayer().getTotalValue()*-.1));
            } else if (choice == 2) {
                game.getCurrentPlayer().incrementMoney(-200);
            }
        } else if(cardType.equals("Go to jail!")) {
            game.getCurrentPlayer().setInJail(true);
        } else if(cardType.equals("Luxury Tax")) {
            System.out.println("Paying $75...");
            game.getCurrentPlayer().incrementMoney(-75);
        }
    }

    public ChanceOrComChest generateCCorCH(Board board, String type) {
        if(type.equals("Community Chest")) {
            int randomNum = (int) (Math.random()*board.getComChest().size());
            return board.getComChest().get(randomNum);
        } else {
            int randomNum = (int) (Math.random()*board.getChance().size());
            return board.getChance().get(randomNum);
        }
    }

}