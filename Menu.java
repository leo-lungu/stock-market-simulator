import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;

public class Menu {
    public static void main(String[] args) {

        Client user = new Client();
        //new Menu(user);
        ArrayList<Stocks> stocks = new ArrayList<Stocks>();
        stocks.add(new Stocks("AAPL", 180, 190, 170));
        stocks.add(new Stocks("NVDA", 2680, 2690, 2150));
        stocks.add(new Stocks("AMZN", 550, 610, 510));
        gui f = new gui();
    }

    /*public Menu(Client user) {
        System.out.println("Stocks!");
        user.setCurrency(currency());
        System.out.println("How much would you like to deposit?");
        user.deposit(scannerInt());
        System.out.println("Current balance: " + user.getBalance() + " " + user.getCurrency()); 
    }

    public static String currency(){
        String currency = "";
        System.out.println("Before you start, you need to select a currency.");;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        ArrayList<String> currencies = new ArrayList<String>();
        System.out.println("Currencies available: GBP | EUR | USD");
        currency = scanner();
        currencies.add("GBP");
        currencies.add("USD");
        currencies.add("EUR");

        while (!currencies.contains(currency)) {
            System.out.println("Currencies available: GBP | EUR | USD");
            currency = scanner();
        }
        System.out.println("Selected: " + currency);
        return currency;
    }*/

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        text = scanner.nextLine();
        return text;
    }

    public static int scannerInt() {
        Scanner scanner = new Scanner(System.in);
        int text = 0;
        text = Integer.parseInt(scanner.nextLine());
        return text;
    }
}
