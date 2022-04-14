public class Sell implements Trade {
    public Sell() {
    }

    public void trade(String stock, int amount, User user, Market m) {
        System.out.println(user.getAccount().getStockHeld(stock));
        amount = checkEnoughStocks(stock, amount, user, m);
        amount = user.getAccount().getStockHeld(stock) - amount;
        System.out.println(amount);
        user.getAccount().addStock(stock, amount);
    }

    public int checkEnoughStocks(String stock, int amount, User user, Market m) {
        if (amount > user.getAccount().getStockHeld(stock)) {
            System.out.println("You don't have enough stocks.");
            amount = user.getAccount().getStockHeld(stock);
        }
        System.out.println("amount: " + amount);
        return amount;
    }
}