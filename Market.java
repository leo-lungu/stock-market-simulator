import java.util.*;
import java.util.concurrent.TimeUnit;


public class Market{ 

    boolean marketOn = true;
    private ArrayList<Stocks> stocks;

    public Market() {
        this.stocks = new ArrayList<Stocks>();
        stocks.add(new Stocks("AAPL", 180));
        stocks.add(new Stocks("NVDA", 2680));
        stocks.add(new Stocks("AMZN", 550));
    
        Thread thread = new Thread(new Runnable() {
            public void run() {
                marketRunning();
            }
        });
        thread.start();   
    }
    
    public void marketRunning() {
        boolean a = true;
        while (a = getMarketOn()) {
            double marketChange0 = new Random().nextDouble() * (1.02 - 0.98) + 0.98; 
            stocks.get(0).setPrice(stocks.get(0).getPrice()*marketChange0);
            double marketChange1 = new Random().nextDouble() * (1.02 - 0.98) + 0.98; 
            stocks.get(1).setPrice(stocks.get(1).getPrice()*marketChange1);
            double marketChange2 = new Random().nextDouble() * (1.02 - 0.98) + 0.98; 
            stocks.get(2).setPrice(stocks.get(2).getPrice()*marketChange2);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean getMarketOn() {
        return this.marketOn;
    }

    public boolean marketOnFalse() {
        return this.marketOn = false;
    }

    public double getCurrentPrice(int i) {
        return this.stocks.get(i).getPrice();
    }
}
