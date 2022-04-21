public class Main{

    private Account account; //creates the account variable
    public static void main(String[] args) {
        new Main(); //constructor method and starts the program
    }

    public Main() {
        account = new Account();
        GUI f = new GUI(account); //calls the gui
    }
}
