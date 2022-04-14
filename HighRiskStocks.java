
public class HighRiskStocks extends Stocks{
    double interest;
    double differentTrades;
    public HighRiskStocks(String ticker, double currentPrice) {
        super(ticker, currentPrice);
        this.interest =  1.0005;
        this.differentTrades = 0.005;
    }
    
    public double getInterest() {
        return this.interest;
    }

    public double getDifferenceTrades() {
        return this.differentTrades;
    }
}
