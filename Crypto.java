/**
 * Subclass of Asset.
 * Creates the cryptocurrencies.
 */

public class Crypto extends Asset{
    private double differentTrades; //instance variables
    private double stakeRate;
    public Crypto(String ticker, double currentPrice, double stakeRate) { //constructor
        super(ticker, currentPrice);
        this.differentTrades = 0.005;
        this.stakeRate =  1.0005;
    }

    public double getStakeRate() { //gets the stake rate of the currency
        return this.stakeRate;
    }    
}
