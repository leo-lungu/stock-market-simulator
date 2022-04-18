/**
 * Buy class allows the account to
 * sell assets. It extends the abstract
 * class Trade.
 */

public class Sell extends Trade {

    public void trade(String stock, double amount, Account account, Market m) { //trade method (Sell class)
        amount = checkEnoughStocks(stock, amount, account, m); //calls another method to check the account has enough stocks to sell
        amount = account.getStockHeld(stock) - amount; //if the account has enough stocks, they sell
        account.addStock(stock, amount); //sets the new amount
    }

    public double checkEnoughStocks(String stock, double amount, Account account, Market m) { //checks the account has noeuhg stocks
        if (amount > account.getStockHeld(stock)) { //checks whether the amount is less than the account
            new PopUp("Error: You don't have enough stocks!");
            amount = account.getStockHeld(stock); //only sells what the account has.
        }
        double cost = 0;
        int stockNo = account.stockInt(stock);
        if (m.getClass().getSimpleName() == "MarketCrypto") { //checks whether the asset belongs to the Crypto class
            stockNo = stockNo - 3;
        }
        cost = m.getCurrentPrice(stockNo) * amount; //calculates the money the account has made
        account.deposit(cost); //added to the balance
        new PopUp("Sale Successful");
        return amount;
    }
}