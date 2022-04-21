import javax.sound.sampled.SourceDataLine;

/**
 * Buy class allows the user to 
 * buy assets. It extends the abstract
 * class Trade.
 */

public class Buy implements Trade{
    public void trade(String stock, double amount, Account account, Market m) { //trade method (Buy class)
        double cost = 0; //initalises the method cost
        int stockNo = account.assetInt(stock); //gets the amount of assets held by the account
        if (m.getClass().getSimpleName() == "MarketCrypto") { //checks whether the asset is crypto or stocks
            stockNo = stockNo - 2;
        }
        cost = m.getCurrentPrice(stockNo) * amount; //calculates the cost
        if (cost < account.getBalance()) {
            amount = amount + account.getAssetHeld(stock);
            account.addAsset(stock, amount);
            new PopUp("Purchase Successful");
        }
        account.withdraw(cost); //calls the method in Account in order to take away the money
    }
}