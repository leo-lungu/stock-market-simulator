public class Menu{

    private Account account; //creates the account variable
    public static void main(String[] args) {
        new Menu(); //constructor method and starts the program
    }

    public Menu() {
        account = new Account();
        GUI f = new GUI(account); //calls the gui
    }
}
