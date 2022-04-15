public class Asset{
    private String ticker;
    private double currentPrice;
    private double differentTrades = 0.001;

    public Asset(String ticker, double currentPrice) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
    }


    public void setPrice(double newPrice) {
        this.currentPrice = newPrice;
    }

    public double getPrice() {
        return this.currentPrice;
    }

    public double getDifferenceTrades() {
        return this.differentTrades;
    }
}