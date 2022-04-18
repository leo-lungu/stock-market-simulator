/**
 * Subclass of Asset.
 * Creates the stocks.
 */

public class Stock extends Asset{ //instance variables
    private double differentTrades;
    public Stock(String ticker, double currentPrice) {
        super(ticker, currentPrice);
        this.differentTrades = 0.005; //sets the difference in trades
    }
    

}
