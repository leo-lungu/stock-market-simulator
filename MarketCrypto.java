/**
 * The CryptoMarket class updates the
 * prices of the cryptocurrencies, and is a subclass
 * of the class MarketCrypto.
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MarketCrypto extends Market{ //sublcass
    
    public MarketCrypto(Account account) { //constructor to get the prices of the cryptocurrencies
        String filePath = "cryptoprices.txt";
        Scanner file = readAssets(filePath, null);
        setCrypto(file, account);
    }

    public void setCrypto(Scanner file, Account account) { //sets the crypto prices
        Asset BTC = new Crypto("BTC", Double.parseDouble(file.nextLine()), 1.0005); //this has a stakerate unlike stocks
        Asset ETH = new Crypto("ETH", Double.parseDouble(file.nextLine()), 1.0005); 
        getAsset().add(BTC); //adds the cryptocurrency to the asset arraylist
        getAsset().add(ETH);
        
        Thread threadCryptoMarket = new Thread(new Runnable() { //thread to run in the background
            public void run() {
                cryptoStake(BTC, ETH, account); //only calls the cryptoStake method, as the marketRunning is called by Market as it is a subclass
            }
        });
        threadCryptoMarket.start(); //starts the thread
    }

    public void marketRunning() { //method
        try {
            Thread.sleep(500); //waits half a second before starting the pricing
            while (true) { //runs for the entirity of the prgoram
                double marketChange0 = new Random().nextDouble() * (1 + (getAsset().get(0).getDifferenceTrades()) - (1 - (getAsset().get(0).getDifferenceTrades()))) + (1 - (getAsset().get(0).getDifferenceTrades()));
                marketChange0 = cryptoCrashMarket(marketChange0); //calls a method for market crashes
                getAsset().get(0).setPrice(getAsset().get(0).getPrice()*marketChange0);

                double marketChange1 = new Random().nextDouble() * (1 + (getAsset().get(1).getDifferenceTrades()) - (1 - (getAsset().get(1).getDifferenceTrades()))) + (1 - (getAsset().get(1).getDifferenceTrades()));
                marketChange1 = cryptoCrashMarket(marketChange1); //calls a method for market crashes
                getAsset().get(1).setPrice(getAsset().get(1).getPrice()*marketChange1);
                TimeUnit.SECONDS.sleep(1); //waits one second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double cryptoCrashMarket(double marketChange0) { //market crash method
        Random r = new Random(); //generates a random chance of the market crashing
        double crashValue = 0.2 + (0.4 - 0.2) * r.nextDouble(); //if the market crashes, the price will drop to 20%-40% of the previous price
        double change = 0 + (500) * r.nextDouble(); //a chance between 0 to 500
        if (change < 1) { //if the number is below 1
            marketChange0 = crashValue; //market crashes
        }
        return marketChange0;
    }

    public void cryptoStake(Asset BTC, Asset ETH, Account account) { //stakes the cryptocurrency (interest)
        try {
            Thread.sleep(100); //waits 0.1 seconds beofre it starts running the market
            while (true) { //for the entirity of the program it runs in the background
                double stake0 = ((Crypto) BTC).getStakeRate(); //gets the stake rate
                double amountCrypto0 = (account.getAssetHeld("BTC") * stake0); //calculates the new amount of crypto held
                account.addAsset("BTC", amountCrypto0);
                double stake1 = ((Crypto) ETH).getStakeRate(); //gets the stake rate
                double amountCrypto1 = (account.getAssetHeld("ETH") * stake1); //calculates the new amount of crypto held
                account.addAsset("ETH", amountCrypto1);
                TimeUnit.SECONDS.sleep(1); //waits for 1 second before repeating in order to avoid
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}
