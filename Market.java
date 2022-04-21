/**
 * The Market class updates the
 * prices of the stocks, and is a superclass
 * of the class MarketCrypto.
 */

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class Market{ 
    //initialises the instance variables
    boolean marketOn = true;
    private ArrayList<Asset> assets;

    public Market() { //constructor to set up the market prices
        String filePath = "stockprices.txt"; //uses the text file to import previous prices
        Scanner file = readAssets(filePath, null);
        setStocks(file);
        
        
        Thread threadMarket = new Thread(new Runnable() { //multi threading - runs the method marketRunning() simultaneous to the program
            public void run() {
                marketRunning();
            }
        });
        threadMarket.start(); //starts the new thread
    }
    
    public Scanner readAssets(String filePath, Account account) { //method to read the stocks from the files
        Scanner file = null;
        try {
            file = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.assets = new ArrayList<Asset>();
        return file;
    }

    public void setStocks(Scanner file) { //sets the stocks in the arraylist of type Asset
        Asset AAPL = new Stock("AAPL", Double.parseDouble(file.nextLine())); //takes the prices from the file
        Asset NVDA = new Stock("NVDA", Double.parseDouble(file.nextLine()));
        assets.add(AAPL);
        assets.add(NVDA);
    }

    public void marketRunning() { //this method runs in the background
        try {
            while (true) { //for the entirity of the program, it runs
                double marketChange0 = new Random().nextDouble() * (1 + (assets.get(0).getDifferenceTrades()) - (1 - (assets.get(0).getDifferenceTrades()))) + (1 - (assets.get(0).getDifferenceTrades())); 
                assets.get(0).setPrice(assets.get(0).getPrice()*marketChange0); //calculates the new prices using random algorithm
                double marketChange1 = new Random().nextDouble() * (1 + (assets.get(1).getDifferenceTrades()) - (1 - (assets.get(1).getDifferenceTrades()))) + (1 - (assets.get(1).getDifferenceTrades())); 
                assets.get(1).setPrice(assets.get(1).getPrice()*marketChange1);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Asset> getAsset() { //gets the asset
        return this.assets;
    }

    public void setAsset(Asset asset) { //sets the asset in the arraylist
        this.assets.add(asset);
    }

    public double getCurrentPrice(int i) { //gets the price held in the arraylist
        return this.assets.get(i).getPrice();
    }

    public void saveProgress(String filePath) { //saves the prices of the assets in the text file
        File oldFile = new File(filePath); //takes the file
        oldFile.delete(); //and deletes it (in order to make new space for the new prices)
        FileWriter myWriter;
        try {
            File file = new File(filePath);
            file.createNewFile(); //creates a new file of the same name, but blank
            myWriter = new FileWriter(filePath);
            for (int i = 0; i < getAsset().size(); i++) { //writes in each line the asset price
                myWriter.write(String.valueOf(getCurrentPrice(i)));
                myWriter.write("\r\n"); //creates new line
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
