/**
 * Buy class allows the account to
 * sell assets. It extends the abstract
 * class Trade.
 */

public class Sell implements Trade {

    public void trade(String stock, double amount, Account account, Market m) { //trade method (Sell class)
        amount = checkEnoughStocks(stock, amount, account, m); //calls another method to check the account has enough stocks to sell
        amount = account.getAssetHeld(stock) - amount; //if the account has enough stocks, they sell
        account.addAsset(stock, amount); //sets the new amount
    }

    public double checkEnoughStocks(String stock, double amount, Account account, Market m) { //checks the account has enough stock
        if (amount == 0) {
            new PopUp("Error: You don't have the selected assets!");
        } else if (amount > account.getAssetHeld(stock)) { //checks whether the amount is less than the account
            new PopUp("Warning: You don't have enough assets! Only selling: " + account.getAssetHeld(stock) + " assets.");
            amount = account.getAssetHeld(stock); //only sells what the account has.
        } else {
            double cost = 0;
            int stockNo = account.assetInt(stock);
            if (m.getClass().getSimpleName() == "MarketCrypto") { //checks whether the asset belongs to the Crypto class
                stockNo = stockNo - 2;
            }
            cost = m.getCurrentPrice(stockNo) * amount; //calculates the money the account has made
            account.deposit(cost); //added to the balance
            new PopUp("Sale Successful!");
        }
        return amount;
    }
}