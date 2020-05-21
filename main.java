class Main {
    public static void main(String[] args) {
        introduceGame();
        Game game = new Game();
    }

    public static void introduceGame() { //OPT: static method
        System.out.println("Welcome to Simplified Monopoly Console Game!");
        System.out.println("\tNote: when asked to press a key, press the key AND enter");
        System.out.println("Description: This is a console game *simplified* version of monopoly. Created by Indu, Aden, and Priya from G3.\n\n");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Differences from Normal Monopoly: "
            + "\n\t1. You can't purchase houses or hotels."
            + "\n\t2. You cant't sell property to other players or mortage your properties."
            + "\n\t3. You start with $2000 instead of $1500."
            + "\n\t4. The banker is the program."
            + "\n\t5. You can have a negative bank balance, but if you do at the end of the game," 
            + "\n\t   you are automatically not a winner. You can have no winners if everyone has a negative balance"
        );
        
    }
}