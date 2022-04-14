public class Buy implements Trade{
    public Buy(){}

    public void trade(String stock, int amount, User user, Market m) {
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

    public int checkEnoughStocks(String stock, int amount, User user, Market m) {
        return 0;
    }
}