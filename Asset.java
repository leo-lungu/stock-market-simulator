/**
 * Superclass for the classes Stock and Crypto.
 * Holds the super methods and lets the other
 * classes do what they need to.
 */

public class Asset{ //initialises instance variables
    private String ticker;
    private double currentPrice;
    private double differentTrades = 0.001;

    public Asset(String ticker, double currentPrice) { //constructor method for the Assets
        this.ticker = ticker;
        this.currentPrice = currentPrice;
    }

    public void setPrice(double newPrice) { //method to set the price
        this.currentPrice = newPrice;
    }

    public double getPrice() { //returns the price of the asset
        return this.currentPrice;
    }

    public double getDifferenceTrades() { //returns the rate an asset can go up or down
        return this.differentTrades;
    }
}