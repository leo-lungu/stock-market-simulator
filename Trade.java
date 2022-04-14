public interface Trade{

    public abstract void trade(String stock, int amount, User user, Market m);

    public abstract int checkEnoughStocks(String stock, int amount, User user, Market m);
}