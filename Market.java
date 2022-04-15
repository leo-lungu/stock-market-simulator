import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Market{ 

    boolean marketOn = true;
    private ArrayList<Asset> assets;

    public Market() {
        this.assets = new ArrayList<Asset>();
        Asset AAPL = new Stock("AAPL", 180);
        Asset NVDA = new Stock("NVDA", 2680);
        Asset GOOG = new Stock("GOOG", 550);
        assets.add(AAPL);
        assets.add(NVDA);
        assets.add(GOOG);
    
        Thread thread = new Thread(new Runnable() {
            public void run() {
                marketRunning();
            }
        });
        thread.start();   
    }
    
    public void marketRunning() {
        boolean a = true;
        try {
            while (a = getMarketOn()) {
                double marketChange0 = new Random().nextDouble() * (1 + (assets.get(0).getDifferenceTrades()) - (1 - (assets.get(0).getDifferenceTrades()))) + (1 - (assets.get(0).getDifferenceTrades())); 
                assets.get(0).setPrice(assets.get(0).getPrice()*marketChange0);
                double marketChange1 = new Random().nextDouble() * (1 + (assets.get(1).getDifferenceTrades()) - (1 - (assets.get(1).getDifferenceTrades()))) + (1 - (assets.get(1).getDifferenceTrades())); 
                assets.get(1).setPrice(assets.get(1).getPrice()*marketChange1);
                double marketChange2 = new Random().nextDouble() * (1 + (assets.get(2).getDifferenceTrades()) - (1 - (assets.get(2).getDifferenceTrades()))) + (1 - (assets.get(2).getDifferenceTrades())); 
                assets.get(2).setPrice(assets.get(2).getPrice()*marketChange2);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getMarketOn() {
        return this.marketOn;
    }

    public boolean marketOnFalse() {
        return this.marketOn = false;
    }

    public ArrayList<Asset> getAsset() {
        return this.assets;
    }

    public void setAsset(Asset asset) {
        this.assets.add(asset);
    }

    public double getCurrentPrice(int i) {
        return this.assets.get(i).getPrice();
    }
}
