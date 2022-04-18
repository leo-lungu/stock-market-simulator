import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class hold the accounts information
 * such as balance, the assets held and
 * to add or remove such things from these
 * variables.
 */

public class Account{ //creates the instance variables which will be used throughout the program
    private double balance;
    ArrayList<Double> stocksHeld = new ArrayList<Double>();

    public Account(){ //account constructor - sets up the account
        Scanner file = null;
        try {
            file = new Scanner(new File("account.txt")); //reads the balance and assets held from the text file
        } catch (FileNotFoundException e) {
            new PopUp("Error: file not found.");
            e.printStackTrace();
        }
        this.balance = Double.parseDouble(file.nextLine()); //reads line by line
        this.stocksHeld.add(Double.parseDouble(file.nextLine()));
        this.stocksHeld.add(Double.parseDouble(file.nextLine()));
        this.stocksHeld.add(Double.parseDouble(file.nextLine()));
        this.stocksHeld.add(Double.parseDouble(file.nextLine()));

    }    

    public double getBalance(){ //gets balance
        return this.balance;
    }

    public void setBalance(int amount){ //sets new balance
        this.balance = amount;
    }

    public void deposit(double amount) { //deposits into the account
        if (amount < 0) {
        } else {
            this.balance += amount;
        }
    }
    
    public void withdraw(double cost) { //withdraws from the account
        if (cost > this.balance) { //checks whether there is enough money on the account
            new PopUp("Error: Not enough money!");
        } else {
            this.balance -= cost; //takes the money if there is money
        }
    }

    public void addStock(String stock, double amount) { //adds the holdings of the user
        switch (stock) {
            case "AAPL":
                this.stocksHeld.set(0, amount);
                break;
            case "NVDA":
                this.stocksHeld.set(1, amount);
                break;
            case "GOOG":
                this.stocksHeld.set(2, amount);
                break;
            case "BTC":
                this.stocksHeld.set(3, amount);
                break;
        }
    }

    public double getStockHeld(String stock) { //gets how much the user holds by asset
        double stockNo = 0;
        switch (stock) {
            case "AAPL":
                stockNo = this.stocksHeld.get(0);
                break;
            case "NVDA":
                stockNo = this.stocksHeld.get(1);
                break;
            case "GOOG":
                stockNo = this.stocksHeld.get(2);
                break;
            case "BTC":
                stockNo = this.stocksHeld.get(3);
                break;
        }
        return stockNo; //returns
    }

    public int stockInt(String stock) { //returns the stock as an integer so that it is easily identified
        int stockNo = 0;
        switch (stock) {
            case "AAPL":
                stockNo = 0;
                break;
            case "NVDA":
                stockNo = 1;
                break;
            case "GOOG":
                stockNo = 2;
                break;
            case "BTC":
                stockNo = 3;
                break;
        }
        return stockNo;
    }

    

    public void saveProgress() { //saves the progress by the user in a text file
        File oldFile = new File("account.txt"); //file path
        oldFile.delete(); //it deletes the file
        FileWriter myWriter;
        try {
            File file = new File("account.txt"); //then creates a new one, so that it is blank
            file.createNewFile();
            myWriter = new FileWriter("account.txt");
            myWriter.write(String.valueOf(getBalance())); //writes in the file the information
            myWriter.write("\r\n" + getStockHeld("AAPL"));
            myWriter.write("\r\n" + getStockHeld("NVDA"));
            myWriter.write("\r\n" + getStockHeld("GOOG"));
            myWriter.write("\r\n" + getStockHeld("BTC"));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
