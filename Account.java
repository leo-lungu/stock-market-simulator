import java.util.ArrayList;

public class Account{
    //creates the variables
    private int balance;
    private double interest = 0.01;
    static int counter;
    String currency;
    ArrayList<ArrayList<Stocks>> stockHoldings = new ArrayList<ArrayList<Stocks>>();


    public Account(){
        this.balance=0; //initialises the account balance
    }    

    public Account(int balance){
        this.balance = balance; //sets the account balance
    }


    public Account(int balance, double interestRate){ //account constructor but for accounts with a special interest rate
        this.interest = interestRate; //sets interest rate too
        this.balance = balance;
    }

    public double getInterest() { //gets the interest
        return this.interest;
    }

    public int getBalance(){ //gets balance
        return this.balance;
    }    

    public void setBalance(int amount){ //sets balance
        this.balance = amount;
    }

    public void setCurrency(String currency){ //sets balance
        this.currency = currency;
    }

    public String getCurrency(){ //gets balance
        return this.currency;
    }   

    public void deposit(int amount){ //deposits into the account
        this.balance += amount;
    }
    
    public void withdraw(int amount) { //withdraws from the account
        if (amount > this.balance) { //checks whether there is enough money on the account
            System.out.println("Error. The amount to be withdrawn exceeds this account's balance."); //if there isn't, user gets a method
        } else {
            this.balance -= amount; //if there is, money is withdrawn
        }
    }

    public int getUniqueId() { //uniqueid
        int id = 0; //initialises an id
        id = counter++; //adds onto it
        return id;
    }


    public void addStock(Stocks stock) {
        this.stockHoldings.add(stock);
    }
}
