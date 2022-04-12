public class Stocks{
    private String ticker;
    private double currentPrice;

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

    public String getTicker() {
        return this.ticker;
    }


}
