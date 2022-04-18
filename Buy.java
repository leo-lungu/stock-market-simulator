/**
 * Buy class allows the user to 
 * buy assets. It extends the abstract
 * class Trade.
 */

public class Buy extends Trade{
    public void trade(String stock, double amount, Account account, Market m) { //trade method (Buy class)
        double cost = 0; //initalises the method cost
        int stockNo = account.stockInt(stock); //gets the amount of assets held by the account
        if (m.getClass().getSimpleName() == "MarketCrypto") { //checks whether the asset is crypto or stocks
            stockNo = stockNo - 3;
        }
        cost = m.getCurrentPrice(stockNo) * amount; //calculates the cost
        account.withdraw(cost); //calls the method in Account in order to take away the money
        if (cost < account.getBalance()) {
            amount = amount + account.getStockHeld(stock);
            account.addStock(stock, amount);
            new PopUp("Purchase Successful");
        } else {
            new PopUp("Error: Not enough money in the balance");
        }
    }
}