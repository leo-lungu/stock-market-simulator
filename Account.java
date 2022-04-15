import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Account{
    //creates the variables
    private double balance;
    static int counter;
    ArrayList<Double> stocksHeld = new ArrayList<Double>();

    public Account(){
        try {
            File file = new File("account.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("account");
                Node nNode = nList.item(0);
                    Element eElement = (Element) nNode;
                    this.balance = (Double.parseDouble(eElement.getElementsByTagName("balance").item(0).getTextContent()));
                    this.stocksHeld.add(Double.parseDouble(eElement.getElementsByTagName("aapl").item(0).getTextContent()));
                    this.stocksHeld.add(Double.parseDouble(eElement.getElementsByTagName("nvda").item(0).getTextContent()));
                    this.stocksHeld.add(Double.parseDouble(eElement.getElementsByTagName("goog").item(0).getTextContent()));
                    this.stocksHeld.add(Double.parseDouble(eElement.getElementsByTagName("btc").item(0).getTextContent()));
        }
        catch(Exception e) {
            System.out.println(e);
        } 
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
}
