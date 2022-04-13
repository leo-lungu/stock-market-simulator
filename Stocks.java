public abstract class Stocks{
    private String ticker;
    private double currentPrice;
    private double differentTrades = 0.001;

    public Stocks(String ticker, double currentPrice) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
    }


    public void setPrice(double newPrice) {
        this.currentPrice = newPrice;
    }

    public double getPrice() {
        return this.currentPrice;
    }

    public double getInterest() {
        return 0;
    }    

    public double getDifferenceTrades() {
        return this.differentTrades;
    }
}