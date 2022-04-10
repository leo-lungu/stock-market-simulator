public class Buy implements Trade{
    public static void buyStock(String stock, int amount, User user) {
        System.out.println(user.getAccount().getStockHeld(stock));
        amount = amount + user.getAccount().getStockHeld(stock);
        System.out.println(amount);
        user.getAccount().addStock(stock, amount);
    }


}
