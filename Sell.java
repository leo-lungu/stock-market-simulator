public class Sell extends Trade {
    public Sell() {
    }

    public void trade(String stock, double amount, User user, Market m) {
        System.out.println(user.getAccount().getStockHeld(stock));
        amount = checkEnoughStocks(stock, amount, user);
        amount = user.getAccount().getStockHeld(stock) - amount;
        System.out.println(amount);
        user.getAccount().addStock(stock, amount);
    }

    public double checkEnoughStocks(String stock, double amount, User user) {
        if (amount > user.getAccount().getStockHeld(stock)) {
            System.out.println("You don't have enough stocks.");
            amount = user.getAccount().getStockHeld(stock);
        }
        System.out.println("amount: " + amount);
        return amount;
    }
}