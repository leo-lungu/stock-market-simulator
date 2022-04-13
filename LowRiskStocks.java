public class LowRiskStocks extends Stocks{
    double interest;
    double differentTrades;
    public LowRiskStocks(String ticker, double currentPrice) {
        super(ticker, currentPrice);
        this.interest =  1.00025;
        this.differentTrades = 0.0025;
    }
}
