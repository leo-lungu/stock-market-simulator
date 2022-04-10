import java.util.*;

public class Stocks {
    private String ticker;
    private double currentPrice;
    private double maxPrice;
    private double minPrice;
    private Random random;

    public Stocks(String ticker, double currentPrice, double maxPrice, double minPrice) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public void setPrice(int newPrice) {
        this.currentPrice = newPrice;
    }

    public double getPrice() {
        return this.currentPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMaxPrice() {
        return this.maxPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public double getMinPrice() {
        return this.minPrice;
    }

    public String getTicker() {
        return this.ticker;
    }

}
