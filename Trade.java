public class Trade{

    public static void buyStock(String stock, int amount, User user, Market m) {
        double cost = 0;
        int stockNo = user.getAccount().stockInt(stock);
        cost = m.getCurrentPrice(stockNo) * amount;
        user.getAccount().withdraw(cost);
        if (cost < user.getAccount().getBalance()) {
            amount = amount + user.getAccount().getStockHeld(stock);
            user.getAccount().addStock(stock, amount);
        } else {
        }
        System.out.println(amount);
    }

    public static void sellStock(String stock, int amount, User user) {
        System.out.println(user.getAccount().getStockHeld(stock));
        amount = checkEnoughStocks(stock, amount, user);
        amount = user.getAccount().getStockHeld(stock) - amount;
        System.out.println(amount);
        user.getAccount().addStock(stock, amount);
    }

    public static int checkEnoughStocks(String stock, int amount, User user) {
        if (amount > user.getAccount().getStockHeld(stock)) {
            System.out.println("You don't have enough stocks.");
            amount = user.getAccount().getStockHeld(stock);
        }
        System.out.println("amount: " + amount);
        return amount;
    }
}