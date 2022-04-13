import java.util.ArrayList;

public class Account{
    //creates the variables
    private double balance;
    static int counter;
    ArrayList<Integer> stocksHeld = new ArrayList<Integer>();

    public Account(){
        this.balance=0; //initialises the account balance
        this.stocksHeld.add(0);
        this.stocksHeld.add(0);
        this.stocksHeld.add(0);
    }    

    public Account(double balance){
        this.balance = balance; //sets the account balance
    }

    public double getBalance(){ //gets balance
        return this.balance;
    }    

    public void deposit(double amount){ //deposits into the account
        if (amount < 0) {
            System.out.println("Must be positive.");
        } else {
            this.balance += amount;
        }
    }
    
    public void withdraw(double cost) { //withdraws from the account
        if (cost > this.balance) { //checks whether there is enough money on the account
            System.out.println("Error. The amount to be withdrawn exceeds this account's balance."); //if there isn't, user gets a method
        } else {
            this.balance -= cost; //if there is, money is withdrawn
        }
    }

    public void addStock(String stock, int amount) {
        if (stock.equals("AAPL")) {
            this.stocksHeld.set(0, amount);
        } else if(stock.equals("NVDA")) {
            this.stocksHeld.set(1, amount);
        } else if (stock.equals("GOOG")) {
            this.stocksHeld.set(2, amount);
        } 
    }

    public int getStockHeld(String stock) {
        int stockNo = 0;
        if (stock.equals("AAPL")) {
            stockNo = this.stocksHeld.get(0);
        } else if(stock.equals("NVDA")) {
            stockNo = this.stocksHeld.get(1);
        } else if (stock.equals("GOOG")) {
            stockNo = this.stocksHeld.get(2);
        } 
        return stockNo;
    }

    public int stockInt(String stock) {
        int stockNo = 0;
        if (stock.equals("AAPL")) {
            stockNo = 0;
        } else if(stock.equals("NVDA")) {
            stockNo = 1;
        } else if (stock.equals("GOOG")) {
            stockNo = 2;
        } 
        return stockNo;
    }

    public ArrayList<Integer> getPortfolio() {
        return this.stocksHeld;
    }
}
