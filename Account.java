import java.util.ArrayList;

public class Account{
    //creates the variables
    private double balance;
    private double interest = 0.01;
    static int counter;
    String currency;
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


    public Account(double balance, double interestRate){ //account constructor but for accounts with a special interest rate
        this.interest = interestRate; //sets interest rate too
        this.balance = balance;
    }

    public double getInterest() { //gets the interest
        return this.interest;
    }

    public double getBalance(){ //gets balance
        return this.balance;
    }    

    public void setBalance(double amount){ //sets balance
        this.balance = amount;
    }

    public void deposit(double amount){ //deposits into the account
        this.balance += amount;
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
        } else if (stock.equals("AMZN")) {
            this.stocksHeld.set(2, amount);
        } 
    }

    public int getStockHeld(String stock) {
        int stockNo = 0;
        if (stock.equals("AAPL")) {
            stockNo = this.stocksHeld.get(0);
        } else if(stock.equals("NVDA")) {
            stockNo = this.stocksHeld.get(1);
        } else if (stock.equals("AMZN")) {
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
        } else if (stock.equals("AMZN")) {
            stockNo = 2;
        } 
        return stockNo;
    }

    public ArrayList<Integer> getPortfolio() {
        return this.stocksHeld;
    }
}
