/**
 * Abstract class which is extended
 * by classes Buy and Sell.
 */


public abstract class Trade{ //abstract class

    public abstract void trade(String stock, double amount, Account account, Market m); //abstract method used in Buy and Sell

}