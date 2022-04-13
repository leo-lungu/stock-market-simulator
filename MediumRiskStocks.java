public class MediumRiskStocks extends Stocks{
    double interest;
    double differentTrades;
    public MediumRiskStocks(String ticker, double currentPrice) {
        super(ticker, currentPrice);
        this.interest =  1.00025;
        this.differentTrades = 0.003;
    }

    
    public double getInterest() {
        return this.interest;
    }

    public double getDifferenceTrades() {
        return this.differentTrades;
    }
}
