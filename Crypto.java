public class Crypto extends Asset{
    double differentTrades;
    double stakeRate;
    public Crypto(String ticker, double currentPrice, double stakeRate) {
        super(ticker, currentPrice);
        this.differentTrades = 0.005;
        this.stakeRate =  1.0005;
    }

    public double getStakeRate() {
        return this.stakeRate;
    }    
}
