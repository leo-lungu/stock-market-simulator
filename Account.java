import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Account{
    //creates the variables
    private double balance;
    static int counter;
    ArrayList<Double> stocksHeld = new ArrayList<Double>();

    public Account(){
        this.balance=0; //initialises the account balance
        this.stocksHeld.add(0.0);
        this.stocksHeld.add(0.0);
        this.stocksHeld.add(0.0);
        this.stocksHeld.add(0.0);
    }    

    public Account(double balance){
        this.balance = balance; //sets the account balance
    }

    public double getBalance(){ //gets balance
        return this.balance;
    }    

    public void deposit(double amount) throws IncorrectAmountException{ //deposits into the account
        if (amount < 0) {
            throw new IncorrectAmountException("Must be a positive number!");
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

    public void addStock(String stock, double amount) {
        if (stock.equals("AAPL")) {
            this.stocksHeld.set(0, amount);
        } else if(stock.equals("NVDA")) {
            this.stocksHeld.set(1, amount);
        } else if (stock.equals("GOOG")) {
            this.stocksHeld.set(2, amount);
        } else if (stock.equals("BTC")) {
            this.stocksHeld.set(3, amount);
        } 
    }

    public double getStockHeld(String stock) {
        double stockNo = 0;
        if (stock.equals("AAPL")) {
            stockNo = this.stocksHeld.get(0);
        } else if(stock.equals("NVDA")) {
            stockNo = this.stocksHeld.get(1);
        } else if (stock.equals("GOOG")) {
            stockNo = this.stocksHeld.get(2);
        } else if (stock.equals("BTC")) {
            stockNo = this.stocksHeld.get(3);
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
        } else if (stock.equals("BTC")) {
            stockNo = 3;
        } 
        return stockNo;
    }

    public ArrayList<Double> getPortfolio() {
        return this.stocksHeld;
    }

    public void loadFile() {
        try {
            File myObj = new File("account.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
        }
          myReader.close();
        } catch (Exception e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
}
