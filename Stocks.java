public class Stocks{
    private String ticker;
    private double currentPrice;
    private double maxPrice;
    private double minPrice;

    public Stocks(String ticker, double currentPrice, double maxPrice, double minPrice) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public void setPrice(double newPrice) {
        this.currentPrice = newPrice;
    }

    public double getPrice() {
        return this.currentPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMaxPrice() {
        return this.maxPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMinPrice() {
        return this.minPrice;
    }

    public String getTicker() {
        return this.ticker;
    }


}
