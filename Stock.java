
public class Stock extends Asset{
    double interest;
    double differentTrades;
    public Stock(String ticker, double currentPrice) {
        super(ticker, currentPrice);
        this.interest =  1.0005;
        this.differentTrades = 0.005;
    }
    

}
