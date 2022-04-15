import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MarketCrypto extends Market{
    
    public MarketCrypto(User user) {
        Crypto btc = new Crypto("BTC", 60000, 1.0005);
        setAsset(btc);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                cryptoStake(btc, user);
            }
        });
        thread.start();  
        
    }

    public void marketRunning() {
        boolean a = true;
        try {
            Thread.sleep(100);
            while (a = getMarketOn()) {
                double marketChange0 = new Random().nextDouble() * (1 + (getAsset().get(3).getDifferenceTrades()) - (1 - (getAsset().get(3).getDifferenceTrades()))) + (1 - (getAsset().get(3).getDifferenceTrades()));
                marketChange0 = cryptoCrashMarket(marketChange0); 
                getAsset().get(3).setPrice(getAsset().get(3).getPrice()*marketChange0);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double cryptoCrashMarket(double marketChange0) {
        Random r = new Random();
        double crashValue = 0.2 + (0.4 - 0.2) * r.nextDouble();
        double change = 0 + (100) * r.nextDouble();
        if (change < 1) {
            marketChange0 = crashValue;
        }
        return marketChange0;
    }

    public void cryptoStake(Crypto btc, User user) {
        boolean a = true;
        try {
            Thread.sleep(100);
            while (a = getMarketOn()) {
                double stake = btc.getStakeRate();
                double amountStock = (user.getAccount().getStockHeld("BTC")*stake);
                user.getAccount().addStock("BTC", amountStock);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
